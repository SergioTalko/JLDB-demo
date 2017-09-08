package com.DAO;

import java.util.List;

public interface AbstractDAO {

    Object create(Object o);
    Object update(Object o);

    /*void delete(Object o);*/

   /* Object getById(Long id);*/

    List<Object> getAll();
}
