package com.example.test.lottery.engine;

import com.example.test.lottery.bean.User;
import com.example.test.lottery.net.protocal.Message;

/**
 * 用户相关业务接口
 *
 */

public interface UserEngine {

    /* 用户登录 */
    Message login(User ueer);
}
