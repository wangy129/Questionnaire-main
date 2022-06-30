package com.aim.questionnaire.feign;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.dao.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("userManage-service")
public interface UserFeign {

    @RequestMapping(value = "/service/userLogin", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity userLogin(@RequestBody UserEntity userEntity);

    @RequestMapping(value = "/service/queryUserList", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity queryUserList(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/addUserInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity addUserInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/modifyUserInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity modifyUserInfo(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/selectUserInfoById", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity selectUserInfoById(@RequestBody UserEntity userEntity);

    @RequestMapping(value = "/service/modifyUserStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity modifyUserStatus(@RequestBody Map<String, Object> map);

    @RequestMapping(value = "/service/deleteUserInfoById", method = RequestMethod.POST, headers = "Accept=application/json")
    HttpResponseEntity deteleUserInfoById(@RequestBody UserEntity userEntity);

    @RequestMapping(value = "/service/error")
    HttpResponseEntity logout();

}
