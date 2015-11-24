package com.wladek.pension.web.admin;

import com.wladek.pension.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 11/24/15.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminBaseController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "/admin/index";
    }

    @RequestMapping(value = "/roles" , method = RequestMethod.GET)
    public String roles(){
        return "/admin/roles/index";
    }

    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public String users(){
        return "/admin/users/index";
    }
}
