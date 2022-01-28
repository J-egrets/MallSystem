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
    if (clazz == "orderUser") {
        window.location.replace("../../PageChangeServlet?clazz=orderUser&curPage=1");
    }
}

function deleteOrder(orderId){
    console.log(orderId)
    $.ajax({
        type: "get",
        url: "CarAndOrderServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "deleteOrder",
            "orderId" : orderId,
        },
        success: function (data){
            alert("删除订单成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/PageChangeServlet?clazz=orderUser&curPage=1");
        }
    })
}