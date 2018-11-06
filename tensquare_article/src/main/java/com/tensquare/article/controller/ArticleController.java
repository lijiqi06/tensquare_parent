package com.tensquare.article.controller;

import com.tensquare.article.service.ArticleService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ljq on 2018/10/29.
 */
@RestController
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    /**
     * 审核
     * @param id
     * @return
     */
    @RequestMapping(value="/examine/{id}",method= RequestMethod.PUT)
    public Result examine(@PathVariable String id){
        articleService.examine(id);
        return new Result(true, StatusCode.OK, "审核成功！");
    }

    /**
     * 点赞
     * @param id
     * @return
     */
    @RequestMapping(value="/thumbup/{id}",method=RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String id){
        articleService.updateThumbup(id);
        return new Result(true, StatusCode.OK,"点赞成功");
    }

}
