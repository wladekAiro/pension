package com.wladek.pension.web.admin;

import com.wladek.pension.domain.pension.Assets;
import com.wladek.pension.domain.pension.Employee;
import com.wladek.pension.domain.pension.Employer;
import com.wladek.pension.service.AssetService;
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
public class AssetController {

    @Autowired
    EmployeeValidator employeeValidator;

    @Autowired
    AssetService assetService;

    @RequestMapping(value = "/investmentForm", method = RequestMethod.GET)
    public String employerForm(Model model) {
        model.addAttribute("investment", new Assets());
        model.addAttribute("action" , "CREATE");
        return "/admin/pension/investment/investmentForm";
    }

    @RequestMapping(value = "/newInvestment/{action}", method = RequestMethod.POST)
    public String newUser(@ModelAttribute @Valid Assets assets, BindingResult result ,
                          @PathVariable("action") String action , Model model) {
        String path = "Failed";

        if(action.equals("CREATE")){
            if(result.hasErrors()) {
                model.addAttribute("investment", assets);
                return "/admin/pension/investment/investmentForm";
            }
            Assets newAsset = assetService.create(assets);
            return "redirect:/admin/pension/investment";
        }

        if (action.equals("EDIT")){
            if(result.hasErrors()) {
                model.addAttribute("investment", assets);
                return "/admin/pension/investment/investmentForm";
            }
            Assets editedAsset = assetService.edit(assets);
            return "redirect:/admin/pension/investment/"+editedAsset.getId();
        }

        return path;
    }

    @RequestMapping(value = "/investment" , method = RequestMethod.GET)
    public String getAssets(Model model){
        List<Assets> assets = assetService.findAll();

        model.addAttribute("investments", assets);
        return "/admin/pension/investment/investmentList";
    }

    @RequestMapping(value = "/investment/{id}", method = RequestMethod.GET)
    public String getInvestment(@PathVariable("id") Long id, Model model){
        Assets investment = assetService.findOne(id);
        model.addAttribute("investment" , investment);
        return "/admin/pension/investment/show";
    }

    @RequestMapping( value = "/investment/{id}/edit", method = RequestMethod.GET)
    public String editInvestment(@PathVariable("id") Long id, Model model){
        Assets investment = assetService.findOne(id);
        model.addAttribute("investment" , investment);
        model.addAttribute("action" , "EDIT");
        return  "/admin/pension/investment/investmentForm";
    }

    @RequestMapping( value = "/investment/{id}/delete", method = RequestMethod.GET)
    public String deleteEmployer(@PathVariable("id") Long id , RedirectAttributes redirectAttributes){
        boolean message = assetService.delete(id);
        redirectAttributes.addFlashAttribute("message" , message);
        return "redirect:/admin/pension/investment";
    }
}
