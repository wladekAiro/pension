package com.wladek.pension.web.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wladek on 1/14/16.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeBaseController {
    @RequestMapping(value = "/home" , method = RequestMethod.GET)
    public String home(Model model){
        return "/employee/index";
    }
}
