package com.aim.QuestionnaireManage.service;

import com.aim.QuestionnaireManage.dao.QuestionnaireEntityMapper;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireEntityMapper questionnaireEntityMapper;

    /**
     * 查询问卷列表（模糊搜索）
     *
     * @param map
     * @return
     */
    public PageInfo<Map<String, Object>> queryQuestionnaireList(Map<String, Object> map) {

        //以下的代码是从用户管理里抄测，不一定对，大概需要重新写
        int pageNum = (int) map.get("pageNum");
        int pageSize = (int) map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        List<Map<String, Object>> userList = questionnaireEntityMapper.queryQuestionnaireList((HashMap<String, Object>) map);
        return new PageInfo<>(userList, pageSize);
    }

    /**
     * 创建问卷
     *
     * @param map
     * @return
     */
    public int addQuestionnaire(Map<String, Object> map) {

        return questionnaireEntityMapper.addQuestionnaire(map);
    }

    /**
     * 编辑问卷的基本信息
     *
     * @param questionnaireEntity
     * @return
     */
    public int modifyQuestionnaireInfo(QuestionnaireEntity questionnaireEntity) {
        questionnaireEntityMapper.modifyQuestionnaireInfo(questionnaireEntity);
        return 0;
    }

    /**
     * 修改问卷状态
     *
     * @param map
     * @return
     */
    public int modifyQuestionnaireStatus(Map<String, Object> map) {
        return 0;
    }

    /**
     * 根据主键查询问卷信息
     *
     * @param userEntity
     * @return
     */
    public Map<String, Object> selectByPrimaryKey(UserEntity userEntity) {

        return null;
    }

    /**
     * 通过主键删除问卷
     *
     * @param questionnaireEntity
     * @return
     */
    public int deleteByPrimaryKey(QuestionnaireEntity questionnaireEntity) {
        return questionnaireEntityMapper.deleteByPrimaryKey(questionnaireEntity.getId());
    }

    /**
     * 通过主键获取答题结束提示语、和短信内容
     *
     * @param questionnaireEntity
     * @return
     */
    public QuestionnaireEntity queryQuestContextEnd(QuestionnaireEntity questionnaireEntity) {
        return questionnaireEntityMapper.queryQuestContextEnd(questionnaireEntity.getId());
    }

    /**
     * 添加发送问卷方式
     *
     * @param map
     * @return
     */
    public int addSendQuestionnaire(HashMap<String, Object> map) {
        if (map.get("sendType").equals("0")) {
            //短信
            String context = (String) map.get("context");
            String sendInfo = (String) map.get("sendInfo");
        }
        if (map.get("sendType").equals("1")) {
            //邮件
            String emailTitle = (String) map.get("emailTitle");
            String context = (String) map.get("context");
            String sendInfo = (String) map.get("sendInfo");
        }
        if (map.get("sendType").equals("2")) {
            //链接
        }
        return questionnaireEntityMapper.addSendQuestionnaire(map);
    }

    public int queryQuestionnaireStatus(QuestionnaireEntity questionnaireEntity){
        return questionnaireEntityMapper.queryQuestionnaireStatus(questionnaireEntity.getId());
    }

    /**
     * 修改问卷状态
     *
     * @param map
     * @return
     */
    public int modifyQuestionnaireStatus(HashMap<String, Object> map) {
        return questionnaireEntityMapper.modifyQuestionnaireStatus(map);
    }
}
