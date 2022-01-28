package cn.egret.dao;

import cn.egret.entity.User;

import java.util.List;

public interface IUserDao {
    boolean addUser(User user); // 添加一个用户

    User findUserByNP(String userName, String password); // 通过账户密码查询出某用户

    boolean updatePasswordByUserName(String userName, String newPassword); // 通过用户名更改密码

    List<User> findUserList(int role, int curPage, int pageSize); // 查询用户列表

    boolean updateUserStateByName(String userName, int newStatus); // 更新用户状态：是否冻结

    boolean deleteUserByName(String userName); // 通过用户名删除用户
}
