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

function ice(index, newStatus){
    let name = $('#userName' + index).text();
    console.log(name)
    $.ajax({
        type: "get",
        url: "AdminServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "iceUser",
            "name" : name,
            "newStatus" : newStatus
        },
        success: function (data){
            alert("更改用户状态成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/pageChangeAdminServlet?clazz=dealUserList&curPage=1");
        }
    })
}

function deleteUser(index){
    let name = $('#userName' + index).text();
    $.ajax({
        type: "get",
        url: "AdminServlet",
        dataType: "json",
        contentType:'application/json',
        data: {
            "par" : "deleteUser",
            "name" : name,
        },
        success: function (data){
            alert("删除用户成功");
            window.location.replace("http://localhost:8080/MallSystem_war_exploded/pageChangeAdminServlet?clazz=dealUserList&curPage=1");
        }
    })
}