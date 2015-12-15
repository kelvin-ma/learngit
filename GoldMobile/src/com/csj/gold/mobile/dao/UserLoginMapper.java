package com.csj.gold.mobile.dao;

import java.util.List;

import com.csj.gold.mobile.model.UserLogin;

public interface UserLoginMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insert(UserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insertSelective(UserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    UserLogin selectByPrimaryKey(Long id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    List<UserLogin> selectByParameters(UserLogin userLogin);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKeySelective(UserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_login
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKey(UserLogin record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateForbiddenByPrimaryKey(Long id);
}