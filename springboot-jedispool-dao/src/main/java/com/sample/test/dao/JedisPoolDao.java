package com.sample.test.dao;

import com.sample.test.common.entity.User;

public interface JedisPoolDao {

    public void setStr(String str) throws Exception;

    public void setUser(User user) throws Exception;
}
