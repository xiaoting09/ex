/**
 * Created by xiaoting on 2017/9/30.
 */
function ajaxJson(myUrl, param, callback, method) {
    if (typeof (param) === 'function') {
        callback = param;
        param = null;
    }
    var port = url('port');
    var tempUrl = url('protocol') + "://" + url("hostname");
    if (typeof port !== 'undefined') {
        myUrl = tempUrl + ":" + port + "/" + myUrl;
    } else {
        myUrl = tempUrl + "/" + myUrl;
    }
    if (typeof(method) === 'undefined' || method === 'get') {
        $.ajax({
            url: myUrl,    //请求的url地址
            dataType: "json",   //返回格式为json
            data: param,
            type: "GET",   //请求方式
            success: function (req) {
                if (req.code !== 1) {
                    alert(req.msg);
                    return;
                }
                callback(req.data);
            }
        });
    } else {
        $.ajax({
            url: myUrl,    //请求的url地址
            dataType: "json",   //返回格式为json
            data: param,
            type: "POST",   //请求方式
            success: function (req) {
                if (req.code !== 1) {
                    alert(req.msg);
                    return;
                }
                callback(req.data);
            }
        });
    }
}
