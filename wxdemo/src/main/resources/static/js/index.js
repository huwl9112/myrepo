$(function() {

    var websocket;


    // 首先判断是否 支持 WebSocket
    if(typeof(WebSocket) == "undefined") {
        console.log("您的浏览器不支持WebSocket");
    }else{
        console.log("您的浏览器支持WebSocket");

        //实现化WebSocket对象，指定要连接的服务器地址与端口  建立连接
        //socket = new WebSocket("ws://localhost:9094/starManager/websocket/张三")
        websocket = new WebSocket("ws://localhost:8080/websocket")}



    // 打开时
    websocket.onopen = function(evnt) {
        console.log("  websocket.onopen  ");
    };


    // 处理消息时
    websocket.onmessage = function(evnt) {
        $("#msg").append("<p>(<font color='red'>" + evnt.data + "</font>)</p>");
        console.log("  websocket.onmessage   ");
    };


    websocket.onerror = function(evnt) {
        console.log(evnt);
    };

    websocket.onclose = function(evnt) {
        console.log("  websocket.onclose  ");
    };


    // 点击了发送消息按钮的响应事件
    $("#TXBTN").click(function(){

        // 获取消息内容
        var text = $("#tx").val();

        // 判断
        if(text == null || text == ""){
            alert(" content  can not empty!!");
            return false;
        }

        var msg = {
            msgContent: text,
            postsId: 1
        };

        // 发送消息
        websocket.send(JSON.stringify(msg));

    });
});