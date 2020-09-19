package com.wistron.wcd.study;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wistron.wcd.study.model.pcbapm.PcbaMachineParameter;
import com.wistron.wcd.study.service.PcbapmSinkToRedis;
import com.wistron.wcd.study.service.RedisService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PcbapmSinkToRedisApp {
    public static void main(String[] args) {
        String[] configLocations = new String[]{"spring-redis.xml", "beans-pcba.xml"};
        ClassPathXmlApplicationContext appContext
                = new ClassPathXmlApplicationContext(configLocations);
        SessionFactory sessionFactory = (SessionFactory)appContext.getBean("sessionFactoryPcbapm");
        ComboPooledDataSource dataSource= (ComboPooledDataSource)appContext.getBean("dataSourcePcbapm");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        PcbapmSinkToRedis pcbapmSinkToRedis = (PcbapmSinkToRedis)appContext.getBean("pcbapmSinkToRedis");
        RedisService redisService = (RedisService)appContext.getBean("redisService");
        Criteria criteria =session.createCriteria(PcbaMachineParameter.class);
        List<PcbaMachineParameter> list = criteria.list();
        tx.commit();
        session.close();
        sessionFactory.close();
        //使用forEach遍历集合
        pcbapmSinkToRedis.process(list, redisService);
    }
}
