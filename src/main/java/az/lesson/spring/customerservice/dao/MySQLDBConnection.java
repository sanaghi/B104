package az.lesson.spring.customerservice.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MySQLDBConnection {
    @Autowired
    Environment environment;
//    @Value("${mysql.db.url}")
//    String dbURL;
//
//    @Value("${mysql.db.user}")
//    String dbUser;
//
//    @Value("${mysql.db.password}")
//    String dbPassword;
    public DataSource getMysqlDataSource(){
        DataSource dataSource;
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
//        mysqlDataSource.setURL(dbURL);
//        mysqlDataSource.setUser(dbUser);
//        mysqlDataSource.setPassword(dbPassword);
        mysqlDataSource.setURL(environment.getProperty("mysql.db.url"));
        mysqlDataSource.setUser(environment.getProperty("mysql.db.user"));
        mysqlDataSource.setPassword(environment.getProperty("mysql.db.password"));
        dataSource = mysqlDataSource;
        return dataSource;
    }


}
