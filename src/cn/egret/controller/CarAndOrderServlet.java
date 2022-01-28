package cn.egret.controller;

import cn.egret.entity.Car;
import cn.egret.entity.Goods;
import cn.egret.entity.Order;
import cn.egret.entity.User;
import cn.egret.service.CarService;
import cn.egret.service.GoodsService;
import cn.egret.service.OrderService;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CarAndOrderServlet", value = "/CarAndOrderServlet")
public class CarAndOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String par = request.getParameter("par");

        if (par != null) {
            switch (par) {
                case "createCar":
                    createCar(request, response);
                    break;
                case "deleteCar":
                    deleteCar(request, response);
                    break;
                case "createOrder":
                    createOrder(request, response);
                    break;
                case "deleteOrder":
                    deleteOrder(request, response);
                    break;
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void createCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        Goods goods = GoodsService.findGoods(goodsId);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String number = request.getParameter("number");
        Car car = new Car(user.getUserName(), goodsId, goods.getName(), goods.getImg(), goods.getPrice(), Integer.parseInt(number));
        CarService.addCar(car);
        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        String carId = request.getParameter("carId");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        CarService.deleteCar(user.getUserName(), goodsId, Integer.parseInt(carId));

        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        String carId = request.getParameter("carId");

        Car car = CarService.findCar(Integer.parseInt(carId));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Date date = new Date();//获得系统时间.
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
        Timestamp goodsC_date =Timestamp.valueOf(nowTime);//把时间转换

        Order order = new Order(carId, user.getUserName(), goodsId, car.getNumber(), 0, goodsC_date, "顺丰", "支付宝",car.getTotalPrice());
        OrderService.addOrder(order);

        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("orderId");
        OrderService.deleteOrder(orderId);

        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);

    }
}
