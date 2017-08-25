
package com.Controller;


import com.Entity.Office;
import com.Entity.User;
import com.Entity.UserType;
import com.Service.OfficeServiceImpl;
import com.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private OfficeServiceImpl officeService;


    @RequestMapping("/register_user")
    ModelAndView register_user() {
        ModelAndView modelAndView = new ModelAndView("welcome_user");

       Office result = officeService.getOffice("office4");

       User user = new User(UserType.ADMIN,"shshsjsj@","test","test_user","100", result);

        modelAndView.addObject("user", user);
        modelAndView.addObject("state", "registered");

        userService.create(user);

        return modelAndView;

    }

    @RequestMapping("/newuser")
    public ModelAndView newuser(){
        ModelAndView modelAndView = new ModelAndView("adduser");
        modelAndView.addObject("officeslist",officeService.getAll());
        modelAndView.addObject("positionslist",userService.getPositions());
        return modelAndView;
    }
}
