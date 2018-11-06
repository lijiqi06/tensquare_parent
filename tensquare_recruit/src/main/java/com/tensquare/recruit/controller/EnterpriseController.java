package com.tensquare.recruit.controller;
import com.tensquare.recruit.pojo.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询热门企业
     * @return
     */
    @RequestMapping(value = "/search/hotlist",method = RequestMethod.GET)
    public Result hostlist(){
        return new Result(true,StatusCode.OK,"查询成功",
                enterpriseService.hotlist());
    }

}
