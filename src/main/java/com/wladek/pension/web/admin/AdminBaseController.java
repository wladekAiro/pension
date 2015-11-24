package com.wladek.pension.web.admin;

import com.wladek.pension.domain.Role;
import com.wladek.pension.domain.User;
import com.wladek.pension.service.UserService;
import com.wladek.pension.service.pension.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by wladek on 11/24/15.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminBaseController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "/admin/index";
    }

    @RequestMapping(value = "/roles" , method = RequestMethod.GET)
    public String roles(Model model){
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles" , roles);
        return "/admin/roles/index";
    }

    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public String users(Model model){
        List<User>  users = userService.findAll();
        model.addAttribute("users" , users);
        return "/admin/users/index";
    }
}
