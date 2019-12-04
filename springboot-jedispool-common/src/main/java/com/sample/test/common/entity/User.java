/**
 * FileName: User
 * Author:   huang.yj
 * Date:     2019/11/12 17:11
 * Description: 用户实体类
 */
package com.sample.test.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 〈用户实体类〉
 *
 * @author huang.yj
 * @create 2019/11/12
 * @since 0.0.1
 */
@Data
public class User {

    private int id;

    private String password;

    private String remarks;

    private String userName;

    private String email;

    private String phone;

    private int status;

    private int isLocked;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
}