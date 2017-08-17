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

        Office office = new Office("office4", "test", "10000000", "Test");

        modelAndView.addObject("office", office);
        modelAndView.addObject("state", "registered");

        officeService.create(office);

        return modelAndView;
    }


    @RequestMapping("/getOffice")
    ModelAndView getOffice() {
        ModelAndView modelAndView = new ModelAndView("get_office");

        Office office = officeService.getOffice("office1");

        modelAndView.addObject("office", office);


        return modelAndView;
    }


}

