package com.wistron.wcd.study;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wistron.wcd.study.model.pcbapm.PcbaMachineParameter;
import com.wistron.wcd.study.model.pcbapm.UserSignticket;
import com.wistron.wcd.study.model.pcbapm.UserSignticketAnno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class PcbapmApp {
    public static void main(String[] args) {
        //加载bean
        String[] configLocations = new String[]{"beans-pcba.xml"};
        ClassPathXmlApplicationContext appContext
                = new ClassPathXmlApplicationContext(configLocations);
        SessionFactory sessionFactory = (SessionFactory)appContext.getBean("sessionFactoryPcbapm");
        ComboPooledDataSource dataSource= (ComboPooledDataSource)appContext.getBean("dataSourcePcbapm");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        UserSignticket userSignticket = (UserSignticket) session.get(UserSignticket.class , "T1597841994943");
        System.out.println("Documentid:" + userSignticket.getDocumentid());
        //----------
        UserSignticketAnno userSignticketAnno = (UserSignticketAnno) session.get(UserSignticketAnno.class , "T1597841994943");
        System.out.println("Documentid:" + userSignticketAnno.getDocumentid());
        //-----pcba parameter----
        PcbaMachineParameter pcbaMachineParameter = (PcbaMachineParameter) session.get(PcbaMachineParameter.class , "15983576485600f60715f");
        System.out.println("Programmename:" + pcbaMachineParameter.getProgrammename());
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
