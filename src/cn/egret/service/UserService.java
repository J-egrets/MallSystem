package cn.egret.service;

import cn.egret.dao.IUserDao;
import cn.egret.dao.impl.UserDaoImpl;
import cn.egret.entity.User;

import java.util.List;

public class UserService {
    private static IUserDao IUD = new UserDaoImpl(); // 用户Dao

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    public static User login(String userName, String password) {
        return IUD.findUserByNP(userName, password);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public static boolean register(User user) {
        return IUD.addUser(user);
    }

    /**
     * 修改密码
     *
     * @param userName
     * @param newPassword
     * @return
     */
    public static boolean changePassword(String userName, String newPassword) {
        return IUD.updatePasswordByUserName(userName, newPassword);
    }

    /**
     * 查询固定角色的用户列表
     *
     * @param role
     * @return
     */
    public static List<User> findUserList(int role, int curPage, int pageSize) {
        return IUD.findUserList(role, curPage, pageSize);
    }

    /**
     * 修改用户状态
     *
     * @param userName
     * @param newStatus
     * @return
     */
    public static boolean changeUserState(String userName, int newStatus) {
        return IUD.updateUserStateByName(userName, newStatus);
    }

    /**
     * 删除用户
     *
     * @param userName
     * @return
     */
    public static boolean deleteUser(String userName) {
        return IUD.deleteUserByName(userName);
    }
}
