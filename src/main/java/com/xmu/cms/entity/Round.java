package com.xmu.cms.entity;

import java.math.BigInteger;

/**
 * @author JuboYu on 2018/11/27.
 * @version 1.0
 */
public class Round {
    private BigInteger roundId;
    private Integer order;
    private Course course;
    private Integer presentationScoreType;
    private Integer reportScoreType;
    private Integer questionScoreType;

    public Round(BigInteger roundId, Integer order, Course course, Integer presentationScoreType, Integer reportScoreType, Integer questionScoreType) {
        this.roundId = roundId;
        this.order = order;
        this.course = course;
        this.presentationScoreType = presentationScoreType;
        this.reportScoreType = reportScoreType;
        this.questionScoreType = questionScoreType;
    }

    public Round() {
    }

    public BigInteger getRoundId() {
        return roundId;
    }

    public void setRoundId(BigInteger roundId) {
        this.roundId = roundId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getPresentationScoreType() {
        return presentationScoreType;
    }

    public void setPresentationScoreType(Integer presentationScoreType) {
        this.presentationScoreType = presentationScoreType;
    }

    public Integer getReportScoreType() {
        return reportScoreType;
    }

    public void setReportScoreType(Integer reportScoreType) {
        this.reportScoreType = reportScoreType;
    }

    public Integer getQuestionScoreType() {
        return questionScoreType;
    }

    public void setQuestionScoreType(Integer questionScoreType) {
        this.questionScoreType = questionScoreType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
