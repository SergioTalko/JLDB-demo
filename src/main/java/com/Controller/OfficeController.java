package com.Controller;

import com.Entity.Office;
import com.Service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OfficeController {

    @Autowired
    private OfficeService officeService;


    @RequestMapping("/register")
    ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("welcome");

        Office office = new Office("office8", "office7", "10000000", "Test");

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

    @RequestMapping("/find_office")
    ModelAndView find_office() {
        ModelAndView modelAndView = new ModelAndView("find_office");

        Office result = officeService.getOffice("office7");

        modelAndView.addObject("office", result);

        return modelAndView;

    }
    @RequestMapping("/newoffice")
    ModelAndView newoffice(){
        ModelAndView modelAndView = new ModelAndView("newoffice.vm");

        return modelAndView;
    }
    @RequestMapping("/addoffice_db")
    public ResponseEntity<String> addoffice (@RequestParam String name, @RequestParam String address,
                                             @RequestParam String tel, @RequestParam String contact){

        Office curOffice = new Office(name, address, tel, contact);
        ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);

        try { officeService.create(curOffice);}
        catch (Exception e){
            System.out.println("SOMETHING GOES WRONG!!!!");
            response = new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
        }
        return response;
    }

}

