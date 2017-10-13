<#include "/header.ftl" >
<#include "/page.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">查询条件</div>
    <div class="panel-body">
        <div class="col-xs-4">
            <div class="input-group">
                <label class="input-group-addon control-label ">异常机器:</label>
                <select class="form-control " id="clinets">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="panel panel-default">
    <div class="panel-heading">客户端数据</div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>ID</td>
                <td>客户端ip</td>
                <td>错误异常类</td>
                <td>请求格式</td>
                <td>数据格式</td>
                <td>异常发生时间</td>
                <td>操作</td>
            </tr>
        <#list datas as item >
            <tr>
                <td>${item.id}</td>
                <td>${item.clientIp}</td>
                <td>${item.exClass}</td>
                <td>${(item.type)!''}</td>
                <td>${(item.contentType)!''}</td>
                <td>${(item.exTime)!''}</td>
                <td>
                    <div class="btn-group" role="group">
                        <a class="btn btn-default" href="/data/showData?id=${item.id}&page=${pageValue.page}<#if clientId??>&clientId=${clientId}<#else></#if>" role="button">查看</a>
                    </div>
                </td>
            </tr>
        </#list>
        </table>
        <div class="pagination" id="p1"  style="float: right"></div>
    </div>
</div>
<#include "/foot.ftl" >
<script src="/static/js/data.js"></script>
<script src="/static/js/page.js"></script>