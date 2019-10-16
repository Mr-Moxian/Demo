function layuiMsgInfo(msg){
    layui.use("layer",function(){
        layer.msg(msg, {
            offset: 'auto'
            ,icon: 1
        });
    });
}
function layuiMsgError(msg){
    layui.use("layer",function(){
        layer.msg(msg, {
            offset: 'auto'
            ,icon: 2
        });
    });
}