package com.zjj.dao;

import com.zjj.domain.Student;

import java.util.List;

/**
 * studentdao访问接口
 */
public interface StudentDao {
    /**
     * 查询所有学生
     * @return
     */
    public List<Student> query();

    /**
     * 添加一个学生
     * @param student
     */
    public void save(Student student);
}
