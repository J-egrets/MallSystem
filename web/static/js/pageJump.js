function change1(location) {
    $("#iframe").attr("src", "views/common/" + location + ".jsp");
}

function change(location, par) {
    $("#iframe").attr("src", "views/common/" + location + ".jsp" + par);
}

function search(){
    $('#iframe').attr('src',"views/common/pageChangeGoods.jsp?clazz=search&key=" + encodeURI($('#search').val()));

}