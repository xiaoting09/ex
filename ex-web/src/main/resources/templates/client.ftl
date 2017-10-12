<#include "/header.ftl" >
<#include "/page.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">客户端数据</div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>客户端id</td>
                <td>客户端IP</td>
                <td>备注</td>
                <td>注册来源</td>
                <td>状态</td>
                <td>通知邮箱</td>
                <td>通知手机号</td>
                <td>修改时间</td>
                <td>操作</td>
            </tr>
            <#list clients as item >
                <tr>
                    <td>${item.id}</td>
                    <td>${item.ip}</td>
                    <td>${item.remarks}</td>
                    <td>
                        <#if item.type>
                            客户端自己注册
                        <#else>
                            管理平台注册
                        </#if>
                    </td>
                    <td>
                        <#if item.state >
                            启用
                        <#else>
                            禁用
                        </#if>
                    </td>
                    <td>${(item.email)!''}</td>
                    <td>${(item.phone)!''}</td>
                    <td>${item.utime}</td>
                    <td>
                        <div class="btn-group" role="group">
                           <#-- <button type="button" class="btn btn-default">修改</button>-->
                            <button type="button" class="btn btn-default">
                            <#if item.state >
                                禁用
                            <#else>
                                启用
                            </#if>
                            </button>
                            <button type="button" class="btn btn-default">删除</button>
                            <button type="button" class="btn btn-default">修改</button>
                        </div>
                    </td>
                </tr>
            </#list>
        </table>
        <button class="btn btn-default" data-toggle="modal" data-target="#myModal" id="showModel" type="button"> <span class="glyphicon glyphicon-pencil" aria-hidden="true">新增客户端</span></button>
        <div class="pagination" id="p1"  style="float: right"></div>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">新增客户端</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <input type="hidden" class="form-control" id="addId"  >
                            <div class="form-group">
                                <label for="name">客户端IP</label>
                                <input type="text" class="form-control" id="ip"  placeholder="IP">
                            </div>
                            <div class="form-group">
                                <label for="name">手机号</label>
                                <input type="text" class="form-control" id="phone" placeholder="异常通知手机号以逗号,分割多个">
                            </div>
                            <div class="form-group">
                                <label for="name">邮箱</label>
                                <input type="text" class="form-control" id="email" placeholder="异常通知邮箱以逗号,分割多个">
                            </div>
                            <div class="form-group">
                                <label for="name">请选择状态:</label>
                                <label>
                                    <input type="radio" value="1" name="state" id="state1" checked> 启用
                                </label>
                                <label>
                                    <input type="radio" value="0" name="state" id="state0" > 禁用
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
<script src="/static/js/client.js"></script>
<script src="/static/js/page.js"></script>