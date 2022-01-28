package cn.egret.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IsLoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;//ServletRequest转成HttpServletRequest
        HttpSession session = httpRequest.getSession();
        Object attribute = session.getAttribute("user");
        if (attribute == null) {//未登录
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
        chain.doFilter(request, response);
    }
}
