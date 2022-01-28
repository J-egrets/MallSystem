$.getUrlParam = function (name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) return r[2];
    return null;
}

function start() {
    let clazz = $.getUrlParam("clazz");
    console.log(clazz);
    // console.log(tableDataClazz)
    if (clazz == "car") {
        window.location.replace("../../PageChangeServlet?clazz=car&curPage=1");
    }
}

function deleteCar(goodsId, carId){

    $.ajax({
        type: "get",
        url: "CarAndOrderServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "deleteCar",
            "goodsId" : goodsId,
            "carId" : carId,
        },
        success: function (data){
            alert("删除购物车订单成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/PageChangeServlet?clazz=car&curPage=1");
        }
    })
}

function deleteCar2(goodsId, carId){

    $.ajax({
        type: "get",
        url: "CarAndOrderServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "deleteCar",
            "goodsId" : goodsId,
            "carId" : carId,
        },
        success: function (data){
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/PageChangeServlet?clazz=car&curPage=1");
        }
    })
}

function createOrder(goodsId, carId){

    $.ajax({
        type: "get",
        url: "CarAndOrderServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "createOrder",
            "goodsId" : goodsId,
            "carId" : carId,
        },
        success: function (data){
            alert("添加我的订单成功");
            deleteCar2(goodsId,carId);
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/PageChangeServlet?clazz=car&curPage=1");
        }
    })
}