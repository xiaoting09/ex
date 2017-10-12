<#include "/header.ftl" >
<#include "/page.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">异常管理</div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>异常ID</td>
                <td>异常名称</td>
                <td>别名</td>
                <td>类型</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
        <#list exs as item >
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${(item.nickName)!''}</td>
                <td>
                    <#if item.type>
                        自定义异常
                    <#else>
                        系统默认异常
                    </#if>
                </td>
                <td>${(item.remarks)!''}</td>
                <td>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default">删除</button>
                        <button type="button" class="btn btn-default">修改</button>
                    </div>
                </td>
            </tr>
        </#list>
        </table>
        <button class="btn btn-default" data-toggle="modal" data-target="#myModal" id="showModel" type="button"> <span class="glyphicon glyphicon-pencil" aria-hidden="true">新增异常</span></button>
        <div class="pagination" id="p1"  style="float: right"></div>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">新增异常</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <input type="hidden" class="form-control" id="addId"  >
                            <div class="form-group">
                                <label for="name">异常名称</label>
                                <input type="text" class="form-control" id="name"  placeholder="异常名称必须是带上包名的全称">
                            </div>
                            <div class="form-group">
                                <label for="name">别名</label>
                                <input type="text" class="form-control" id="nickName" placeholder="别名,可以是中文名">
                            </div>
                            <div class="form-group">
                                <label for="name">请选择类型	:</label>
                                <label>
                                    <input type="radio" value="1" name="state" id="state1" checked> 自定义异常
                                </label>
                                <label>
                                    <input type="radio" value="0" name="state" id="state0" > 系统默认异常
                                </label>
                            </div>
                            <div class="form-group">
                                <label for="name">备注</label>
                                <textarea  class="form-control" rows="3" id="remarks" placeholder="备注"></textarea>
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
<script src="/static/js/ex.js"></script>
<script src="/static/js/page.js"></script>