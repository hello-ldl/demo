package cn.com.demo.dao;

import cn.com.demo.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String custno);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String custno);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}