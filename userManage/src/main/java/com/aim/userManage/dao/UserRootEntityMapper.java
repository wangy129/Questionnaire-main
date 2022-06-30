package com.aim.userManage.dao;

import com.aim.questionnaire.dao.entity.UserRootEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRootEntityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    int insert(UserRootEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    int insertSelective(UserRootEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    UserRootEntity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserRootEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_root_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserRootEntity record);

    /**
     * 角色查询
     * @return
     */
    List<Map<String,Object>> queryRoleInfo();

    /**
     * 添加角色
     * @param map
     * @return
     */
    int addRoleInfo(Map<String, Object> map);


    /**
     * 角色状态
     * @param map
     * @return
     */
    int modifyRoleStatus(Map<String, Object> map);

    /**
     * 查询全部角色信息
     * @param map
     * @return
     */
    List<Map<String,Object>> queryAllRoleInfo(Map<String, Object> map);

    /**
     * 获取用户角色
     * @param roleId
     * @return
     */
    List<UserRootEntity> findRoleById(String roleId);

    /**
     * 获取用户角色
     * @param s
     * @return
     */
    String findRoleInfoById(String s);

    /**
     * 根据角色查询等级
     * @param roleId
     */
    Map<String,Object> queryRoleNumInfo(String roleId);

    /**
     * 查询在此角色等级下的角色
     * @param num
     * @return
     */
    List<String> queryAllRoleInfoByNum(String num);

    /**
     * 查找所有的角色的等级
     * @return
     */
    List<String> queryRoleNumAll();


    /**
     * 查询角色的权限list
     * @param map
     * @return
     */
    String queryRolePermissionList(Map<String, Object> map);


    /**
     * 为角色添加权限list
     * @param map
     * @return
     */
    int modifyRolePermissionList(Map<String, Object> map);

    /**
     * 删除角色
     * @param map
     * @return
     */
    int deleteRoleInfo(Map<String, Object> map);

    /**
     * 修改角色信息
     * @param map
     * @return
     */
    int modifyRoleInfo(Map<String, Object> map);

    /**
     * 删除权限
     * @param map
     * @return
     */
    int deletePermission(Map<String, Object> map);

    /**
     * 根据角色的名字查找角色名是否存在
     * @param map
     * @return
     */
    int queryRoleNameIsExit(Map<String, Object> map);

    /**
     * 更新admin的list数值
     * @param strList
     * @return
     */
    int modifyRoleParamList(@Param("createdBy") String strList);

    /**
     * 查询所有包含permission的角色
     * @param map
     * @return
     */
    List<Map<String, Object>> queryAllRolePermissionList(Map<String, Object> map);

    /**
     * 批量修改createdBy数据
     * @param map
     * @return
     */
    int modifyRolePermissionListById(Map<String, Object> map);

    /**
     * 修改modelId在原基础上
     * @param mapModel
     * @return
     */
    int modifyRoleInfoByModel(Map<String, Object> mapModel);

    /**
     * 修改modelId
     * @param mapRole
     * @return
     */
    int modifyModelIdById(Map<String, Object> mapRole);
}