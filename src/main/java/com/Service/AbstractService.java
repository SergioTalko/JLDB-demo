package com.Service;

import java.util.List;

public interface AbstractService {

    Object create(Object o);

   /* void delete(Object o);*/

    List<Object> getAll();
}
