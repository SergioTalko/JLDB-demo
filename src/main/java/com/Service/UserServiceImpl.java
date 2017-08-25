package com.Service;

import com.DAO.UserDAO;
import com.Entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDAO userDAO;


    @Override
    public Object create(Object o) {
        return userDAO.create(o);
    }

    @Override
    public List<Object> getAll() {
        return userDAO.getAll();
    }

    @Override
    public List<UserType> getPositions() {
        return Arrays.asList(UserType.values());
    }
}
