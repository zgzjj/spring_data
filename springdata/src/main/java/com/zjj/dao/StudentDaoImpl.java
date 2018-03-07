package com.zjj.dao;

import com.zjj.domain.Student;
import com.zjj.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDao访问接口实现类，通过最原始的JDBC方式操作
 */
public class StudentDaoImpl implements StudentDao{

    public List<Student> query() {
        List<Student> students=new ArrayList<Student>();
        Connection connection=null;
        String sql="SELECT id,name,age FROM student";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            Student student=null;
            while ((resultSet.next())){
               int id = resultSet.getInt("id");
               String name=resultSet.getString("name");
               int age=resultSet.getInt("age");
               student=new Student();
               student.setId(id);
               student.setName(name);
               student.setAge(age);
               students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
        return students;
    }

    public void save(Student student) {
        Connection connection=null;
        String sql="insert into student(name,age) values(?,?)";
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection= JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }
    }
}
