package com.Controller;

import com.Entity.Office;
import com.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfficeController {

    @Autowired
    private OfficeService officeService;


    @RequestMapping("/register")
    ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("welcome");

        Office office = new Office("office2", "test", "10000000", "Test");

        modelAndView.addObject("office", office);
        modelAndView.addObject("state", "registered");

        officeService.create(office);

        return modelAndView;
    }


/*    @RequestMapping("/remove")
    ModelAndView remove_user() {
        ModelAndView modelAndView = new ModelAndView("remove_office");
        Office office = new Office("office1", "test", "10000000", "Test");

        modelAndView.addObject("state", "removed");

        officeService.delete(office);

        return modelAndView;
    }*/


}

