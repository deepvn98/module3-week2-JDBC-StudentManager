package service;

import model.Student;

import java.util.List;

public interface InterFaceService <T>{
    List<T> showAll();

    void create(T t);

    void update(int id,T t);

    void remove(int id);

    T findById(int id);

    List<T> findListById(int id);

    T findByName(String name);
}
