package com.checkzh.controller;

import com.checkzh.entities.CommonResult;
import com.checkzh.entities.SmsInfo;
import com.checkzh.service.SendSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SendSmsController
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/17 14:57
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/sms")
public class SendSmsController {

    @Autowired
    private SendSmsService sendSmsService;

    @PostMapping(value = "/send")
    public CommonResult sendSms(@RequestBody SmsInfo smsInfo) throws Exception {
        CommonResult result = sendSmsService.sendSmsMessage(smsInfo);
        return result;
    }
}
