package com.xmu.cms.dao;

import com.xmu.cms.entity.Course;
import com.xmu.cms.entity.Klass;
import com.xmu.cms.entity.Student;
import com.xmu.cms.entity.Team;
import com.xmu.cms.mapper.CourseMapper;
import com.xmu.cms.mapper.KlassMapper;
import com.xmu.cms.mapper.StudentMapper;
import com.xmu.cms.mapper.TeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

/**
 * @author JuboYu on 2018/12/16.
 * @version 1.0
 */
@Component
public class TeamDao {

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private KlassMapper klassMapper;

    @Autowired
    private CourseMapper courseMapper;

    public List<Team> getTeamAndMembersInCourse(BigInteger courseId) {
        List<Team> teams = teamMapper.getTeamInCourse(courseId);
        for (Team team : teams) {
            team.setMembers(studentMapper.getMembersInTeam(team.getTeamId()));
        }
        return teams;
    }

    public List<Team> getTeamInCourse(BigInteger courseId) {
        return teamMapper.getTeamInCourse(courseId);
    }

    public List<Team> getAllTeamsInSeminar(BigInteger seminarId) {
        List<Team> teams = teamMapper.getAllTeamsInSeminar(seminarId);
        for (Team team : teams) {
            team.setMembers(studentMapper.getMembersInTeam(team.getTeamId()));
        }
        return teams;
    }

    public Team newTeam(BigInteger courseId, BigInteger klassId, BigInteger studentId, Team newTeam) {
        Team bigTeam = teamMapper.getLastTeamInKlass(klassId);
        newTeam.setKlassSerial(bigTeam.getKlassSerial());
        newTeam.setTeamSerial(bigTeam.getTeamSerial() + 1);
        newTeam.setLeader(new Student(studentId));
        newTeam.setKlass(new Klass(klassId));
        newTeam.setCourse(new Course(courseId));
        klassMapper.addTeam(klassId,newTeam.getTeamId());
        teamMapper.insertTeam(newTeam);
        Team team = teamMapper.getTeamBySerial(newTeam.getKlassSerial(), newTeam.getTeamSerial());
        klassMapper.addMembers(team.getTeamId(), studentId);
        List<Student> students = newTeam.getMembers();
        if (students != null) {
            for (Student student : students) {
                klassMapper.addMembers(team.getTeamId(), student.getStudentId());
            }
        }
        return getFullTeam(team.getTeamId());
    }

    public Team getTeamByTeamId(BigInteger teamId) {
        return teamMapper.getTeamByTeamId(teamId);
    }

    public Integer deleteTeam(BigInteger teamId) {
        klassMapper.deleteTeamStudent(teamId);
        klassMapper.deleteKlassTeam(teamId);
        return teamMapper.deleteTeamByTeamId(teamId);
    }

    public Team addMembers(BigInteger teamId, List<Student> students) {
        Team team = teamMapper.getTeamByTeamId(teamId);
        for (Student student : students) {
            Team findTeam = teamMapper.getStudentTeamInKlass(student.getStudentId(), team.getKlass().getKlassId());
            if (findTeam == null) {
                klassMapper.addMembers(team.getTeamId(), student.getStudentId());
            }
        }
        return getFullTeam(teamId);
    }

    private Team getFullTeam(BigInteger teamId) {
        Team team = teamMapper.getTeamByTeamId(teamId);
        List<Student> members = studentMapper.getMembersInTeam(teamId);
        for (Student student : members) {
            List<Course> courses = courseMapper.getAllCourseByStudentId(student.getStudentId());
            student.setCourses(courses);
        }
        team.setMembers(members);
        return team;
    }

    public Team removeMember(BigInteger teamId, Student student) {
        klassMapper.removeTeamStudent(teamId, student);
        return getFullTeam(teamId);
    }

    public void updateTeamValid(Team team) {
        teamMapper.updateTeamValid(team);
    }

    public Team getStudentTeamInKlassSeminar(BigInteger studentId, BigInteger klassSeminarId) {
        return teamMapper.getStudentTeamInKlassSeminar(studentId, klassSeminarId);
    }

    public Team getStudentTeamInKlass(BigInteger studentId, BigInteger klassId) {
        return teamMapper.getStudentTeamInKlass(studentId, klassId);
    }

    public List<Team> getSimpleTeamInCourse(BigInteger courseId) {
        return teamMapper.getSimpleTeamInCourse(courseId);
    }

    public Team getStudentTeamInCourse(BigInteger studentId, BigInteger courseId) {
        return teamMapper.getStudentTeamInCourse(studentId, courseId);
    }

    public Team getTeamAndMembers(BigInteger teamId) {
        Team team = teamMapper.getTeamByTeamId(teamId);
        team.setMembers(studentMapper.getMembersInTeam(team.getTeamId()));
        return team;
    }

    public Team getStudentTeamInRound(BigInteger studentId, BigInteger roundId) {
        return teamMapper.getStudentTeamInRound(studentId, roundId);
    }
}
