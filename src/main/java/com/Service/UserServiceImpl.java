package com.Service;

import com.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;


    @Override
    public Object create(Object o) {
      return   userDAO.create(o);
    }

   /* @Override
    public void delete(Object o) {
        userDAO.delete(o);
    }*/
}
