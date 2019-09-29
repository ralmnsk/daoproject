package com.github.ralmnsk.dao;

import com.github.ralmnsk.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    //create
    void add(User user) throws SQLException;

    //read
    List<User> getAll() throws SQLException;

    User getById(Long id) throws SQLException;

    //update
    void update(User user) throws SQLException;

    //delete
    void remove(User user) throws SQLException;

    User getByName(String name) throws SQLException;
}
