package com.example.test.lottery.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test.lottery.ConstantValue;
import com.example.test.lottery.R;
import com.example.test.lottery.net.protocal.Message;
import com.example.test.lottery.util.BeanFactory;

/**
 * Created by test on 2016/3/3.
 */
public class Hall extends BaseUI {

    //第一步；加载layout（布置参数设置）
    //第二步；初始化layout中控件
    //第三步；设置监听


    private TextView ssqIssue;
    private ImageView ssqBet;

    public Hall(Context context) { //构造
        super(context);

    }


    public void init() {
        showInMiddle = (LinearLayout) View.inflate(context, R.layout.il_hall, null);
        ssqIssue = (TextView) findViewById(R.id.ii_hall_ssq_summary);//初始化
        ssqBet = (ImageView) findViewById(R.id.ii_hall_ssq_bet);
    }

    @Override
    public int getID() {
        return ConstantValue.VIEW_HALL;
    }

    public void setListener() {
        ssqBet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }


    /**
     * 获取当前 销售期双色球
     */
    //获取当前销售期的信息
    private void getCurrentIssueInfo() {

        //      new MyThread().start();
       // new MyAsyncTask().execute(ConstantValue.SSQ);
        new MyHttpTask<Integer>(){


            @Override
            protected Message doInBackground(Integer... params) {
                //获取数据--业务的调用
                CommonInfoEngine engine = BeanFactory.getImpl(CommonInfoEngine.class);

                return engine.getCurrentIssueInfo(params[0]);
            }

            @Override
            protected void onPostExecute(Message message) {
                //更新界面
                super.onPostExecute(message);
            }
        }.executeProxy(ConstantValue.SSQ);


    }
}
 /*   *//**
     * 异步访问网络工具
     * Params：传输的参数
     * Progress：下载相关进度，进度提示（Integer，Float）
     * Result：服务器回复数据封装
     *//*
    private class MyAsyncTask extends MyHttpTask<User, Void, Message> {

        *//**
         * 同run方法，在子线程运行
         *//*


        @Override
        protected Message doInBackground(User... params) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            //Tudo UI Thread before doInBackgrond
            //显示滚动条
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Message message) {
            //Tudo UI Thread after doInBackgriund
            //修改界面的提示信息
            super.onPostExecute(message);
        }



    }


//    private void getCurrentIssueInfo(){
//
//        new MyThread().start();
//       }
// private class MyThread extends Thread{
//        @Override
//        public void run() {
//            //访问网络获取数据
//            super.run();
//        }
//
//        @Override
//        public synchronized void start() {
//            if (NetUtil.checkNet(context)){
//            super.start();
//            }else {
//                PromptManager.showNoNetWork(context);
//            }
//        }
//    }


}
*/