package com.aim.questionnaire.controller;


import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import com.aim.questionnaire.feign.QuestionnaireFeign;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireFeignController {

  @Autowired
  private QuestionnaireFeign questionnaireFeign;

  @RequestMapping(value = "/modifyQuestionnaireInfo", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity modifyQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity){
    return questionnaireFeign.modifyQuestionnaireInfo(questionnaireEntity);
  };

  @RequestMapping(value = "/selectQuestionnaireStatus", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity selectQuestionnaireStatus(@RequestBody QuestionnaireEntity questionnaireEntity){
    return questionnaireFeign.selectQuestionnaireStatus(questionnaireEntity);
  };

  @RequestMapping(value = "/addQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity addQuestionnaire(@RequestBody Map<String, Object> map){
    return questionnaireFeign.addQuestionnaire(map);
  };

}
