package com.aim.questionnaire.feign;

import com.aim.questionnaire.beans.HttpResponseEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("userManage-service")
public interface UserRoleFeign {

    @RequestMapping(value = "/service/queryRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryUserList();

    @RequestMapping(value = "/service/addRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity addRoleInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/modifyRoleStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity modifyRoleStatus(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/queryAllRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryAllRoleInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/queryRolePermissionList", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryRolePermissionList(@RequestBody(required = false) Map<String, Object> map);

    @RequestMapping(value = "/service/deleteRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity deleteRoleInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/modifyRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity modifyRoleInfo(@RequestBody Map<String, Object> map);
}
