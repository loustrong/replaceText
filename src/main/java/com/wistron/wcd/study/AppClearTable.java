package com.wistron.wcd.study;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.wistron.wcd.study.model.ClearTable;
import com.wistron.wcd.study.model.User;
import com.wistron.wcd.study.util.JsonIO;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AppClearTable {
//    private static SessionFactory sessionFactory;
        public static void main(String[] args) throws Exception {
            //加载bean
            ClassPathXmlApplicationContext appContext
                    = new ClassPathXmlApplicationContext("classpath*:beans.xml");
            SessionFactory sessionFactory = (SessionFactory)appContext.getBean("sessionFactory");
            ComboPooledDataSource dataSource= (ComboPooledDataSource)appContext.getBean("dataSource");
            Properties properties = new Properties();
            // 使用InPutStream流读取properties文件
            BufferedReader bufferedReader = new BufferedReader(new FileReader("config/datasource.properties"));
            properties.load(bufferedReader);
            // 获取key对应的value值
            String driverClass = properties.getProperty("mysql.driverClassName");
            String jdbcUrl = properties.getProperty("mysql.url");
            String user = properties.getProperty("mysql.username");
            String password = properties.getProperty("mysql.password");

//            dataSource.setDriverClass(driverClass);
//            dataSource.setJdbcUrl(driverClass);
//            dataSource.setUser(driverClass);
//            dataSource.setPassword(driverClass);
            Session session = sessionFactory.openSession();


            // session
//            Session session = sessionFactory;
//            User user = new User();
//            user.setName("lgd");
//            user.setAge(22);
//            session.save(user);
            System.out.println("userInsert is done.");
            ClearTable clearTable = JsonIO.getClearTable();
            Boolean single;
            String dept;
            if(clearTable.isAll()){
                single = false;
                dept = "all";
            } else if(clearTable.isSmt()){
                single = false;
                dept = "smt";
            } else if(clearTable.isDip()){
                single = false;
                dept = "dip";
            } else {
                single = true;
                dept = "single";
            }
            List<String> tableNameList = JsonIO.getTableNames(dept, single);
            StringBuilder allSingle = new StringBuilder();
            for(String tableName: tableNameList){
                String singleSQL = "";
                singleSQL = "truncate table " + tableName + ";";
                Transaction ts = session.beginTransaction();
                Query query = session.createSQLQuery(singleSQL.toString());
                query.executeUpdate();
                ts.commit();
            }
        }

//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public static void setSessionFactory(SessionFactory sessionFactory) {
//        AppClearTable.sessionFactory = sessionFactory;
//    }
}

