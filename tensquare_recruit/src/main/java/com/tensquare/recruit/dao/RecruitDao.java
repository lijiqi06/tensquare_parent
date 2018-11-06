package com.tensquare.recruit.dao;

import com.tensquare.recruit.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by ljq on 2018/10/29.
 */
public interface RecruitDao extends JpaRepository<Recruit,String> ,
        JpaSpecificationExecutor<Recruit>{
    /**
     * 最新职位列表
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);

}
