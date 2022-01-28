package cn.egret.controller;

import cn.egret.entity.User;
import cn.egret.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");

        if (op != null) {
            switch (op) {
                case "login": {
                    login(request, response);
                    break;
                }
                case "register": {
                    register(request, response);
                    break;
                }
                case "changePassword": {
                    changePassword(request, response);
                    break;
                }
            }
        } else {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = UserService.login(userName, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user); // 登录

            if (user.getRole() == 1 && user.getStatus() == 0) {
                request.getRequestDispatcher("views/mainPage.jsp").forward(request, response);
            } else if (user.getRole() == 0) {
                request.getRequestDispatcher("views/adminPage.jsp").forward(request, response);
            }
        }
        response.sendRedirect("views/login.jsp");

    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        if (password1.equals(password2)) {
            User user = new User(userName, password1, gender, phone, address, 0, 1);
            boolean flag = UserService.register(user);
            if (flag) {
                response.sendRedirect("views/login.jsp");
                return;
            }
        }
        response.sendRedirect("views/register.jsp");
    }

    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String passwordOld = request.getParameter("passwordOld");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");

        if (passwordOld.equals(user.getPassword()) && password1.equals(password2)) {
            boolean flag = UserService.changePassword(user.getUserName(), password1);
            if (flag) {
                response.sendRedirect("views/welcome.jsp");
                return;
            }
        }
    }
}
