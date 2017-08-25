package com.Service;

import com.Entity.UserType;

import java.util.List;

public interface UserService extends AbstractService {

    List<UserType> getPositions();
}
