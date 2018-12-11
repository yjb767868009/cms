package com.xmu.cms.entity;

import java.sql.Timestamp;

/**
 * @author JuboYu on 2018/11/26.
 * @version 1.0
 */
public class Course {
    private Integer courseId;
    private Teacher teacher;
    private String CourseName;
    private String introduction;
    private Float presentationWeight;
    private Float reportWeight;
    private Float questionWeight;
    private Timestamp teamStartTime;
    private Timestamp teamEndTime;

    public Course(Integer courseId, Teacher teacher, String CourseName, String introduction, Float presentationWeight, Float reportWeight, Float questionWeight, Timestamp teamStartTime, Timestamp teamEndTime) {
        this.courseId = courseId;
        this.teacher = teacher;
        this.CourseName = CourseName;
        this.introduction = introduction;
        this.presentationWeight = presentationWeight;
        this.reportWeight = reportWeight;
        this.questionWeight = questionWeight;
        this.teamStartTime = teamStartTime;
        this.teamEndTime = teamEndTime;
    }

    public Course() {
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer id) {
        this.courseId = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Float getPresentationWeight() {
        return presentationWeight;
    }

    public void setPresentationWeight(Float presentationWeight) {
        this.presentationWeight = presentationWeight;
    }

    public Float getReportWeight() {
        return reportWeight;
    }

    public void setReportWeight(Float reportWeight) {
        this.reportWeight = reportWeight;
    }

    public Float getQuestionWeight() {
        return questionWeight;
    }

    public void setQuestionWeight(Float questionWeight) {
        this.questionWeight = questionWeight;
    }

    public Timestamp getTeamStartTime() {
        return teamStartTime;
    }

    public void setTeamStartTime(Timestamp teamStartTime) {
        this.teamStartTime = teamStartTime;
    }

    public Timestamp getTeamEndTime() {
        return teamEndTime;
    }

    public void setTeamEndTime(Timestamp teamEndTime) {
        this.teamEndTime = teamEndTime;
    }
}
