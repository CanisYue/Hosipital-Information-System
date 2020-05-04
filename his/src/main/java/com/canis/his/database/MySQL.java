package com.canis.his.database;
/**
 * 负责存储过程的调用
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.canis.his.VO.RegistrationReturn;
import com.canis.his.useful.Response;
//import org.json.JSONException;
//import org.json.JSONObject;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MySQL {
    public static DruidDataSource dataSource;

    // 预编译数据库语句 / 防止SQL注入， 提高性能
    private static boolean isPrepared = false;

    static {
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/backup2?useSSL=false&&useUnicode=true&characterEncoding=utf-8&&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("canisyue");
        //其他属性
        //初始大小
        dataSource.setInitialSize(10);
        //最大大小
        dataSource.setMaxActive(50);
        //最小大小
        dataSource.setMinIdle(10);
        //检查时间
        dataSource.setMaxWait(5000);

        try {
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String registration(String id_number, String name, String gender,
                                    String birth, String age,
                                    String address, String morning_afternoon,
                                    String doctor_id, String settlement_type_id,
                                    String request_book, String operator_id) throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false&&useUnicode=true&characterEncoding=utf-8&&serverTimezone=UTC",
                "root",
                "canisyue");
        String sql = "{CALL registration(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; //调用存储过程
        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm
        cstm.setString(1, id_number);
        cstm.setString(2, name);
        cstm.setString(3, gender);
        cstm.setString(4, birth);
        cstm.setString(5, age);
        cstm.setString(6, "岁");
        cstm.setString(7, address);
        cstm.setString(8, morning_afternoon);
        cstm.setString(9, doctor_id);
        cstm.setString(10, settlement_type_id);
        cstm.setString(11, request_book);
        cstm.setString(12, operator_id); //IN RegRank INT

        cstm.registerOutParameter(13, Types.INTEGER); // 设置返回值类型 即返回值
        cstm.registerOutParameter(14, Types.INTEGER); // 设置返回值类型 即返回值
        cstm.registerOutParameter(15, Types.INTEGER); // 设置返回值类型 即返回值
        cstm.registerOutParameter(16, Types.INTEGER); // 设置返回值类型 即返回值
        cstm.execute(); // 执行存储过程
        int paper_id = cstm.getInt(13);
        int invoice_id = cstm.getInt(14);
        float fund = cstm.getFloat(15);
        String book_id = cstm.getString(16);

        cstm.close();
        connection.close();
//        System.out.println(paper_id);
//        System.out.println(invoice_id);
//        System.out.println(fund);
        List<Object> response = new LinkedList<>();
        response.add(new RegistrationReturn(paper_id, invoice_id, fund, book_id));
        System.out.println("Insert Complete");
        return JSON.toJSONString(new Response(response));

    }

    public static void backregistration(String paper_id, String operator_id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false&&useUnicode=true&characterEncoding=utf-8&&serverTimezone=UTC",
                "root",
                "canisyue");
        String sql = "{CALL plsql2(?,?,?)}"; //调用存储过程
        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm
        cstm.setString(1, paper_id); //IN PATIENTNAME TEXT
        cstm.setString(2, operator_id); //IN PATIENTNAME TEXT
        cstm.registerOutParameter(3, Types.VARCHAR); // 设置返回值类型 即返回值
        cstm.execute(); // 执行存储过程
        System.out.println(cstm.getString(3));
        cstm.close();
        connection.close();
    }

    public static void diagnose(String id, String disease, String date) throws Exception {


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false&&useUnicode=true&characterEncoding=utf-8&&serverTimezone=UTC",
                "root",
                "canisyue");
        String sql = "{CALL plsql3(?,?,?,?,?)}"; //调用存储过程
        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm
        cstm.setString(1, id); //IN PATIENTNAME TEXT
        cstm.setString(2, disease); //IN PATIENTNAME TEXT
        cstm.setString(3, "1"); //IN PATIENTNAME TEXT
        cstm.setString(4, date); //IN PATIENTNAME TEXT


        cstm.registerOutParameter(5, Types.VARCHAR); // 设置返回值类型 即返回值
        cstm.execute(); // 执行存储过程
        System.out.println(cstm.getString(5));
        cstm.close();
        connection.close();
    }

    public static void frontPage(String id, String main_problem,
                                 String disease_for_now, String treatment_for_now,
                                 String disease_for_past, String allergic_history,
                                 String body_check) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?useSSL=false&&useUnicode=true&characterEncoding=utf-8&&serverTimezone=UTC",
                "root",
                "canisyue");
        String sql = "{CALL frontpage_creation(?,?,?,?,?,?,?,?)}"; //调用存储过程
        CallableStatement cstm = connection.prepareCall(sql); //实例化对象cstm
        cstm.setString(1, id); //IN PATIENTNAME TEXT
        cstm.setString(2, main_problem); //IN PATIENTNAME TEXT
        cstm.setString(3, disease_for_now); //IN PATIENTNAME TEXT
        cstm.setString(4, treatment_for_now); //IN PATIENTNAME TEXT
        cstm.setString(5, disease_for_past);
        cstm.setString(6, allergic_history);
        cstm.setString(7, body_check);


        cstm.registerOutParameter(8, Types.VARCHAR); // 设置返回值类型 即返回值
        cstm.execute(); // 执行存储过程
//        System.out.println(cstm.getString(5));
        cstm.close();
        connection.close();
    }

}


