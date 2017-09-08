package com.Service;

import com.Entity.User;
import com.Entity.UserType;

import java.util.List;

public interface UserService extends AbstractService {

    List<UserType> getPositions();

    User getUser(String user_name);
}
