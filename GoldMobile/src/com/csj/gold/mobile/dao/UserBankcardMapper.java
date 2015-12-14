package com.csj.gold.mobile.dao;

import java.util.List;

import com.csj.gold.mobile.model.UserBankcard;

public interface UserBankcardMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insert(UserBankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int insertSelective(UserBankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    UserBankcard selectByPrimaryKey(Long id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_type
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    List<UserBankcard> selectByParameters(UserBankcard userBankcard);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKeySelective(UserBankcard record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_bankcard
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateByPrimaryKey(UserBankcard record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_info
     *
     * @mbggenerated Fri Dec 11 18:10:49 CST 2015
     */
    int updateForbiddenByPrimaryKey(Long id);
}