package com.wladek.pension.web.employee;

import com.wladek.pension.domain.pension.Assets;
import com.wladek.pension.domain.pension.Enquiry;
import com.wladek.pension.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by wladek on 1/14/16.
 */
@Controller
@RequestMapping(value = "/employee/inquiries")
public class EnquiriesController {
    @Autowired
    EnquiryService enquiryService;

    @RequestMapping(value = "/make" , method = RequestMethod.GET)
    public String getForm(Model model){
        model.addAttribute("enquiry" , new Enquiry());
        return "/employee/enquiry/form";
    }

    @RequestMapping(value = "/make", method = RequestMethod.POST)
    public String postEnquiry(@ModelAttribute @Valid Enquiry enquiry, BindingResult result , Model model){

        if(result.hasErrors()) {
            model.addAttribute("enquiry", enquiry);
            return "/employee/enquiry/form";
        }
        Enquiry newEquiry = enquiryService.make(enquiry);
        return "redirect:/employee/inquiries/"+newEquiry.getId()+"view";
    }

    @RequestMapping(value = "/{id}/view" , method = RequestMethod.GET)
    public String viewEnquiry(@PathVariable("id") Long id , Model model){
        Enquiry enquiry = enquiryService.findOne(id);
        model.addAttribute("enquiry", enquiry);
        return "/employee/enquiry/view";
    }

    @RequestMapping(value = "my-inquiries" , method = RequestMethod.GET)
    public String myInquiries(Model model){
        model.addAttribute("enquiries");
        return "/employee/enquiry/view";
    }
}
