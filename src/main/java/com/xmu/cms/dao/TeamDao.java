package com.xmu.cms.dao;

import com.xmu.cms.entity.Course;
import com.xmu.cms.entity.Student;
import com.xmu.cms.entity.Team;

import java.util.List;

/**
 * @author JuboYu on 2018/12/16.
 * @version 1.0
 */
public interface TeamDao {
    List<Team> getTeamInCourse(Course course);

    Team getTeamInCourseByStudent(Course course, Student student);
}
