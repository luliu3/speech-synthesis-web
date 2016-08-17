package com.iflytek.yousheng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author luliu3 on 2016/8/16.
 */
public class ToolBootstrap {
    /**
     * spring context
     */
    private static ClassPathXmlApplicationContext springCxt;

    /**
     * 错误日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(ToolBootstrap.class);

    /**
     * 程序入口
     *
     * @param args
     */
    public static void main(String[] args) {

        try {

            //添加未捕获异常处理
            ExceptionHandler uncaughtExceptionhandler = new ExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionhandler);

            //spring初始化
            springCxt = new ClassPathXmlApplicationContext("spring.xml", "dubbo-consumer.xml");

            //启动spring组件
            springCxt.start();

            Thread.sleep(10 * 1000);

            SynthesisTest synthesisSvcTest = (SynthesisTest) springCxt.getBean("synthesisSvcTest");
            synthesisSvcTest.addSynthesisTask();

        } catch (Exception ex) {
            //记录异常
            logger.error("主线程捕获到异常 ", ex);
        }
    }
}