package com.tensquare.recruit.service;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ljq on 2018/10/29.
 */
@Service
public class RecruitService {
    @Autowired
    private RecruitDao recruitDao;
    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newlist(){
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
