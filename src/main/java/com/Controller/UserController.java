
package com.Controller;


import com.Entity.Office;
import com.Entity.User;
import com.Entity.UserType;
import com.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping("/register")
    ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("welcome");

        Office office = new Office("office", "test", "10000000", "Test");

        modelAndView.addObject("user", office);
        modelAndView.addObject("state", "registered");

        userService.create(office);

        return modelAndView;

    }

}
