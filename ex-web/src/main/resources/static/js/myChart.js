/**
 * Created by xiaoting on 2017/9/30.
 */
var myChart;
var myChart1;
$(document).ready(function () {
    getClientList();
    getExList();
    myChart = echarts.init(document.getElementById('main'));
    myChart1 = echarts.init(document.getElementById('main1'));
    extracted({"day": 7});
});
/**
 * 查询机器列表
 */
function getClientList() {
    ajaxJson("client/getClinetList",function (req) {
        req.forEach(function (element) {
            var text = element.ip;
            if (typeof element.remarks != 'undefined' && element.length > 0) {
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
    ajaxJson("exList/getExList",function (data) {
        data.forEach(function (element) {
            $("#exList").append("<option value='" + element + "'>" + element + "</option>");
        });
    });
}


function extracted(data) {
    ajaxJson("getDataList",data,showPie);
    ajaxJson("getLineData",data,showLineChart);
}
$("select").change(function () {
    extracted({
        "day": $("#days").val(),
        "clinet": $("#clinets").val(),
        "exName": $("#exList").val()
    });
});

/**
 * 显示折线图报表
 */

function showLineChart(data) {
    myChart.clear();
    var times = [];
    var values = [];
    data.forEach(function (element) {
        times.push(element.time);
        values.push(element.size);
    });

    var option = {
        title: {
            text: '异常统计'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['每天异常次数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: times
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '异常发生次数',
                type: 'line',
                stack: '总量',
                data: values
            }
        ]
    };
    myChart.setOption(option);

}
/**
 * 显示饼图
 */
function showPie(data) {
    myChart1.clear();
    var exTyepData = [];
    data.forEach(function (element) {
        var val = {value: element.size, name: element.exClass}
        exTyepData.push(val);
    });

    var option1 = {
        title: {
            text: '单个异常发生次数',
            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [
            {
                name: '异常类型',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: exTyepData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart1.setOption(option1);
}
