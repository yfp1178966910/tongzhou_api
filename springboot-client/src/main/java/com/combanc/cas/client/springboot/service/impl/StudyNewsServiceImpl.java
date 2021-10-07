package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.StudyNewsEntityMapper;
import com.combanc.cas.client.springboot.entity.*;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.StudyNewsService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.PageBean;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class StudyNewsServiceImpl implements StudyNewsService {

    @Autowired
    private StudyNewsEntityMapper studyNewsDao;
    @Override
    @Synchronized
    public Result read(StudyNewsEntity dto) {
        StudyNewsEntity byId = findById(dto.getId());
        byId.setReadingVolume(byId.getReadingVolume()+1);
        studyNewsDao.updateByPrimaryKeySelective(byId);
        return Result.success(byId);
    }

    @Override
    public Result save(StudyNewsEntity dto) {
        if(dto.checkAction(ActionEnum.create)){
            dto.setId(Commons.getIdentifier());
            dto.setReadingVolume(0);
            dto.setCreateTime(ConstantUtils.FORMAT_DATETIME_FORMAT.format(new Date()));
            if (ifInWeightRange(dto)) return Result.failed("权重超出范围");
            int num = studyNewsDao.insertSelective(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            StudyNewsEntity byId = findById(dto.getId());
            if(byId==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                byId.setReadingVolume(null);
                if (ifInWeightRange(dto)) return Result.failed("权重超出范围");
                int num = studyNewsDao.updateByPrimaryKeySelective(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                int num = studyNewsDao.deleteByPrimaryKey(dto.getId());
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    private boolean ifInWeightRange(StudyNewsEntity dto) {
        if (dto.getNewsWeight() != null) {
            Integer newsWeight = dto.getNewsWeight();
            if (newsWeight < 0 || newsWeight > 9999) {
                return true;
            }
        }
        return false;
    }

    @Override
    public StudyNewsEntity findById(String id) {
        return studyNewsDao.selectByPrimaryKey(id);
    }

    @Override
    public Result findByList(StudyNewsEntity dto) {
        StudyNewsEntityExample studyNewsEntityExample = new StudyNewsEntityExample();
        StudyNewsEntityExample.Criteria criteria = studyNewsEntityExample.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if (!StringUtils.isEmpty(dto.getCreateTime())){
            criteria.andCreateTimeLike("%"+dto.getCreateTime()+"%");
        }
        if (!StringUtils.isEmpty(dto.getDisplayLocation())){
            criteria.andDisplayLocationEqualTo(dto.getDisplayLocation());
        }
        studyNewsEntityExample.setOrderByClause("news_weight ASC ,create_time DESC");
        List<StudyNewsEntity> studyNewsEntities = studyNewsDao.selectByExample(studyNewsEntityExample);
        return  Result.success(studyNewsEntities);
    }

    @Override
    public PageBean<StudyNewsEntity> findByPgList(StudyNewsEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        StudyNewsEntityExample studyNewsEntityExample = new StudyNewsEntityExample();
        studyNewsEntityExample.setOffset(dto.getOffset());
        studyNewsEntityExample.setLimit(dto.getLimit());
        StudyNewsEntityExample.Criteria criteria = studyNewsEntityExample.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if(!StringUtils.isEmpty(dto.getNewsTitle())){
            criteria.andNewsTitleLike("%"+dto.getNewsTitle()+"%");
        }
        if (!StringUtils.isEmpty(dto.getCreateTime())){
            criteria.andCreateTimeLike("%"+dto.getCreateTime()+"%");
        }
        if (!StringUtils.isEmpty(dto.getDisplayLocation())){
            criteria.andDisplayLocationEqualTo(dto.getDisplayLocation());
        }
        studyNewsEntityExample.setOrderByClause("news_weight ASC ,create_time DESC");
        int count = studyNewsDao.selectByPgExampleCount(studyNewsEntityExample);
        List<StudyNewsEntity> list = studyNewsDao.selectByExample(studyNewsEntityExample);
        return new PageBean<>(list, count);
    }
}
