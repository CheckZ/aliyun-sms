package com.checkzh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CommonResult
 * @Description TODO
 * @Author Check_Z
 * @Date 2023/3/16 23:36
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T   date;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
