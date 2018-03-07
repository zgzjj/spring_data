package com.zjj.dao;

import com.zjj.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoImplTest {
    @Test
    public void testQuery(){
        StudentDao studentDao=new StudentDaoImpl();
        List<Student> students=studentDao.query();
        for(Student student:students){
            System.out.println("id:"+student.getId());
            System.out.println("name:"+student.getName());
            System.out.println("age:"+student.getAge());
        }
    }

    @Test
    public void testSave(){
        StudentDao studentDao=new StudentDaoImpl();
        Student student =new Student();
        student.setName("test");
        student.setAge(30);
        studentDao.save(student);
    }
}
