$(document).ready(function () {
    getExList();
    getClientList();
    $("#addForm").click(function () {
        var clinets = $("#clinets").val();
        var exList = $("#exList").val();
        var data = {};
        data.clinetId = clinets;
        data.exName = exList;
        ajaxJson("exList/addClientList", data, function (data) {
            window.location.href = window.location.href;
        });
    });
    $(".btn-group button").click(function () {
        var html = $(this).parents("tr").children(':first').html();
        var data = {};
        data.id = html;
        ajaxJson("exList/updateList", data, function (data) {
            window.location.href = window.location.href;
        });
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
            $("#clinets").append("<option value='" + element.id + "'>" + text + "</option>");
        });
    });
}
/**
 * 查询异常列表
 */
function getExList() {
    ajaxJson("exList/getExList", function (data) {
        data.forEach(function (element) {
            $("#exList").append("<option value='" + element + "'>" + element + "</option>");
        });
    });
}