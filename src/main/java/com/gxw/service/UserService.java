package com.gxw.service;

import com.gxw.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 用户业务层接口
 * @author GXW工作室
 * @date 2020/6/14 0014 - 11:13
 */
public interface UserService {
    //根据id查询用户对象
    User findUserById(Integer id);

    //查询所有用户信息
    List<User> selectUser();

    //分页查询用户信息
    List<User> findUserPage(Map<String,Object> map);

    //根据名称模糊查询
    List<User> findUserByName(String name);

    //查询总数
    int findTotal();

    //添加数据
    int insertUser(User user);

    //更新用户
    int updateUser(User user);

    //根据id删除用户
    int deleteUserById(Integer id);

    //实现一对多关联查询，查询用户信息，同时查询出用户的账号信息
//    List<User> findUserAndAccount();

}
