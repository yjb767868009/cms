package com.xmu.cms.service.Impl;

import com.xmu.cms.dao.*;
import com.xmu.cms.entity.*;
import com.xmu.cms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JuboYu on 2018/11/27.
 * @version 1.0
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private KlassDao klassDao;

    @Autowired
    private ShareTeamDao shareTeamDao;

    @Autowired
    private ShareSeminarDao shareSeminarDao;

    @Override
    public List<Course> getAllCoursesByTeacher(Teacher teacher) {
        return courseDao.getAllCoursesByTeacherId(teacher.getTeacherId());
    }

    @Override
    public Map<String, String> deleteCourseById(BigInteger courseId) {
        Map<String, String> message = new HashMap<String, String>(2);
        Integer count = courseDao.deleteCourse(courseId);
        if (count == 1) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public List<Course> getAllCoursesByStudent(Student student) {
        return courseDao.getAllCourseByStudentId(student.getStudentId());
    }

    @Override
    public Map<String, String> createCourse(Course course) {
        Map<String, String> message = new HashMap<String, String>(2);
        Integer count = courseDao.createCourse(course);
        if (count == 1) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public Course getCourse(BigInteger courseId) {
        return courseDao.getCourse(courseId);
    }

    @Override
    public List<Team> getTeamInCourse(BigInteger courseId) {
        return teamDao.getTeamInCourse(courseId);
    }

    @Override
    public List<Team> getTeamInCourseByStudent(BigInteger courseId, BigInteger studentId) {
        List<Team> teams = new ArrayList<Team>();
        teams.add(teamDao.getTeamInCourseByStudent(courseId, studentId));
        return teams;
    }

    @Override
    public Map<String, String> newKlass(BigInteger courseId, Klass klass) {
        Map<String, String> message = new HashMap<String, String>(2);
        Integer count = klassDao.newKlass(courseId, klass);
        if (count == 1) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public List<Klass> getKlassInCourse(BigInteger courseId) {
        return klassDao.getAllKlass(courseId);
    }

    @Override
    public Map<String, String> deleteKlass(BigInteger classId) {
        //TODO
        return null;
    }

    @Override
    public List<Object> getShareInCourse(BigInteger courseId) {
        List<Object> shares = new ArrayList<>();
        shares.addAll(shareTeamDao.getShareTeamInCourse(courseId));
        shares.addAll(shareSeminarDao.getShareSeminarInCourse(courseId));
        return shares;
    }

    @Override
    public Map<String, String> deleteShare(BigInteger courseId, BigInteger shareId) {
        Map<String, String> message = new HashMap<String, String>(1);
        Integer count = shareTeamDao.deleteShare(courseId, shareId);
        if (count == 1) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public Team newTeam(BigInteger courseId, BigInteger classId, BigInteger studentId, Team team) {
        return teamDao.newTeam(courseId, classId, studentId, team);
    }

    @Override
    public Team getTeamByTeamId(BigInteger teamId) {
        return teamDao.getTeamByTeamId(teamId);
    }

    @Override
    public Map<String, String> deleteTeam(BigInteger teamId) {
        Map<String, String> message = new HashMap<String, String>(1);
        Integer count = teamDao.deleteTeam(teamId);
        if (count > 0) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public Map<String, String> teamAddMembers(BigInteger teamId, List<Student> students) {
        Map<String, String> message = new HashMap<String, String>(1);
        Integer count = teamDao.addMembers(teamId, students);
        if (count > 0) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public Map<String, String> teamRemoveMember(BigInteger teamId, Student student) {
        Map<String, String> message = new HashMap<String, String>(1);
        Integer count = teamDao.removeMember(teamId, student);
        if (count > 0) {
            message.put("message", "Success");
        } else {
            message.put("message", "Error");
        }
        return message;
    }

    @Override
    public List<ShareTeam> getShareTeamInCourse(BigInteger courseId) {
        return shareTeamDao.getShareTeamInCourse(courseId);
    }

    @Override
    public List<ShareSeminar> getShareSeminarInCourse(BigInteger courseId) {
        return shareSeminarDao.getShareSeminarInCourse(courseId);
    }
}
