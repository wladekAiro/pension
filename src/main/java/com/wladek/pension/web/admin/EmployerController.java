package com.wladek.pension.web.admin;

import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.pension.Employer;
import com.wladek.pension.service.EmployeeService;
import com.wladek.pension.service.EmployerService;
import com.wladek.pension.web.front.support.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by george on 12/18/15.
 */

@Controller
@RequestMapping(value = "/admin/pension")
public class EmployerController {

    @Autowired
    EmployeeValidator employeeValidator;

    @Autowired
    EmployerService employerService;

    @RequestMapping(value = "/employerForm", method = RequestMethod.GET)
    public String employerForm(Model model) {
        model.addAttribute("employer", new Employer());
        model.addAttribute("action" , "CREATE");
        return "/admin/pension/employer/employerForm";
    }

    @RequestMapping(value = "/newEmployer/{action}", method = RequestMethod.POST)
    public String newUser(@ModelAttribute @Valid Employer employer, BindingResult result ,
                          @PathVariable("action") String action , Model model) {
        String path = "Failed";

        if(action.equals("CREATE")){
            if(result.hasErrors()) {
                model.addAttribute("employer", employer);
                return "/admin/pension/employer/employerForm";
            }
            Employer newEmployer = employerService.create(employer);
            return "redirect:/admin/pension/employers";
        }

        if (action.equals("EDIT")){
            if(result.hasErrors()) {
                model.addAttribute("employer", employer);
                return "/admin/pension/employerForm";
            }
            Employer editedEmployer = employerService.update(employer);
            return "redirect:/admin/pension/employer/"+editedEmployer.getId();
        }

        return path;
    }

    @RequestMapping(value = "/employers" , method = RequestMethod.GET)
    public String getEmployees(Model model){
        List<Employer> employers = employerService.findAll();

        model.addAttribute("employers", employers);
        return "/admin/pension/employer/employerList";
    }

    @RequestMapping(value = "/employer/{id}", method = RequestMethod.GET)
    public String getEmployer(@PathVariable("id") Long id,@RequestParam(value = "page",required = false, defaultValue = "1") int page,
                              @RequestParam(value = "size", required = false, defaultValue = "10") int size , Model model){
        Employer employer = employerService.findOne(id);
        Page<Employee> employees = employerService.getAllEmployees(employer , page , size);
        model.addAttribute("employer" , employer);
        model.addAttribute("employees" , employees);
        model.addAttribute("pagenatedUrl" , "/admin/pension/employer/"+id);
        return "/admin/pension/employer/show";
    }

    @RequestMapping( value = "/employer/{id}/edit", method = RequestMethod.GET)
    public String editEmployer(@PathVariable("id") Long id, Model model){
        Employer employer = employerService.findOne(id);
        model.addAttribute("employer", employer);
        model.addAttribute("action" , "EDIT");
        return "/admin/pension/employer/employerForm";
    }

    @RequestMapping( value = "/employer/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployer(@PathVariable("id") Long id , RedirectAttributes redirectAttributes){
        boolean message = employerService.delete(id);
        redirectAttributes.addFlashAttribute("message" , message);
        return "redirect:/admin/pension/employer";
    }
}
