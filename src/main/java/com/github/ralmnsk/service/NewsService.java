package com.github.ralmnsk.service;

import com.github.ralmnsk.dao.NewsDao;
import com.github.ralmnsk.entity.News;
import com.github.ralmnsk.entity.User;
import com.github.ralmnsk.hibernate.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class NewsService extends SessionUtil implements NewsDao {

    @Override
    public void add(News news) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(news);

        //close session with a transaction
        closeTransactionSesstion();
    }


    @Override
    public List<News> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM newstab";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(News.class);
        List<News> newsList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return newsList;
    }


    @Override
    public News getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM newstab WHERE idnews = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(News.class);
        query.setParameter("id", id);

        News news = (News) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return news;
    }


    @Override
    public void update(News news) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(news);

        //close session with a transaction
        closeTransactionSesstion();
    }


    @Override
    public void remove(News news) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(news);

        //close session with a transaction
        closeTransactionSesstion();
    }
}
