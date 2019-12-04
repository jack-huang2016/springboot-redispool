/**
 * FileName: JedisPoolDaoImpl
 * Author:   huang.yj
 * Date:     2019/11/29 13:56
 * Description:
 */
package com.sample.test.dao;

import com.sample.test.common.constants.RedisConstants;
import com.sample.test.common.entity.User;
import com.sample.test.common.redisCache.util.JedisPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 〈〉
 *
 * @author huang.yj
 * @create 2019/11/29
 * @since 0.0.1
 */
@Repository
@Slf4j
public class JedisPoolDaoImpl implements JedisPoolDao {

    @Autowired
    private JedisPoolUtil jedisPoolUtil;

    @Override
    public void setStr(String str) throws Exception{
        jedisPoolUtil.set("poolStr",str, RedisConstants.DATEBASE1);
        jedisPoolUtil.expire("poolStr",30,RedisConstants.DATEBASE1);
        log.info("dao层setStr执行成功");
    }

    @Override
    public void setUser(User user) throws Exception{
        jedisPoolUtil.set("poolUser".getBytes(),jedisPoolUtil.ObjTOSerialize(user), RedisConstants.DATEBASE1);
        jedisPoolUtil.expire("poolUser".getBytes(),30,RedisConstants.DATEBASE1);
        log.info("dao层setUser执行成功");
    }
}