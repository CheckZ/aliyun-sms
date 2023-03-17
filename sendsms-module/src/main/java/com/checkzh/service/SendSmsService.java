package com.checkzh.service;

import com.checkzh.entities.CommonResult;
import com.checkzh.entities.SmsInfo;

/**
 * @ClassName SendSmsService
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/17 15:41
 * @Version 1.0
 */
public interface SendSmsService {
    CommonResult sendSmsMessage(SmsInfo smsInfo) throws Exception;
}
