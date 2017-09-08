package com.DAO;

import com.Entity.User;

public interface UserDAO extends AbstractDAO {

    User getUser(String user_name);
}
