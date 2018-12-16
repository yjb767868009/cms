package com.xmu.cms.service;

import com.xmu.cms.entity.Course;
import com.xmu.cms.entity.Student;
import com.xmu.cms.entity.Teacher;
import com.xmu.cms.entity.Team;

import java.util.List;
import java.util.Map;

/**
 * @author JuboYu on 2018/11/27.
 * @version 1.0
 */
public interface CourseService {
    List<Course> getAllCoursesByTeacher(Teacher teacher);

    Map<String, String> deleteCourseById(Integer courseId);

    List<Course> getAllCoursesByStudent(Student student);

    Map<String, String> createCourse(Course course);

    Course getCourse(Integer courseId);

    List<Team> getTeamInCourse(Course course);

    List<Team> getTeamInCourseByStudent(Course course, Student student);
}
