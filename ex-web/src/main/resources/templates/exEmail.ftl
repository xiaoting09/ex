<#include "/header.ftl" >
<#include "/page.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">异常邮件不发送列表</div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>异常机器</td>
                <td>排除的异常名</td>
                <td>操作</td>
            </tr>
        <#list exs as item >
            <tr>
                <td>${(item.id)!''}</td>
                <td>${(item.clinetName)!''}</td>
                <td>${(item.exName)!''}</td>
                <td>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default">删除</button>
                    </div>
                </td>
            </tr>
        </#list>
        </table>
        <button class="btn btn-default" data-toggle="modal" data-target="#myModal" type="button"> <span class="glyphicon glyphicon-pencil" aria-hidden="true">添加</span></button>
        <div class="pagination" id="p1"  style="float: right"></div>

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">添加异常不发送邮件</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <div class="input-group">
                                <label class="input-group-addon control-label ">异常机器:</label>
                                <select class="form-control " id="clinets">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                            <div class="input-group">
                                <label class="input-group-addon control-label ">异常类型:</label>
                                <select class="form-control " id="exList">
                                    <option value="">请选择</option>
                                </select>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" id="addForm" >保存</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/foot.ftl" >
<script src="/static/js/exEmail.js"></script>
<script src="/static/js/page.js"></script>