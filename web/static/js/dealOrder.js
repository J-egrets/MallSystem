$.getUrlParam = function (name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) return r[2];
    return null;
}

function start() {
    let clazz = $.getUrlParam("clazz");
    console.log(clazz);
    window.location.replace("../../pageChangeAdminServlet?clazz=" + clazz + "&curPage=1");
}

function changeStatus(orderId, newStatus){
    console.log(orderId)
    console.log(newStatus)
    $.ajax({
        type: "get",
        url: "AdminServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "dealOrder",
            "orderId" : orderId,
            "newStatus" : newStatus,
        },
        success: function (data){
            alert("修改订单状态成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/pageChangeAdminServlet?clazz=dealOrder&curPage=1");
        }
    })
}