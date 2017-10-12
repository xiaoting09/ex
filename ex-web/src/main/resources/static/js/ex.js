$(document).ready(function () {
    $(".btn-group button").click(function () {
        var html = $(this).parents("tr").children(':first').html();
        var index = $(this).index();
        var data = {};
        data.id = html;
        if (index === 0) {
            ajaxJson("exList/delEx", data, function (data) {
                window.location.href = window.location.href;
            });
        } else {
            $("#showModel").click();
            showData(this);
            return;
        }
    });

    $('#myModal').on('hidden.bs.modal', function (e) {
        $("#addId").val("");
        $("#name").val("");
        $("#remarks").val("");
        $("#state1").attr("checked", true);
        $("#nickName").val("");
    });
    $("#addForm").click(function () {
        var name = $("#name").val();
        if (name.trim().length === 0) {
            alert("请输入异常名称");
            return;
        }
        var addId = $("#addId").val();
        var remarks = $("#remarks").val();
        var state = $("input[type='radio']:checked").val();
        var nickName = $("#nickName").val();
        var data = {};
        if (addId !== null && addId.trim().length > 0) {
            data.id = addId;
        }
        data.name = name;
        data.remarks = remarks;
        data.type = state;
        data.nickName = nickName;
        ajaxJson("exList/addOrUpdate", data, function (data) {
            window.location.href = window.location.href;
        });
    });

});
function showData($this) {
    var childs = $($this).parents("tr").children('td');
    $("#addId").val(childs.eq(0).html());
    $("#name").val(childs.eq(1).html());
    $("#remarks").val(childs.eq(4).html());
    var state = childs.eq(3).html().trim();
    if (state === '系统默认异常') {
        $("#state0").attr("checked", true);
    } else {
        $("#state1").attr("checked", true);
    }
    $("#nickName").val(childs.eq(2).html());

}

