package com.saho.controller;

import com.saho.model.AuthType;
import com.saho.model.User;
import com.saho.services.AuthTypeService;
import com.saho.services.AuthTypeServiceImpl;
import com.saho.services.UserService;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sahin.dagdelen on 2/15/2016.
 */

@Controller
@RequestMapping("/**user**")
@SessionAttributes("roles")
public class UserController {

    private static final Logger logger=Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @Autowired
    AuthTypeService authTypeService;

    @RequestMapping(value = "/userlist",method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap){
        List<User> userList= userService.listAllUsers();
        modelMap.addAttribute("users",userList);
        modelMap.addAttribute("edit",false);
        return "userlist";
     }


    @RequestMapping(value = "/newuser",method = RequestMethod.GET)
    public  String newUser(ModelMap modelMap){
            User user=new User();
            modelMap.addAttribute("user",user);
            modelMap.addAttribute("edit",false);
            return "newuser";
    }



    @RequestMapping(value = { "/edit-{id}-user" }, method = RequestMethod.GET)
    public String editUser(@PathVariable long id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "newuser";
    }


    @RequestMapping(value = "/delete-{id}-user",method = RequestMethod.GET)
    public  String deleteUser(@PathVariable long id){
        User user = userService.getUserById(id);
        logger.debug(user+" will be deleted ");
        userService.deleteUser(user);
        return "redirect:/userlist";
    }

    @RequestMapping(value = "/edit-{id}-user",method = RequestMethod.POST)
    public  String updateUser(@Valid User user, BindingResult result,
                            ModelMap model, @PathVariable long id){

        if(result.hasErrors()){
            return "newuser";
        }

        userService.updateUser(user);
        model.addAttribute("success",user+" updated successfully!");
        return "success";
    }


    @RequestMapping(value = "/newuser",method = RequestMethod.POST)
    public String newUserPost(@Valid User user,BindingResult result,ModelMap model){
            if(result.hasErrors()){
                List<ObjectError> errors=  result.getAllErrors();
                for(ObjectError error:errors){
                    logger.error("error message "+error.toString());
                }

                return "newuser";
            }


        userService.saveUser(user);
        model.addAttribute("user",user);
        model.addAttribute("success",user.getFullName()+"  saved successfully! ");
        return "success";
    }


    @ModelAttribute("roles")
     public List<AuthType> initializeAuthTypes(){
        logger.info("initializeAuthTypes  --> roles");
         return authTypeService.findAll();
     }


}
