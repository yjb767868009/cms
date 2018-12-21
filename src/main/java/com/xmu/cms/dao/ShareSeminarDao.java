package com.xmu.cms.dao;

import com.xmu.cms.entity.ShareSeminar;

import java.math.BigInteger;
import java.util.List;

/**
 * @author JuboYu on 2018/12/20.
 * @version 1.0
 */
public interface ShareSeminarDao {
    List<ShareSeminar> getShareSeminarInCourse(BigInteger courseId);
}
