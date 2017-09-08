
package com.Controller;


import com.Entity.Office;
import com.Entity.User;
import com.Entity.UserType;
import com.Service.OfficeServiceImpl;
import com.Service.UserServiceImpl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OfficeServiceImpl officeService;


    @RequestMapping("/register_user")
    ModelAndView register_user() {
        ModelAndView modelAndView = new ModelAndView("welcome_user");

       Office result = officeService.getOffice("office7");

       User user = new User(UserType.ADMIN,"test@test.ua","password","test","080080080", result);

        modelAndView.addObject("user", user);

        modelAndView.addObject("state", "registered");

        userService.create(user);

        return modelAndView;

    }


    @RequestMapping("/find_user")
    ModelAndView find_user() {
        ModelAndView modelAndView = new ModelAndView("find_user");

        User result = userService.getUser("test");

        modelAndView.addObject("user", result);

        return modelAndView;

    }


}
