package com.github.ralmnsk.domain;

import com.github.ralmnsk.entity.News;
import com.github.ralmnsk.entity.User;
import com.github.ralmnsk.hibernate.HibernateUtil;
import com.github.ralmnsk.service.NewsService;
import com.github.ralmnsk.service.UserService;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class Domain {
    public static void main(String[] args){
        //userTest();
        newsTest();
        HibernateUtil.shutdown();
    }

    public static void newsTest(){
        newsTestingAdd();
        newsGetByIdTest();
        newsGetByNameTest();
        newsUpdateTest();
        newsDeleteTest();
    }

    public static void newsGetByNameTest(){
        String name="testNameNews";
        NewsService newsService=new NewsService();
        try {
            newsService.getByName(name).stream().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newsTestingAdd(){
        News news=new News("testNameNews","Test news text(data)",new Date());
        NewsService newsService=new NewsService();
        try {
            newsService.add(news);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newsGetByIdTest(){
        //News news=new News("testNameNews","Test news text(data)",new Date());
        NewsService newsService=new NewsService();
        try {
            newsService.getByName("testNameNews")
                    .stream().map(news -> news.getIdNews())
                    .collect(Collectors.toList())
                    .stream()
                    .map(s-> {
                        try {
                            return newsService.getById(s);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }).forEach(System.out::println);
         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newsUpdateTest(){
        News news=new News("testNameNews2","Test news text(data)2",new Date());
        NewsService newsService=new NewsService();
        try {
        List<News> list=newsService.getByName("testNameNews");
        if (list.size()==1){
            news.setIdNews(list.get(0).getIdNews());
            newsService.update(news);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void newsDeleteTest(){
        News news=new News("testNameNews2","Test news text(data)2",new Date());
        NewsService newsService=new NewsService();
        try {
            List<News> list=newsService.getByName("testNameNews2");
            if (list.size()==1){
                news.setIdNews(list.get(0).getIdNews());
                newsService.remove(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//-------------------USER-----------------------------
    public static void userTest(){
        userTestingAdd();
        getAllUsersTest();
        getByIdUserTest();
        getUserByNameTest();
        udateUserTest();
        deleteUserTest();
    }

    public static void userTestingAdd(){
        User user=new User("testUser","testPass",new Date(),"usr");
        UserService userService=new UserService();
        try {
            userService.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllUsersTest(){
        //User user=new User("testUser","testPass",new Date(),"usr");
        UserService userService=new UserService();
        try {
            List<User> list=userService.getAll();
            list.stream().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getByIdUserTest(){
        //User user=new User("testUser","testPass",new Date(),"usr");
        UserService userService=new UserService();
        try {
            User userById = userService.getById(29L);
            System.out.println(userById);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getUserByNameTest(){
        UserService userService=new UserService();
        try {
            User user=userService.getByName("testUser");
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void udateUserTest(){
        UserService userService=new UserService();
        try {
            User user=userService.getByName("testUser");
            user.setName("testUser2");
            user.setPass("testPass2");
            userService.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteUserTest(){

        UserService userService=new UserService();
        try {
        User user=userService.getByName("testUser2");
            userService.remove(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
