package com.saho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sahin.dagdelen on 2/22/2016.
 */
@Controller
@RequestMapping("**/home")
public class HomeController {

    @RequestMapping(value = {"/home"},method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        return "home";

    }
}
