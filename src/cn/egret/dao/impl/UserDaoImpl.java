package cn.egret.dao.impl;

import cn.egret.dao.IUserDao;
import cn.egret.entity.User;
import cn.egret.util.JdbcUtil;
import jdk.nashorn.internal.scripts.JD;

import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public boolean addUser(User user) {
        String sql = "insert into t_user (userName,password,gender,phone,address,status,role) values(?,?,?,?,?,?,?)";
        int flag = JdbcUtil.update(sql, user.getUserName(), user.getPassword(), user.getGender(), user.getPhone(), user.getAddress(), user.getStatus(), user.getRole());
        if (flag > 0) {
            System.out.println("添加成功");
            return true;
        } else {
            System.out.println("添加失败");
            return false;
        }

    }

    @Override
    public User findUserByNP(String userName, String password) {
        String sql = "select * from t_user where userName = ? and password = ?";
        User user = null;
        List<User> userList = JdbcUtil.queryAll(sql, User.class, userName, password);

        for (User u : userList) {
            user = u;
        }

        return user;
    }

    @Override
    public boolean updatePasswordByUserName(String userName, String newPassword) {
        String sql = "update t_user set password = ? where userName = ?";
        int flag = JdbcUtil.update(sql, newPassword, userName);

        if (flag > 0) {
            System.out.println("修改密码成功");
            return true;
        } else {
            System.out.println("修改密码失败");
            return false;
        }
    }

    @Override
    public List<User> findUserList(int role,int curPage, int pageSize) {
        String sql = "select * from t_user where role = ? limit ?,?";
        curPage = (curPage - 1) * pageSize;
        List<User> userList = JdbcUtil.queryAll(sql, User.class, role, curPage, pageSize);
        return userList;
    }

    @Override
    public boolean updateUserStateByName(String userName, int newStatus) {
        String sql = "update t_user set status = ? where userName = ?";
        int flag = JdbcUtil.update(sql,newStatus,userName);
        if(flag > 0){
            System.out.println("修改用户状态成功");
            return true;
        }else{
            System.out.println("修改用户状态失败");
            return false;
        }
    }

    @Override
    public boolean deleteUserByName(String userName) {
        String sql = "delete from t_user where userName = ?";
        int flag = JdbcUtil.update(sql,userName);
        if(flag > 0){
            System.out.println("删除用户成功");
            return true;
        }else{
            System.out.println("删除用户失败");
            return false;
        }
    }
}
