/**
 * FileName: RedisTestController
 * Author:   huang.yj
 * Date:     2019/11/29 13:53
 * Description:
 */
package com.sample.test.web;

import com.sample.test.common.entity.User;
import com.sample.test.dao.JedisPoolDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author huang.yj
 * @create 2019/11/29
 * @since 0.0.1
 */
@RestController
@Slf4j
@RequestMapping("/jedisPoolTest")
public class RedisTestController {

    @Autowired
    private JedisPoolDao jedisPoolDao;

    @GetMapping(value="setStr")
    public ResponseEntity<Void> setStr(){
        String key = "jedisPoolValue1";
        try {
            jedisPoolDao.setStr(key);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value="setUser")
    public ResponseEntity<Void> setUser(){
        User user = new User();
        user.setUserName("赵小姐");
        user.setEmail("112@163.com");
        try {
            jedisPoolDao.setUser(user);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}