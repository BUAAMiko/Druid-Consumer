package jj.druid;

import com.alibaba.druid.pool.DruidDataSource;
import jj.druid.api.DruidInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main extends Thread {
    public static void main(String[] args) throws SQLException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        context.start();
        DruidInterface druid = (DruidInterface) context.getBean(DruidInterface.class);
        List list = druid.executeQuery("SELECT * FROM test");
        System.out.println(list);
        System.in.read();
        context.close();
    }
}
