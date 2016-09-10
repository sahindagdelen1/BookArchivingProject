package com.saho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sahin.dagdelen on 1/21/2016.
 */


@Controller
public class HelloWorldController {



    @RequestMapping("/helloworld")
    public  String helloWorld(){
        return "helloworld";
    }
}
