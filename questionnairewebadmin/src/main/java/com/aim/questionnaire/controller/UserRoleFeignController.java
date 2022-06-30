package com.aim.questionnaire.controller;

import com.aim.questionnaire.beans.HttpResponseEntity;
import com.aim.questionnaire.feign.UserRoleFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by wln on 2018\8\10 0010.
 */
@RestController
@RequestMapping("/admin")
public class UserRoleFeignController {

    @Autowired
    private UserRoleFeign userRoleFeign;

    /**
     * 角色查询
     *
     * @return
     */
    @RequestMapping(value = "/queryRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryUserList() {
        return userRoleFeign.queryUserList();
    }

    /**
     * 添加角色
     *
     * @return
     */
    @RequestMapping(value = "/addRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity addRoleInfo(@RequestBody Map<String, Object> map) {
        return userRoleFeign.addRoleInfo(map);
    }

    /**
     * 角色状态
     *
     * @return
     */
    @RequestMapping(value = "/modifyRoleStatus", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyRoleStatus(@RequestBody Map<String, Object> map) {
        return userRoleFeign.modifyRoleStatus(map);
    }

    /**
     * 查询全部的角色信息
     *
     * @return
     */
    @RequestMapping(value = "/queryAllRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryAllRoleInfo(@RequestBody Map<String, Object> map) {
        return userRoleFeign.queryAllRoleInfo(map);
    }

    /**
     * 查询角色的权限list
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryRolePermissionList", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity queryRolePermissionList(@RequestBody(required = false) Map<String, Object> map) {
        return userRoleFeign.queryRolePermissionList(map);
    }

    /**
     * 删除角色
     *
     * @return
     */
    @RequestMapping(value = "/deleteRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity deleteRoleInfo(@RequestBody Map<String, Object> map) {
        return userRoleFeign.deleteRoleInfo(map);
    }

    /**
     * 修改角色
     *
     * @return
     */
    @RequestMapping(value = "/modifyRoleInfo", method = RequestMethod.POST, headers = "Accept=application/json")
    public HttpResponseEntity modifyRoleInfo(@RequestBody Map<String, Object> map) {
        return userRoleFeign.modifyRoleInfo(map);
    }
}
