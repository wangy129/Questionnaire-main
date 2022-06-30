package com.aim.questionnaire.feign;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.dao.entity.QuestionnaireEntity;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("questionnaireManage-service")
public interface QuestionnaireFeign {

  @RequestMapping(value = "/service/modifyQuestionnaireInfo", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity modifyQuestionnaireInfo(@RequestBody QuestionnaireEntity questionnaireEntity);

  @RequestMapping(value = "/service/selectQuestionnaireStatus", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity selectQuestionnaireStatus(@RequestBody QuestionnaireEntity questionnaireEntity);

  @RequestMapping(value = "/service/addQuestionnaire", method = RequestMethod.POST, headers = "Accept=application/json")
  public HttpResponseEntity addQuestionnaire(@RequestBody Map<String, Object> map);
}
