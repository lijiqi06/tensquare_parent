package com.tensquare.gathering.dao;

import com.tensquare.gathering.pojo.Gathering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by ljq on 2018/10/31.
 */
public interface GatheringDao extends JpaRepository<Gathering,String>,
        JpaSpecificationExecutor<Gathering>{
}
