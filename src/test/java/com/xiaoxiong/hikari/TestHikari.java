package com.xiaoxiong.hikari;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

/**
 * @author xiongliang
 * @version 1.0
 * @since 2022/3/3  22:00
 */
public class TestHikari {

   public static void main(String[] args) {
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl("jdbc:mysql://localhost:3306/demo?serverTimezone=Asia/Shanghai");
      config.setDriverClassName("com.mysql.cj.jdbc.Driver");
      config.setUsername("root");
      config.setPassword("xiongliang");
      HikariDataSource ds = new HikariDataSource(config);
      try {
         Connection connection = ds.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("select 1");
         ResultSet resultSet = preparedStatement.executeQuery();
         ResultSetMetaData metaData = resultSet.getMetaData();
         System.out.println(metaData.getColumnCount());
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
