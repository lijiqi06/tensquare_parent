package com.tensquare.recruit.controller;

import com.tensquare.recruit.service.RecruitService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ljq on 2018/10/29.
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;
    /**
     * 最新职位列表
     * @return
     */
    @RequestMapping(value = "/search/newlist",method = RequestMethod.GET)
    public Result newlist(){
        return new Result(true, StatusCode.OK,"查询成功",
                recruitService.newlist());
    }
}
