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
        window.location.replace("../../PageChangeServlet?clazz=Goods&curPage=1");
    }

    if (clazz == "goodCategory") {
        let tableDataClazz = $.getUrlParam("tableDataClazz");
        console.log(tableDataClazz);
        window.location.replace("../../PageChangeServlet?clazz=" + clazz + "&curPage=1&tableDataClazz=" + tableDataClazz);
    }

    if(clazz == "search"){
        let key = decodeURI($.getUrlParam("key"));
        console.log(key)
        window.location.replace("../../PageChangeServlet?clazz=" + clazz + "&curPage=1&key=" +key);
    }
}

function changeNum(num, index){
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

function addCar(index){
    let id = "#countNum" + index;
    let gId = "#goodsId" + index;
    let goodsId = $(gId).html();
    let number = $(id).val();

    if(isNaN(parseInt(number))){
        $(id).val(0);
        number = $(id).val();
        alert("购买量不能为0")
        return;
    }

    console.log(goodsId)
    console.log(number)
    $.ajax({
        type: "get",
        url: "CarAndOrderServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "createCar",
            "goodsId" : goodsId,
            "number" : number,
        },
        success: function (data){
            alert("加入购物车成功");
        }
    })
}