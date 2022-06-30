package com.aim.projectManage.service;

import com.aim.projectManage.dao.ProjectEntityMapper;
import com.aim.questionnaire.common.utils.DateUtil;
import com.aim.questionnaire.common.utils.UUIDUtil;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import com.aim.userManage.dao.UserEntityMapper;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wln on 2018\8\6 0006.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectEntityMapper projectEntityMapper;


    /**
     * 添加项目
     * @param projectEntity
     * @return
     */
    public int addProjectInfo(ProjectEntity projectEntity,String user) {
        if(user != null) {
            int projectResult = projectEntityMapper.queryExistUser(projectEntity);
            if(projectResult != 0) {
                //项目已经存在
                return 3;
            }
        }
        String id = UUIDUtil.getOneUUID();
        Date date = DateUtil.getCreateTime();
        projectEntity.setId(id);
        projectEntity.setLastUpdateDate(date);
        projectEntity.setCreationDate(date);
        projectEntityMapper.insert(projectEntity);
        return 0;
    }

    /**
     * 修改项目
     * @param projectEntity
     * @return
     */
    public int modifyProjectInfo(ProjectEntity projectEntity,String user) {
        Date date = DateUtil.getCreateTime();
        projectEntity.setLastUpdateDate(date);
        projectEntity.setLastUpdatedBy(user);
        projectEntityMapper.updateByPrimaryKey(projectEntity);
        return 1;
    }

    /**
     * 删除项目
     * @param id
     * @return
     */
    public int deleteProjectById(String id) {
       projectEntityMapper.deleteProjectById(id);
       return 0;
    }

    /**
     * 查询项目列表
     * @param projectEntity
     * @return
     */
    public  List<Map<String,Object>> queryProjectList(ProjectEntity projectEntity) {
        List<Map<String,Object>> resultList = projectEntityMapper.queryProjectList(projectEntity);
        return resultList;
    }

    /**
     * 查询全部项目的名字接口
     * @return
     */
    public List<Map<String,Object>> queryAllProjectName() {
        return null;
    }
}
