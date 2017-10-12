<#include "/header.ftl" >
<#include "/page.ftl" >
<div class="panel panel-default">
    <div class="panel-heading">数据字典</div>
    <div class="panel-body">
        <table class="table table-bordered">
            <tr>
                <td>id</td>
                <td>字典名</td>
                <td>字典值</td>
                <td>备注</td>
                <td>修改时间</td>
                <td>创建时间</td>
                <td>操作</td>
            </tr>
        <#list configs as item >
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.value}</td>
                <td>${item.desc}</td>
                <td>${item.utime}</td>
                <td>${item.ctime}</td>
                <td>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default">删除</button>
                    </div>
                </td>
            </tr>
        </#list>
        </table>
        <button class="btn btn-default" data-toggle="modal" data-target="#myModal" type="button"> <span class="glyphicon glyphicon-pencil" aria-hidden="true">新增配置</span></button>
        <div class="pagination" id="p1"  style="float: right"></div>

        <!-- Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="myModalLabel">新增配置</h4>
                    </div>
                    <div class="modal-body">
                        <form role="form">
                            <div class="form-group">
                                <label for="name">key名</label>
                                <input type="text" class="form-control" id="key"  placeholder="key名">
                            </div>
                            <div class="form-group">
                                <label for="name">value</label>
                                <input type="text" class="form-control" id="value" placeholder="value">
                            </div>
                            <div class="form-group">
                                <label for="name">备注</label>
                                <textarea class="form-control" rows="3" id="desc" placeholder="备注"></textarea>
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
<script src="/static/js/config.js"></script>
<script src="/static/js/page.js"></script>