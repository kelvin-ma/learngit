package com.csj.gold.mobile.dao;

import java.util.List;

import com.csj.gold.mobile.model.SysRole;

public interface SysRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insert(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insertSelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    SysRole selectByPrimaryKey(Long id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    List<SysRole> selectByParameters(SysRole sysRole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKey(SysRole record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateForbiddenByPrimaryKey(Long id);
}