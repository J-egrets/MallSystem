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
    if (clazz == "Goods") {
        window.location.replace("../../pageChangeAdminServlet?clazz=Goods&curPage=1");
    }

    if (clazz == "goodCategory") {
        let tableDataClazz = $.getUrlParam("tableDataClazz");
        console.log(tableDataClazz);
        window.location.replace("../../pageChangeAdminServlet?clazz=" + clazz + "&curPage=1&tableDataClazz=" + tableDataClazz);
    }

    if(clazz == "search"){
        let key = decodeURI($.getUrlParam("key"));
        console.log(key)
        window.location.replace("../../pageChangeAdminServlet?clazz=" + clazz + "&curPage=1&key=" +key);
    }
}

function changeNumber(num, index){
    let id = '#countNum' + index;
    let nowNum = $(id).val();
    if(isNaN(parseInt(nowNum))){
        $(id).val(0);
        nowNum = $(id).val();
    }

    if(parseInt(nowNum) + parseInt(num) < 0){
        $(id).val(0);
    }else{
        $(id).val(parseInt(nowNum) + parseInt(num));
    }

}

function changeNum(goodsId, index){
    let number = $("#countNum" + index).val();
    if(isNaN(parseInt(number)) || parseInt(number) < 0){
        $("#countNum" + index).val(0);
        number = $("#countNum" + index).val();
    }


    console.log(number)
    $.ajax({
        type: "get",
        url: "AdminServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "changeNum",
            "goodsId" : goodsId,
            "number" : number,
        },
        success: function (data){
            alert("修改货品数量成功");
            $("#goodsCount" + index).text(data);
        }
    })
}

function deleteGoods(goodsId){
    console.log(goodsId)
    $.ajax({
        type: "get",
        url: "AdminServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "deleteGoods",
            "goodsId" : goodsId,
        },
        success: function (data){
            alert("删除货品成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/pageChangeAdminServlet?clazz=Goods&curPage=1");
        }
    })
}