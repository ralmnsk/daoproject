package com.github.ralmnsk.dao;

import com.github.ralmnsk.entity.News;
import java.sql.SQLException;
import java.util.List;

public interface NewsDao {

    //create
    void add(News news) throws SQLException;

    //read
    List<News> getAll() throws SQLException;

    News getById(Long id) throws SQLException;

    //update
    void update(News news) throws SQLException;

    //delete
    void remove(News news) throws SQLException;
}
