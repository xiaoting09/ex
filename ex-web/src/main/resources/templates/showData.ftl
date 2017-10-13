<#include "/header.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">异常详情</div>
    <div class="panel-body">
        <table class="table table-bordered  table-striped table-hover"">
            <tr>
                <td class="col-xs-2">异常ID</td>
                <td class="col-xs-10">${(data.id)!''}</td>
            </tr>
            <tr>
                <td>客户端IP</td>
                <td>${(data.clientIp)!''}</td>
            </tr>
            <tr>
                <td>错误异常类</td>
                <td>${(data.exClass)!''}</td>
            </tr>
            <tr>
                <td>请求格式</td>
                <td>${(data.type)!''}</td>
            </tr>
            <tr>
                <td>数据格式</td>
                <td>${(data.contentType)!''}</td>
            </tr>
            <tr>
                <td>异常发生时间</td>
                <td>${(data.exTime)!''}</td>
            </tr>
        </table>
        <pre>请求参数 :${(data.parameters)!''}</pre>
        <pre>错误信息 :${(data.msg)!''}</pre>
        <div class="btn-group" role="group">
            <a class="btn btn-default" href="/data/toData?page=${page}<#if clientId??>&clientId=${clientId}<#else></#if>" role="button">返回</a>
        </div>
    </div>
</div>
<#include "/foot.ftl" >
