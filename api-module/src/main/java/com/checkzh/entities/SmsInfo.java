package com.checkzh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName entities
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/16 22:31
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsInfo {
    private int id;
    private String phoneNum;
    private String signName;
    private String templateCode;
    private String accessKeyId;
    private String accessKeySecret;
    private String regionId;
    private String endpoint;
}
