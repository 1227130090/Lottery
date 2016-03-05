package com.example.test.lottery.engine;

import com.example.test.lottery.net.protocal.Message;

/**
 * 公共的数据处理
 * Created by test on 2016/3/5.
 */
public interface CommonInfoEngine {
    /*
    * 获取当前销售期信息
    * @param integer ：彩种的标识
    * @return
    *
    * */
    Message getCurrentIssueInfo(Integer integer);
}
