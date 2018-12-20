package com.xmu.cms.mapper;

import com.xmu.cms.entity.Klass;
import com.xmu.cms.entity.Seminar;
import com.xmu.cms.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JuboYu on 2018/11/29.
 * @version 1.0
 */
@Mapper
public interface KlassMapper {
    Integer insertKlass(Klass klass);

    List<Seminar> getStudentKlassByCourseId(@Param("studentId") Integer studentId,
                                            @Param("courseId") Integer courseId);

    Integer deleteKlassByKlassId(@Param("klassId") Integer klassId);

    List<Klass> getAllKlass(@Param("courseId") Integer courseId);

    /**
     * 通过班级id获取班级
     *
     * @param klassId 班级id
     * @return 班级对象
     */
    Klass getKlassByKlassId(@Param("kassId") Integer klassId);//todo

    /**
     * 在班级学生关系表中加入新学生的信息
     *
     * @param courseId 课程id
     * @param klassId  班级id
     * @param student  待加入的学生
     * @return 插入学生成功信息
     */
    Integer addStudent(Integer courseId, Integer klassId, Student student);//todo

    /**
     * 获取班级里的所有课程
     * @param courseId 课程id
     * @return 班级列表
     */
    List<Klass> getKlassesInCourse(Integer courseId);//todo

    /**
     * 删除班级轮次信息
     * @param klassId 班级信息
     * @param roundId 轮次信息
     * @return 删除信息
     */
    Integer deleteKlassRound(Integer klassId, Integer roundId);//todo

    /**
     * 删除班级与学生的关系
     * @param klassId 班级id
     * @return 删除信息
     */
    Integer deleteKlassStudent(Integer klassId);
}
