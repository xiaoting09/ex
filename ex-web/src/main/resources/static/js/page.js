/**
 * Created by xiaoting on 2017/10/11.
 */
function pageAjax(myUrl) {
    $('#p1').pagination({
        total: $("#count").val(), row: $("#pageSize").val(), current: $("#page").val(),
        onJump: function (index) {
            var port = url('port');
            var tempUrl = url('protocol') + "://" + url("hostname");
            if (typeof port !== 'undefined') {
                myUrl = tempUrl + ":" + port + myUrl;
            } else {
                myUrl = tempUrl + myUrl;
            }
            window.location.href = myUrl + "?page=" + index;
        }
    })
}