package com.tensquare.article.service;

import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

/**
 * Created by ljq on 2018/10/29.
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 文章审核
     * @param id
     */
    @Transactional
    public void examine(String id){
        articleDao.examine(id);
    }

    /**
     * 点赞
     * @param id 文章ID
     * @return
     */
    @Transactional
    public int updateThumbup(String id){
        return articleDao.updateThumbup(id);
    }

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Article findById(String id) {
        //从缓存中提取
        Article article= (Article)redisTemplate.opsForValue().get("article_"+id);
        redisTemplate.opsForValue().set("article_" + id, article,10, TimeUnit.DAYS);
        // 如果缓存没有则到数据库查询并放入缓存
        if(article==null) {
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_" + id, article);
        }
        return article;
    }
    /**
     * 修改
     * @param article
     */
    public void update(Article article) {
        redisTemplate.delete( "article_" + article.getId() );//删除缓存
        articleDao.save(article);
    }
    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        redisTemplate.delete( "article_" + id );//删除缓存
        articleDao.deleteById(id);
    }


}
