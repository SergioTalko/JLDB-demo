package com.Service;

import com.DAO.OfficeDAO;
import com.Entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDAO officeDAO;


    @Override
    public Object create(Object o) {
        return officeDAO.create(o);
    }

    @Override
    public void update(Object o) {
        officeDAO.update(o);
    }



    @Override
    public Office getOffice(String name) {
        return officeDAO.getOffice(name);
    }

    @Override
    public List<Object> getAll() {
        return officeDAO.getAll();
    }

    //TODO
}
