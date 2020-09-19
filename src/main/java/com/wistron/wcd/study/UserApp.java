package com.wistron.wcd.study;

import org.hibernate.SessionFactory;

public class UserApp {
    private  SessionFactory sessionFactory;

    public  SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public  void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
