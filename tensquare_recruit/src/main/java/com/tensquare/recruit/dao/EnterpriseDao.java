package com.tensquare.recruit.dao;
import com.tensquare.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
/**
 * Created by ljq on 2018/10/29.
 */
public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise>{
    /**
     * 查询热门企业列表
     * @param ishot
     * @return
     */
    List<Enterprise> findEnterpriseByIshot(String ishot);

}
