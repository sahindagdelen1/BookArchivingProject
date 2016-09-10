package com.saho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sahin.dagdelen on 1/21/2016.
 */

@Controller
public class HelloController {


    @RequestMapping("hi")
    @ResponseBody
    public  String hi(){
        return  "Hello world!";
    }


    @RequestMapping(value = "/admin**",method = RequestMethod.GET)
    public ModelAndView adminPage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","Spring Security Admin Page");
        modelAndView.addObject("message","This is welcome page for admins");
        modelAndView.setViewName("admin");
        return modelAndView;
    }
}



