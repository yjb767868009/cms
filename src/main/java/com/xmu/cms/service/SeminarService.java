package com.xmu.cms.service;

import com.xmu.cms.entity.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author JuboYu on 2018/11/29.
 * @version 1.0
 */
public interface SeminarService {
    Map<String, String> newSeminar(Seminar seminar);

    Map<String, String> deleteSeminar(BigInteger seminarId);

    List<Seminar> getSeminarsByCourseId(BigInteger courseId);

    Map<String, String> modifySeminar(Seminar seminar);

    Map<String, String> modifySeminarReportDDL(Seminar seminar);

    Seminar getSeminarBySeminarId(BigInteger seminarId);

    List<Round> getRoundsByCourseId(BigInteger courseId);

    List<Seminar> getAllSeminarInRound(BigInteger roundId);

    Map<String, String> newRound(Round round);

    Seminar getRunningSeminarByTeacherId(BigInteger userId);

    List<Attendance> getAttendancesInSeminar(BigInteger seminarId);

    Map<String, String> setAttendancePresentationScore(BigInteger attendanceId, Float presentationScore);

    Map<String, String> newAttendance(BigInteger klassSeminarId, BigInteger teamOrder);

    Round getRoundByRoundId(BigInteger roundId);

    Map<String, String> modifyRound(Round round);

    RoundScore getRoundTeamScore(BigInteger roundId, BigInteger teamId);

    List<RoundScore> getRoundScore(BigInteger roundId);

    SeminarScore getSeminarTeamScore(BigInteger seminarId, BigInteger teamId);

    List<SeminarScore> getSeminarScore(BigInteger seminarId);

    List<Question> getQuestionInKlassSeminar(BigInteger klassSeminarId);

    Question askQuestion(BigInteger userId, BigInteger attendanceId);

    Map<String, String> scoreQuestion(Question question);
}
