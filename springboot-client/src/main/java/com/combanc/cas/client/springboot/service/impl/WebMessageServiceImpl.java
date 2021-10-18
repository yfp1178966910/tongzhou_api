package com.combanc.cas.client.springboot.service.impl;

import com.combanc.cas.client.springboot.dao.WebMessageEntityMapper;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.WebMessageEntity;
import com.combanc.cas.client.springboot.entity.WebMessageEntityExample;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.WebMessageService;
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
public class WebMessageServiceImpl implements WebMessageService {
    
    @Autowired
    private WebMessageEntityMapper webMessageEntityMapper;
    
    @Override
    public Result save(WebMessageEntity dto) {
        if(dto.checkAction(ActionEnum.create)){
            dto.setId(Commons.getIdentifier());
            dto.setReadingVolume(0);
            dto.setCreateTime(ConstantUtils.FORMAT_DATETIME_FORMAT.format(new Date()));
            int num = webMessageEntityMapper.insertSelective(dto);
            return num > 0 ? Result.success() : Result.failed("添加失败");
        }else {
            WebMessageEntity byId = findById(dto.getId());
            if(byId==null){return Result.failed("数据不存在");}
            if(dto.checkAction(ActionEnum.update)){
                dto.setReadingVolume(null);
                int num = webMessageEntityMapper.updateByPrimaryKeySelective(dto);
                return num > 0 ? Result.success() : Result.failed("修改失败");
            }else if(dto.checkAction(ActionEnum.delete)){
                if(!StringUtils.isEmpty(byId.getDeleteUser()) && byId.getDeleteUser().contains(dto.getUserId())){
                    Result.failed("已经删除的项目");
                }
                byId.setDeleteUser(dto.getUserId()+","+byId.getDeleteUser());
                int num = webMessageEntityMapper.updateByPrimaryKeySelective(byId);
                return num > 0 ? Result.success() : Result.failed("删除失败");
            }
        }
        return Result.failed("未设置Action");
    }

    @Override
    public WebMessageEntity findById(String id) {
        return webMessageEntityMapper.selectByPrimaryKey(id);
    }
    @Override
    public int deleteById(String id) {return webMessageEntityMapper.deleteByPrimaryKey(id);}

    @Override
    public void updateAllReadByUserId(String userId) {
        webMessageEntityMapper.updateAllReadByUserId(userId);
    }

    @Override
    public Result findByList(WebMessageEntity dto) {
        WebMessageEntityExample webMessageEntityExample = new WebMessageEntityExample();
        WebMessageEntityExample.Criteria criteria = webMessageEntityExample.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if(!StringUtils.isEmpty(dto.getDepartment())){
            criteria.andDepartmentEqualTo(dto.getDepartment());
        }
        if(!StringUtils.isEmpty(dto.getDepartmentPart())){
            criteria.andDepartmentPartEqualTo(dto.getDepartmentPart());
        }
        if(!StringUtils.isEmpty(dto.getCreateTime())){
            criteria .andCreateTimeLike("%" + dto.getCreateTime()+"%");
        }
        if(!StringUtils.isEmpty(dto.getUserId())){
            criteria.andUserIdEqualTo(dto.getUserId());
        }
        List<WebMessageEntity> webMessageEntities = webMessageEntityMapper.selectByExample(webMessageEntityExample);
        return Result.success(webMessageEntities);
    }

    @Override
    public PageBean<WebMessageEntity> findByPgList(WebMessageEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        WebMessageEntityExample webMessageEntityExample = new WebMessageEntityExample();
        webMessageEntityExample.setOffset(dto.getOffset());
        webMessageEntityExample.setLimit(dto.getLimit());
        WebMessageEntityExample.Criteria criteria = webMessageEntityExample.createCriteria();
        if (!StringUtils.isEmpty(dto.getId())){
            criteria.andIdEqualTo(dto.getId());
        }
        if(!StringUtils.isEmpty(dto.getDepartment())){
            criteria.andDepartmentEqualTo(dto.getDepartment());
        }
        if(!StringUtils.isEmpty(dto.getDepartmentPart())){
            criteria.andDepartmentPartEqualTo(dto.getDepartmentPart());
        }
        if(!StringUtils.isEmpty(dto.getCreateTime())){
            criteria.andCreateTimeLike("%"+dto.getCreateTime()+"%");
        }
        if(!StringUtils.isEmpty(dto.getUserId())){
            criteria.andUserIdEqualTo(dto.getUserId());
            criteria.andUserIdContains(dto.getUserId());
        }
        if(!StringUtils.isEmpty(dto.getIsFloat())){
            criteria.andIsFloatEqualTo(dto.getIsFloat());
        }
        webMessageEntityExample.setOrderByClause("create_time DESC");
        int count = webMessageEntityMapper.selectByPgExampleCount(webMessageEntityExample);
        List<WebMessageEntity> list = webMessageEntityMapper.selectByPgExample(webMessageEntityExample);
        return new PageBean<>(list, count);
    }

    @Override
    public int getStates(WebMessageEntity data) {
        data.setReadUser(data.getUserId());
        int count = webMessageEntityMapper.getStates(data);
        return count;
    }

    @Override

    public Result changeStates(WebMessageEntity data) {
        if (getStates(data)==1){
            return Result.success();
        }
        int num = getChangeStatesNum(data);
        return num > 0 ? Result.success(1) : Result.failed("修改失败");
    }

    @Synchronized
    private int getChangeStatesNum(WebMessageEntity data) {
        WebMessageEntity webMessageEntity = webMessageEntityMapper.selectByPrimaryKey(data.getId());
        webMessageEntity.setReadUser(data.getUserId()+ "," + webMessageEntity.getReadUser());
        webMessageEntity.setReadingVolume(webMessageEntity.getReadingVolume()+1);
        return webMessageEntityMapper.updateByPrimaryKeySelective(webMessageEntity);
    }

    @Override
    public PageBean<WebMessageEntity> getMessages(WebMessageEntity dto) {
        dto.setOffset(dto.getOffset() == null ? 0 : dto.getOffset());
        dto.setLimit(dto.getLimit() == null ? 10 : dto.getLimit());
        int count = webMessageEntityMapper.getMessagesCount(dto);
        List<WebMessageEntity> list = webMessageEntityMapper.getMessages(dto);
        return new PageBean<>(list, count);
    }

    @Override
    public Result changeAllMessages(WebMessageEntity data) {
        int num= webMessageEntityMapper.changeAllMessages(data);
        return num > 0 ? Result.success("全部标记为已读") : Result.failed("无可标记项");
    }
}
