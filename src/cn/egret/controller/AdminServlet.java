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

        //??????Api
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        //???????????????muitipart/form-data??????
        if (!ServletFileUpload.isMultipartContent(request)) {
            response.getWriter().println("?????????enctype????????????multipart/form-data??????");
        }

        //?????????????????????????????? 10M
        fileUpload.setFileSizeMax(10 * 1024 * 1024);
        //???????????????????????????(????????????????????????????????????????????????????????????,?????????10M)
        fileUpload.setSizeMax(10 * 1024 * 1024);

        //????????????
        try {
            List<FileItem> parseRequest = fileUpload.parseRequest(request);
            //????????????
            for (FileItem fileItem : parseRequest) {
                //????????????????????????????????????form????????????
                if (!fileItem.isFormField()) {//?????????????????????????????????
                    //????????????
                    String fileName = fileItem.getName();
                    InputStream fileStream = fileItem.getInputStream();
                    //????????????????????????  eclipse?????????????????????C:\Users\87453\Desktop\??????\2021????????????\web2103sources\resources\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\????????????\
//                    String parentDir = this.getServletContext().getRealPath("/upload"); ???????????????????????????????????? ?????????
                    String parentDir = "C:\\Images";//????????????????????? ?????????????????????????????????????????????
                    //??????UUID+???????????????????????????????????????
                    String realFileName = UUID.randomUUID().toString() + "-" + fileName;
                    //????????????????????????
                    File file = new File(parentDir, realFileName);
                    //???????????????????????????
                    if (!file.getParentFile().exists()) {
                        //???????????????[???????????????]file.madir????????????????????????
                        file.getParentFile().mkdirs();
                    }

                    //???????????????
                    OutputStream out = new FileOutputStream(file);
                    //??????????????????
                    byte[] buffer = new byte[1024];
                    int len = -1;
                    //????????????1kb(1024byte),??????-1??????????????????
                    while ((len = fileStream.read(buffer)) != -1) {
                        //????????????1kb(1024byte)
                        out.write(buffer, 0, len);
                    }

                    //???????????????
                    out.flush();
                    //?????????
                    out.close();
                    fileStream.close();
                    img = realFileName;

                } else {
                    //????????????

                    //?????????
                    String fieldName = fileItem.getFieldName();
                    //?????????
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
                                case "??????":
                                    categoryId = 1;
                                    break;
                                case "??????":
                                    categoryId = 2;
                                    break;
                                case "??????":
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
