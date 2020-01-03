package com.ada.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @ClassName:HomeController
 * @author: Ada
 * @date 2019/11/07 15:29
 * @Description: 首页controller
 */
@Controller
@RequestMapping("")
public class HomeController {

    /**
     * 首页跳转
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        return "index";
    }

    /**
     * 关于页面
     */
    @RequestMapping(value = "about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    /**
     * 生成代码页面
     */
    @RequestMapping(value = "generator", method = RequestMethod.GET)
    public String user() {
        return "generator/list";
    }
}

