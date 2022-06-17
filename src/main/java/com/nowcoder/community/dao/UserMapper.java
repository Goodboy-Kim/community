package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 根据用户id查询用户
     * @param id  用户id
     * @return  用户
     */
    User selectById(int id);

    /**
     * 根据名字查询用户
     * @param username 用户名字
     * @return 用户
     */
    User selectByName(String username);

    /**
     * 根据email查询用户
     * @param email  用户的email
     * @return  用户
     */
    User selectByEmail(String email);

    /**
     * 插入用户
     * @param user  用户对象
     * @return  受影响的行数
     */
    int insertUser(User user);

    /**
     * 更改用户的状态
     * @param id  用户的id
     * @param status  用户的状态
     * @return  影响的行数
     */
    int updateStatus(int id, int status);

    /**
     * 更新用户的头像
     * @param id  用户的id
     * @param headerUrl  头像的url地址
     * @return  影响的行数
     */
    int updateHeader(int id, String headerUrl);

    /**
     * 更改用户的密码
     * @param id 用户的id
     * @param password 密码
     * @return 影响的行数
     */
    int updatePassword(int id, String password);

}
