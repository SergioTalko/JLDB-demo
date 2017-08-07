package com.Service;

import com.DAO.OfficeDAO;
import com.Entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficeServiceImpl implements OfficeService {

    @Autowired
    private OfficeDAO officeDAO;


    @Override
    public Object create(Object o) {
        return officeDAO.create(o);
    }

   /* @Override
    public void delete(Object o) {
        officeDAO.delete(o);
    }*/

   /* @Override
    public Office getOffice(String name) {
        return officeDAO.getOffice(name);
    }*/

    //TODO
}
