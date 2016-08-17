package com.iflytek.yousheng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author luliu3 on 2016/8/16.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(ToolBootstrap.class);

    /**
     * 异常信息处理
     */
    public void uncaughtException(Thread t, Throwable e) {
        logger.error(String.format("捕获到未处理异常,线程信息 %s 异常信息 %s", t.toString(), e));
    }
}
