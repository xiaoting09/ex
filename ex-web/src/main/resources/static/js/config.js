/**
 * Created by xiaoting on 2017/10/11.
 */
$(document).ready(function () {
    $(".btn-group button").click(function () {
        var html = $(this).parents("tr").children(':first').html();
        var data = {};
        data.id = html;

        ajaxJson("config/delConf", data, function (data) {
            window.location.href = window.location.href;
        });
    });
    $("#addForm").click(function () {
        var key = $("#key").val();
        if (key.trim().length === 0) {
            alert("请输入字典名");
            return;
        }
        var value = $("#value").val();
        var desc = $("#desc").val();
        var data = {};
        data.name = key;
        data.value = value;
        data.desc = desc;
        ajaxJson("config/addConf", data, function (data) {
            window.location.href = window.location.href;
        });
    });
    var myUrl = "/config/toConfig";
    pageAjax(myUrl);
});
