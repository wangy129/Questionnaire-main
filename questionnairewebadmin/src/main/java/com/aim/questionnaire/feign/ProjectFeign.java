package com.aim.questionnaire.feign;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.dao.entity.ProjectEntity;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("projectManage-service")
public interface ProjectFeign {

    @RequestMapping(value = "/service/queryProjectList", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryProjectList(@RequestBody(required = false) ProjectEntity projectEntity);

    @RequestMapping(value = "/service/deleteProjectById", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity deleteProjectById(@RequestBody ProjectEntity projectEntity);

    @RequestMapping(value = "/service/addProjectInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity addProjectInfo(@RequestBody ProjectEntity projectEntity);

    @RequestMapping(value = "/service/modifyProjectInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity modifyProjectInfo(@RequestBody ProjectEntity projectEntity);

    @RequestMapping(value = "/service/queryAllProjectName", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryAllProjectName();
}
