package com.checkzh.dao;

import com.checkzh.entities.SmsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName SendSmsDao
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/17 15:02
 * @Version 1.0
 */
@Mapper
@Repository
public interface SendSmsDao {
    /**
    * @Author zhaofw
    * @Description //查询所有短信配置信息
    * @Date 15:32 2023/3/17
    * @Param []
    * @return java.util.List<com.checkzh.entities.SmsInfo>
    **/
    List<SmsInfo> findAllSmsInfo();
}
