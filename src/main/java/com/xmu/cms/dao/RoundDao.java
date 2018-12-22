package com.xmu.cms.dao;

import com.xmu.cms.entity.Round;
import com.xmu.cms.support.UserInfo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author JuboYu on 2018/12/18.
 * @version 1.0
 */
public interface RoundDao {
    List<Round> getRoundsByCourseId(UserInfo info, BigInteger courseId);

    Round getRoundById(BigInteger roundId);

    Integer newRound(Round round);

    Integer updateCalType(Round round);
}
