function change1(location) {
    $("#iframe").attr("src", "views/admin/" + location + ".jsp");
}

function change(location, par) {
    $("#iframe").attr("src", "views/admin/" + location + ".jsp" + par);
}

function search(){
    $('#iframe').attr('src',"views/admin/pageChangeGoods.jsp?clazz=search&key=" + encodeURI($('#search').val()));
}