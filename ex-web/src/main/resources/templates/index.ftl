<#include "/header.ftl" >
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
        <div class="col-xs-4">
            <div class="input-group">
                <label class="input-group-addon control-label ">时间段:</label>
                <select class="form-control" id="days">
                    <option value="7" >最近一周</option>
                    <option value="30">最近一个月</option>
                    <option value="90">最近三个月</option>
                </select>
            </div>
        </div>
        <div class="col-xs-4">
            <div class="input-group">
                <label class="input-group-addon control-label ">异常类型:</label>
                <select class="form-control " id="exList">
                    <option value="">请选择</option>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-7">
        <div class="panel panel-default">
            <div class="panel-heading">异常统计</div>
            <div class="panel-body">
                <div id="main" style="width: 100%;height:400px;"></div>
            </div>
        </div>
    </div>
    <div class="col-md-5">
        <div class="panel panel-default">
            <div class="panel-heading">单个异常次数</div>
            <div class="panel-body">
                <div id="main1" style="width: 100%;height:400px;"></div>
            </div>
        </div>
    </div>
</div>
<#include "/foot.ftl" >
<script src="/static/js/echarts.min.js"></script>
<script src="/static/js/myChart.js"></script>
