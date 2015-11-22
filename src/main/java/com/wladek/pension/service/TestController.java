package com.wladek.pension.service;

import com.wladek.pension.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wladek
 */
@Controller
public class TestController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/test/delete/all")
    public String deleteAll() {
        userRepository.deleteAll();
        return "redirect:/";
    }

}
