package com.iflytek.yousheng.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author luliu3 on 2016/8/16.
 */
@Controller
@RequestMapping(value = "common")
public class CommonController {
    @RequestMapping(value = "error")
    public ModelAndView error(String msg) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("common/error");
        if (StringUtils.isNotBlank(msg)) {
            modelAndView.addObject("msg", msg);
        }
        return modelAndView;
    }
}
