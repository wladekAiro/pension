package com.wladek.pension.web;

import com.wladek.pension.domain.User;
import com.wladek.pension.domain.enumeration.UserRole;
import com.wladek.pension.service.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 7/6/15.
 */
@Controller
public class PageDirectorController {

    @RequestMapping(value = "/url-processor" , method = RequestMethod.GET)
    public String redirect(){
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userDetails.getUser();

        if (user.getUserRole().equals(UserRole.ADMIN)){
            return "redirect:/admin/home" ;
        }

        if (user.getUserRole().equals(UserRole.EMPLOYEE)){
            return "redirect:/employee/home" ;
        }

        return "redirect:/";

    }
}
