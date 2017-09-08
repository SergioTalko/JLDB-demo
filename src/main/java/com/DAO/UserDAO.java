package com.DAO;

import com.Entity.User;

import java.util.List;

public interface UserDAO extends AbstractDAO {

    User getUser(String user_name);

    List<User> getUsers(String name);
}
