package cn.egret.controller;

import cn.egret.entity.*;
import cn.egret.service.CarService;
import cn.egret.service.GoodsService;
import cn.egret.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageChangeServlet", value = "/PageChangeServlet")
public class PageChangeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String clazz = request.getParameter("clazz");
        if (clazz != null) {
            switch (clazz) {
                case "Goods": {
                    dealGoods(request, response);
                    break;
                }
                case "goodCategory": {
                    dealGoodCategory(request, response);
                    break;
                }
                case "search": {
                    search(request, response);
                    break;
                }
                case "car":{
                    dealCar(request, response);
                    break;
                }
                case "orderUser":{
                    dealOrderUser(request, response);
                    break;
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void dealGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String curPage = request.getParameter("curPage");
        int pageSize = 2;
        List<Goods> goodsList = GoodsService.findGoodsList(Integer.parseInt(curPage), pageSize);
        Page<Goods> page = new Page<Goods>(Integer.parseInt(curPage), pageSize, GoodsService.findDataCount("select * from t_goods"), goodsList);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("pageCount", page.getPageCount());
        System.out.println(goodsList);
        System.out.println(page);

        int nextPage = Integer.parseInt(curPage) + 1;
        int previousPage = Integer.parseInt(curPage) - 1;

        if (nextPage > page.getPageCount()) {
            nextPage--;
        }

        if (previousPage < 1) {
            previousPage = 1;
        }

        request.setAttribute("previousPage", previousPage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("clazz", request.getParameter("clazz"));

        request.getRequestDispatcher("/views/common/pageChangeGoods.jsp").forward(request, response);
    }

    private void dealGoodCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        String tableDataClazz = request.getParameter("tableDataClazz");
        System.out.println(tableDataClazz);
        System.out.println(curPage);
        int pageSize = 2;
        List<Goods> goodsList = GoodsService.findGoodsList(tableDataClazz, Integer.parseInt(curPage), pageSize);
        System.out.println(goodsList);
        Page<Goods> page = new Page<Goods>(Integer.parseInt(curPage), pageSize, GoodsService.findDataCount("select * from t_goods where categoryId = ?", tableDataClazz), goodsList);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("pageCount", page.getPageCount());

        int nextPage = Integer.parseInt(curPage) + 1;
        int previousPage = Integer.parseInt(curPage) - 1;

        if (nextPage > page.getPageCount()) {
            nextPage--;
        }

        if (previousPage < 1) {
            previousPage = 1;
        }

        request.setAttribute("previousPage", previousPage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("tableDataClazz", tableDataClazz);
        request.setAttribute("clazz", request.getParameter("clazz"));

        request.getRequestDispatcher("/views/common/pageChangeGoods.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        String key = request.getParameter("key");
        System.out.println(key);
        System.out.println(curPage);
        int pageSize = 1;
        List<Goods> goodsList = GoodsService.findGoodsLike(key, Integer.parseInt(curPage), pageSize);
        System.out.println(goodsList);
        Page<Goods> page = new Page<Goods>(Integer.parseInt(curPage), pageSize, GoodsService.findDataCount("select * from t_goods where name like \"%\"?\"%\"", key), goodsList);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("pageCount", page.getPageCount());

        int nextPage = Integer.parseInt(curPage) + 1;
        int previousPage = Integer.parseInt(curPage) - 1;

        if (nextPage > page.getPageCount()) {
            nextPage--;
        }

        if (previousPage < 1) {
            previousPage = 1;
        }

        request.setAttribute("previousPage", previousPage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("key", key);
        request.setAttribute("clazz", request.getParameter("clazz"));

        request.getRequestDispatcher("/views/common/pageChangeGoods.jsp").forward(request, response);

    }

    private void dealCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        System.out.println(curPage);

        User user = (User) request.getSession().getAttribute("user");

        int pageSize = 1;
        List<Car> carList = CarService.findCarList(user.getUserName(),Integer.parseInt(curPage),pageSize);
        System.out.println(carList);
        Page<Car> page = new Page<Car>(Integer.parseInt(curPage), pageSize, GoodsService.findDataCount("select * from t_car where userName = ?", user.getUserName()), carList);
        request.setAttribute("carList", carList);
        request.setAttribute("pageCount", page.getPageCount());
        System.out.println(page.getPageCount());

        int nextPage = Integer.parseInt(curPage) + 1;
        int previousPage = Integer.parseInt(curPage) - 1;

        if (nextPage > page.getPageCount()) {
            nextPage--;
        }

        if (previousPage < 1) {
            previousPage = 1;
        }

        request.setAttribute("previousPage", previousPage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("clazz", request.getParameter("clazz"));

        request.getRequestDispatcher("/views/common/pageChangeCar.jsp").forward(request, response);
    }

    private void dealOrderUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curPage = request.getParameter("curPage");
        System.out.println(curPage);

        User user = (User) request.getSession().getAttribute("user");

        int pageSize = 1;
        List<Order> orderList = OrderService.findOrderList(user.getUserName(),Integer.parseInt(curPage),pageSize);
        System.out.println(orderList);
        Page<Order> page = new Page<Order>(Integer.parseInt(curPage), pageSize, GoodsService.findDataCount("select * from t_order where userName = ?", user.getUserName()), orderList);
        request.setAttribute("orderList", orderList);
        request.setAttribute("pageCount", page.getPageCount());
        System.out.println(page.getPageCount());

        int nextPage = Integer.parseInt(curPage) + 1;
        int previousPage = Integer.parseInt(curPage) - 1;

        if (nextPage > page.getPageCount()) {
            nextPage--;
        }

        if (previousPage < 1) {
            previousPage = 1;
        }

        request.setAttribute("previousPage", previousPage);
        request.setAttribute("nextPage", nextPage);
        request.setAttribute("clazz", request.getParameter("clazz"));

        request.getRequestDispatcher("/views/common/pageChangeOrder.jsp").forward(request, response);
    }
}
