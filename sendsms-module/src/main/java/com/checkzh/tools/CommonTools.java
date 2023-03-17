package com.checkzh.tools;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @ClassName CommonTools
 * @Description 工具类
 * @Author Check_Z
 * @Date 2023/3/17 16:51
 * @Version 1.0
 */
public class CommonTools {

    public static String getFourNumRandom(){
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        Random random = new Random();
        String code = decimalFormat.format(random.nextInt(10000));
        return code;
    }
}
