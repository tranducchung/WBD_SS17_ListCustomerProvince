package com.codegym.cms.controller;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ProvinceService;
import org.hibernate.annotations.LazyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class controllerProvince {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public ModelAndView showListProvince(){
        return new ModelAndView("province/list","provinces",provinceService.findAll());
    }

   @GetMapping("/create-province")
    public ModelAndView showCreateForm(){
        return new ModelAndView("province/create","province",new Province());
   }
   @PostMapping("/create-province")
    public ModelAndView createProvince(@ModelAttribute Province province){
        provinceService.save(province);
        return new ModelAndView("province/create","message","Create new Province success");
   }
    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        return new ModelAndView("province/edit","province",provinceService.findById(id));
    }
    @PostMapping("/edit-province")
    public ModelAndView editProvince(@ModelAttribute Province province){
        provinceService.save(province);
        return new ModelAndView("province/edit","message","Update province success");
    }
    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        provinceService.remove(id);
        return new ModelAndView("redirect:/provinces");
    }
    @GetMapping("/view-province/{id}")
    public ModelAndView viewProvince(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("province/view");
        Province province = provinceService.findById(id);
        modelAndView.addObject("customers",customerService.findAllByProvince(province));
        modelAndView.addObject("province",province);
        return modelAndView;
    }
}
