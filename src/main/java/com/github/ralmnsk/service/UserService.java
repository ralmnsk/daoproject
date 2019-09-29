package com.github.ralmnsk.service;

import com.github.ralmnsk.dao.UserDao;
import com.github.ralmnsk.entity.User;
import com.github.ralmnsk.hibernate.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserService extends SessionUtil implements UserDao {

    @Override
    public void add(User user) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(user);

        //close session with a transaction
        closeTransactionSesstion();
    }


    @Override
    public List<User> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM usrtab";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        List<User> userList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return userList;
    }


    @Override
    public User getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM usrtab WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("id", id);

        User user = (User) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return user;
    }


    @Override
    public void update(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(user);

        //close session with a transaction
        closeTransactionSesstion();
    }


    @Override
    public void remove(User user) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(user);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public User getByName(String name) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM usrtab WHERE name = :name";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(User.class);
        query.setParameter("name", name);

        User user = (User) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();
        return user;
    }
}
