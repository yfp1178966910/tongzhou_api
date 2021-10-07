package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.CenterIntroduceEntityMapper;
import com.combanc.cas.client.springboot.entity.*;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.CenterIntroduceService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


@Service
public class CenterIntroduceServiceImpl implements CenterIntroduceService {

    @Autowired
    private CenterIntroduceEntityMapper centerIntroduceEntityMapper;

    @Override
    public Result save(CenterIntroduceEntity dto) {
        if(dto.checkAction(ActionEnum.create)){
            if (ifTypeUnique(dto)) return Result.failed("中心简介与历史沿革只能创建一条信息 ");

            dto.setId(Commons.getIdentifier());
            dto.setCreateTime(ConstantUtils.FORMAT_DATETIME_FORMAT.format(new Date()));
            if (ifInWeightRange(dto)) return Result.failed("权重超出范围");
            int num = centerIntroduceEntityMapper.insertSelective(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            CenterIntroduceEntity byId = findById(dto.getId());
            if(byId==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                dto.setIntroduceType(null);//不允许修改类型
                if (ifInWeightRange(dto)) return Result.failed("权重超出范围");
                int num = centerIntroduceEntityMapper.updateByPrimaryKeySelective(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                int num = centerIntroduceEntityMapper.deleteByPrimaryKey(dto.getId());
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    private boolean ifTypeUnique(CenterIntroduceEntity dto) {
        if (ConstantUtils.UNIQUE_INTRODUCE_TYPE1.equals(dto.getIntroduceType()) || ConstantUtils.UNIQUE_INTRODUCE_TYPE2.equals(dto.getIntroduceType())){
            CenterIntroduceEntity test = new CenterIntroduceEntity();
            test.setIntroduceType(dto.getIntroduceType());
            PageBean<CenterIntroduceEntity> byList = findByPgList(test);
            List<CenterIntroduceEntity> rows = byList.getRows();
            if (rows.size()>=1){
                return true;
            }
        }
        return false;
    }

    private boolean ifInWeightRange(CenterIntroduceEntity dto) {
        if (dto.getIntroduceWeight() != null) {
            Integer weight = dto.getIntroduceWeight();
            if (weight < 0 || weight > 9999) {
                return true;
            }
        }
        return false;
    }

    @Override
    public CenterIntroduceEntity findById(String id) {
        return centerIntroduceEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Result findByList(CenterIntroduceEntity dto) {
        CenterIntroduceEntityExample example = new CenterIntroduceEntityExample();
        CenterIntroduceEntityExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if (!StringUtils.isEmpty(dto.getIntroduceTitle())){
            criteria.andIntroduceTitleLike("%"+dto.getIntroduceTitle()+"%");
        }
        if (!StringUtils.isEmpty(dto.getIntroduceType())){
            criteria.andIntroduceTypeEqualTo(dto.getIntroduceType());
        }
        example.setOrderByClause("introduce_weight ASC ,create_time DESC");
        List<CenterIntroduceEntity> centerIntroduceEntities = centerIntroduceEntityMapper.selectByExample(example);
        return  Result.success(centerIntroduceEntities);
    }

    @Override
    public PageBean<CenterIntroduceEntity> findByPgList(CenterIntroduceEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        CenterIntroduceEntityExample example = new CenterIntroduceEntityExample();
        example.setOffset(dto.getOffset());
        example.setLimit(dto.getLimit());
        CenterIntroduceEntityExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if (!StringUtils.isEmpty(dto.getIntroduceTitle()) && !"".equals(dto.getIntroduceTitle())){
            criteria.andIntroduceTitleLike("%"+dto.getIntroduceTitle()+"%");
        }
        if (!StringUtils.isEmpty(dto.getIntroduceType())){
            criteria.andIntroduceTypeEqualTo(dto.getIntroduceType());
        }
        example.setOrderByClause("introduce_weight ASC ,create_time DESC");
        int count = centerIntroduceEntityMapper.selectByPgExampleCount(example);
        List<CenterIntroduceEntity> list = centerIntroduceEntityMapper.selectByExample(example);
        return new PageBean<>(list, count);
    }
}
