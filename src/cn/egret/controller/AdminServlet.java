package cn.egret.controller;

import cn.egret.entity.Goods;
import cn.egret.entity.Order;
import cn.egret.service.GoodsService;
import cn.egret.service.OrderService;
import cn.egret.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String par = request.getParameter("par");

        if (par != null) {
            switch (par) {
                case "changeNum":
                    changeNum(request, response);
                    break;
                case "deleteGoods":
                    deleteGoods(request, response);
                    break;
                case "deleteUser":
                    deleteUser(request, response);
                    break;
                case "iceUser":
                    iceUser(request, response);
                    break;
                case "addGoods":
                    addGoods(request, response);
                    break;
                case "dealOrder":
                    dealOrder(request, response);
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void changeNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        String number = request.getParameter("number");

        GoodsService.changeGoodsCount(goodsId, Integer.parseInt(number));

        Object json = JSONObject.toJSON(number);
        response.getWriter().print(json);
    }

    private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String goodsId = request.getParameter("goodsId");
        GoodsService.deleteGoods(goodsId);
        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("name");
        UserService.deleteUser(userName);
        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void iceUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("name");
        String newStatus = request.getParameter("newStatus");

        UserService.changeUserState(userName, Integer.parseInt(newStatus));
        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }

    private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String goodsId = null;
        String name = null;
        String description = null;
        int price = -1;
        int categoryId = -1;
        int count = -1;
        String img = null;

        //核心Api
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        //判断是否是muitipart/form-data类型
        if (!ServletFileUpload.isMultipartContent(request)) {
            response.getWriter().println("表单的enctype属性不是multipart/form-data类型");
        }

        //设置单个文件上传大小 10M
        fileUpload.setFileSizeMax(10 * 1024 * 1024);
        //设置总上传文件大小(有时候一次性上传多个文件，需要有一个上限,此处为10M)
        fileUpload.setSizeMax(10 * 1024 * 1024);

        //解析请求
        try {
            List<FileItem> parseRequest = fileUpload.parseRequest(request);
            //获取数据
            for (FileItem fileItem : parseRequest) {
                //判断数据类型是不是普通的form表单字段
                if (!fileItem.isFormField()) {//不是普通的，说明是文件
                    //上传文件
                    String fileName = fileItem.getName();
                    InputStream fileStream = fileItem.getInputStream();
                    //定义保存的父路径  eclipse这边的默认路径C:\Users\87453\Desktop\绩效\2021第二季度\web2103sources\resources\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\图片上传\
//                    String parentDir = this.getServletContext().getRealPath("/upload"); 图片上传路径跟项目放一起 不建议
                    String parentDir = "C:\\Images";//自定义文件路径 ，到时会是远程文件服务器的路径
                    //使用UUID+文件名的方式，避免文件重名
                    String realFileName = UUID.randomUUID().toString() + "-" + fileName;
                    //创建要保存的文件
                    File file = new File(parentDir, realFileName);
                    //判断文件夹是否存在
                    if (!file.getParentFile().exists()) {
                        //创建文件夹[多级文件夹]file.madir是创建单一文件夹
                        file.getParentFile().mkdirs();
                    }

                    //创建输出流
                    OutputStream out = new FileOutputStream(file);
                    //创建字节缓存
                    byte[] buffer = new byte[1024];
                    int len = -1;
                    //一次读取1kb(1024byte),返回-1表明读取完毕
                    while ((len = fileStream.read(buffer)) != -1) {
                        //一次写入1kb(1024byte)
                        out.write(buffer, 0, len);
                    }

                    //冲刷流资源
                    out.flush();
                    //关闭流
                    out.close();
                    fileStream.close();
                    img = realFileName;

                } else {
                    //普通字段

                    //字段名
                    String fieldName = fileItem.getFieldName();
                    //字段值
                    String fieldValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");

                    switch (fieldName) {
                        case "goodsId":
                            goodsId = fieldValue;
                            break;
                        case "goodsName":
                            name = fieldValue;
                            break;
                        case "category":
                            switch (fieldValue) {
                                case "电器":
                                    categoryId = 1;
                                    break;
                                case "家具":
                                    categoryId = 2;
                                    break;
                                case "书籍":
                                    categoryId = 3;
                                    break;
                            }
                            break;
                        case "description":
                            description = fieldValue;
                            break;
                        case "price":
                            price = Integer.parseInt(fieldValue);
                            break;
                        case "count":
                            count = Integer.parseInt(fieldValue);
                            break;
                    }

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        Goods goods = new Goods(goodsId,name,description,new BigDecimal(price),img,count,categoryId);
        GoodsService.addGoods(goods);
        request.getRequestDispatcher("/views/admin/addGoods.jsp").forward(request, response);

    }

    private void dealOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String orderId = request.getParameter("orderId");
        String newStatus = request.getParameter("newStatus");

        OrderService.changeStatus(Integer.parseInt(newStatus),orderId);

        Object json = JSONObject.toJSON(11);
        response.getWriter().print(json);
    }
}
