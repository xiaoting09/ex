$(document).ready(function () {
    var myUrl = "/data/toData";
    pageAjax(myUrl);
    getClientList();
    var port = url('port');
    var tempUrl = url('protocol') + "://" + url("hostname");
    if (typeof port !== 'undefined') {
        myUrl = tempUrl + ":" + port + myUrl;
    } else {
        myUrl = tempUrl + myUrl;
    }
    $("select").change(function () {
        window.location.href = myUrl + "?clientId=" + $("#clinets").val();
    });
});
/**
 * 查询机器列表
 */
function getClientList() {
    ajaxJson("client/getClinetList", function (req) {
        req.forEach(function (element) {
            var text = element.ip;
            if (typeof element.remarks !== 'undefined' && element.length > 0) {
                text = element.remarks;
            }
            var clientId = url('?clientId');
            if (typeof (clientId) !== 'undefined') {
                $("#clinets").append("<option value='" + element.id + "' selected = 'selected'>" + text + "</option>");
            } else {
                $("#clinets").append("<option value='" + element.id + "'>" + text + "</option>");
            }
        });
    });
}