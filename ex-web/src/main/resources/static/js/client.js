/**客户端JS调用
 * Created by xiaoting on 2017/10/10.
 */
$(document).ready(function () {
    $(".btn-group button").click(function () {
        var html = $(this).parents("tr").children(':first').html();
        var index = $(this).index();
        var data = {};
        data.id = html;
        if (index === 0) {
            var text = $(this).html();
            if (text.trim() === '禁用') {
                data.state = false;
            } else {
                data.state = true;
            }
        } else if (index === 1) {
            data.isEnabled = false;
        } else {
            $("#showModel").click();
            showData(this);
            return;
        }
        ajaxJson("client/updataClient", data, function (data) {
            window.location.href = window.location.href;
        });
    });
    $("#addForm").click(function () {
        var ip = $("#ip").val();
        if (ip.trim().length === 0) {
            alert("请输入客户端IP");
            return;
        }
        var addId = $("#addId").val();
        var remarks = $("#remarks").val();
        var state = $("input[type='radio']:checked").val();
        var phone = $("#phone").val();
        var email = $("#email").val();
        var data = {};
        if (addId !== null && addId.trim().length > 0) {
            data.id = addId;
        }
        data.ip = ip;
        data.remarks = remarks;
        data.state = state;
        data.email = email;
        data.phone = phone;
        ajaxJson("client/addClient", data, function (data) {
            window.location.href = window.location.href;
        });
    });

    $('#myModal').on('hidden.bs.modal', function (e) {
        $("#addId").val("");
        $("#ip").val("");
        $("#remarks").val("");
        $("#state1").attr("checked", true);
        $("#phone").val("");
        $("#email").val("");
    });
    var myUrl = "/client/toClient";
    pageAjax(myUrl);

});
function showData($this) {
    var childs = $($this).parents("tr").children('td');
    $("#addId").val(childs.eq(0).html());
    $("#ip").val(childs.eq(1).html());
    $("#remarks").val(childs.eq(2).html());
    var state = childs.eq(4).html().trim();
    if (state === '启用') {
        $("#state1").attr("checked", true);
    } else {
        $("#state0").attr("checked", true);
    }
    $("#phone").val(childs.eq(6).html());
    $("#email").val(childs.eq(5).html());

}

