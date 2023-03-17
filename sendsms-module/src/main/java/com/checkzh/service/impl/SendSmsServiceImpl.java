package com.checkzh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.checkzh.dao.SendSmsDao;
import com.checkzh.entities.CommonResult;
import com.checkzh.entities.SmsInfo;
import com.checkzh.service.SendSmsService;
import com.checkzh.tools.CommonTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName SendSmsServiceImpl
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/17 15:43
 * @Version 1.0
 */
@Slf4j
@Service
public class SendSmsServiceImpl implements SendSmsService {

    @Autowired
    private SendSmsDao sendSmsDao;

    @Override
    public CommonResult sendSmsMessage(SmsInfo smsInfo) throws Exception {
        List<SmsInfo> smsInfoList = sendSmsDao.findAllSmsInfo();
        smsInfoList.stream().filter(s-> "13311111111".equals(s.getPhoneNum()) && "SMS_111111111".equals(s.getTemplateCode())).collect(Collectors.toList());
        smsInfo = smsInfoList.get(0);
        Config config = new Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(smsInfo.getAccessKeyId())
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(smsInfo.getAccessKeySecret()).setRegionId(smsInfo.getRegionId());
        // 访问的域名
        config.endpoint = smsInfo.getEndpoint();
        Client client = new Client(config);

        //随机生成4位数字验证码
        HashMap<String, Object> codeMap = new HashMap<>();
        codeMap.put("code", CommonTools.getFourNumRandom());

        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(smsInfo.getPhoneNum())
                .setSignName(smsInfo.getSignName())
                .setTemplateCode(smsInfo.getTemplateCode())
                .setTemplateParam(JSONObject.toJSONString(codeMap));
        try {
            // 复制代码运行请自行打印 API 的返回值
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, new RuntimeOptions());
            log.info(sendSmsResponse.getBody().getMessage());
            return new CommonResult(200, "短信发送成功！", sendSmsResponse.getBody().getMessage());
        } catch (TeaException error) {
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
            log.info(error.message);
            return new CommonResult(200, "短信发送失败！", error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
            log.info(error.message);
            return new CommonResult(200, "短信发送失败！", error.message);
        }
    }
}
