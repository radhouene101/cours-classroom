package com.exam.blanc.services;

import java.util.List;

public interface AbstractServices<T> {
    T add(T theObject);
    void delete(long id);
    List<T> getAll();
    T update(T theObject);

}
