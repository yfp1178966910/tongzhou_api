package com.combanc.cas.client.springboot.dao;

import com.combanc.cas.client.springboot.entity.SignInEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface SignInDao extends BaseDao<SignInEntity> {
    List<Map<String, Object>> findByPgList(SignInEntity dto);

    int findStatisticalDataCount(SignInEntity dto);

    List<Map<String, String>> findStatisticalData(SignInEntity dto);

    List<Map<String, String>> findStatisticalDataForExcel(SignInEntity dto);

    int findCheckDataCount(SignInEntity dto);

    List<SignInEntity> findCheckData(SignInEntity dto);

    Integer deleteByCourseId(String courseId);
    Integer deleteBySignUpId(String signUpId);
    void commitSignInScore(String id, BigDecimal unitScore);
    List<SignInEntity> findByListDto(SignInEntity dto);
}
