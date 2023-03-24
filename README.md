# aliyun-sms

# 基于spring boot,spring cloud框架，调用阿里云短信服务接口(截止2023.03.17的阿里云短信服务API)功能的demo

# 可用于学习交流，禁止任何商业用途

#项目使用流程如下：

1.创建阿里云账户，进入“短信服务”控制台，在个人账户选择“AccessKey 管理”，使用子账户AccessKey，创建用户组、用户(须记录下自己创建的AccessKey ID和AccessKeySecret(弹出框展示后会找不 		到必须记住否则就要删除重新创建))以及分配权限(选择添加AliyunOSSFullAccess、AliyunDysmsFullAccess权限)

2.在短信服务控制台“国内消息”进行签名和短信模板的申请，短信模板需关联签名(阿里云赠送的模板无法关联签名)

3.阿里云账户充值金额(根据自身情况选择充值，短信服务收费规则可自行在短信服务控制台查看，最低为￥0.045/条)

4.签名和模板若为学习使用，适用场景选择“验证码”，签名用途选择“自用”，签名来源选择“测试或学习”，场景说明写学习和测试使用等正当理由，新建模板要关联签名(审核1h左右)

5.数据库在sendsms-module模块的application.yml中配置，请自行更改

6.数据库表DDL在sendsms-module模块database-Table_SmsInfo文件中，请自行修改(不要将自己的AccessKey ID和AccessKeySecret透露给其他人)

7.执行sendsms-module模块的SendSmsApplication启动项目，若无报错调用接口即可进行测试，若收到短信则成功，若有错误可查看后台日志信息
