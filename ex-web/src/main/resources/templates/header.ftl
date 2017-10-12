<!DOCTYPE html>
<html>
<head>
    <title>${titile}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel='stylesheet' href='/static/css/style.css'/>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="//cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/static/js/url.js"></script>
    <script src="/static/js/main.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top ">
    <p class="navbar-text"><a href="/">异常管理平台</a></p>
</nav>
<div style=" margin-right: -15px; margin-left: -69px;">
    <div class="col-xs-2 ">
        <div class="panel panel-default">
            <div class="panel-body">
                <ul class="nav  nav-stacked" data-spy="affix" data-offset-top="125">
                    <li><a href="/client/toClient">客户端管理</a></li>
                    <li><a href="/config/toConfig">配置信息</a></li>
                    <li><a href="/exList/toEx">异常管理</a></li>
                    <li><a href="/exList/toExEmail">邮件发送管理</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-xs-10">