package com.aim.QuestionnaireManage.controller;

import com.aim.QuestionnaireManage.service.QuestionnaireService;
import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.common.Constans;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class QuestionnaireController {
    private final Logger logger = LoggerFactory.getLogger(QuestionnaireController.class);

    @Autowired
    private QuestionnaireService questionnaireService;

    /**
     * 添加问卷
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addQuestionnaire(@RequestBody Map<String, Object> map) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = questionnaireService.addQuestionnaire(map);
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage(Constans.ADD_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return httpResponseEntity;
    }

    /**
     * 根据id删除问卷
     *
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/deleteQuestionnaireById", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteProjectById(@RequestBody QuestionnaireEntity questionnaireEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        int result = questionnaireService.deleteByPrimaryKey(questionnaireEntity);
        if (result == 1) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setMessage(Constans.DELETE_MESSAGE);
        } else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
            httpResponseEntity.setMessage(Constans.COPY_EXIT_DELETE_MESSAGE);
        }
        return httpResponseEntity;
    }

    /**
     * 根据id获取答题结束提示语、和短信内容
     *
     * @param questionnaireEntity
     * @return
     */
    @RequestMapping(value = "/queryQuestContextEnd", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryQuestContextEnd(@RequestBody QuestionnaireEntity questionnaireEntity) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        QuestionnaireEntity data = questionnaireService.queryQuestContextEnd(questionnaireEntity);
        if (data != null) {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
            httpResponseEntity.setData(data);
            httpResponseEntity.setMessage(Constans.STATUS_MESSAGE);
        } else {
            httpResponseEntity.setCode(Constans.EXIST_CODE);
            httpResponseEntity.setMessage(Constans.EXIST_MESSAGE);
        }
        return httpResponseEntity;
    }

    /**
     * 添加发送问卷方式
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addSendQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addSendQuestionnaire(@RequestBody HashMap<String, Object> map) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        int result = questionnaireService.addSendQuestionnaire(map);
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setData(result);
        httpResponseEntity.setMessage(Constans.ADD_MESSAGE);
        return httpResponseEntity;
    }

    /**
     * 生成二维码
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getShortUrlForLink", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryQuestContextEnd(@RequestBody Map<String, Object> map) {
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        String tinyurl = (String) map.get("link");
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        httpResponseEntity.setData(tinyurl);
        httpResponseEntity.setMessage(Constans.MAKE_MESSAGE);
        return httpResponseEntity;
    }

    @RequestMapping(value = "/modifyQuestionnaireInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        questionnaireService.modifyQuestionnaireInfo(questionnaireEntity);
        return httpResponseEntity;
    }

    @RequestMapping(value = "/selectQuestionnaireStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity selectQuestionnaireStatus(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();
        httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        int status = questionnaireService.queryQuestionnaireStatus(questionnaireEntity);
        httpResponseEntity.setData(status);
        return httpResponseEntity;
    }

    @RequestMapping(value = "/selectQuestSendStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity selectQuestSendStatus(@RequestBody QuestionnaireEntity questionnaireEntity){
        HttpResponseEntity httpResponseEntity =new HttpResponseEntity();

        int status = questionnaireService.queryQuestionnaireStatus(questionnaireEntity);
        if(status==1){
            httpResponseEntity.setCode(Constans.QUESTIONNAIRE_SEND_CODE);
            httpResponseEntity.setMessage(Constans.QUESTIONNAIRE_SEND_MESSAGE);
        }else {
            httpResponseEntity.setCode(Constans.SUCCESS_CODE);
        }
        httpResponseEntity.setData(status);
        return httpResponseEntity;
    }
}
