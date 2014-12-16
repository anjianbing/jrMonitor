<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="true" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <!-- MEMO: update me with `git checkout gh-pages && git merge master && git push origin gh-pages` -->
    <head>
        <meta charset="utf-8">
        <title>统一监控平台</title>
        <link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${ctx}/css/ripples.min.css" rel="stylesheet">
        <link href="${ctx}/css/material-wfont.min.css" rel="stylesheet">
        <link href="${ctx}/css/snackbar.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body{padding-top:50px}#banner{border-bottom:none}.page-header h1{font-size:4em}.bs-docs-section{margin-top:8em}.bs-component{position:relative}.bs-component .modal{position:relative;top:auto;right:auto;left:auto;bottom:auto;z-index:1;display:block}.bs-component .modal-dialog{width:90%}.bs-component .popover{position:relative;display:inline-block;width:220px;margin:20px}#source-button{position:absolute;top:0;right:0;z-index:100;font-weight:bold;padding: 5px 10px;}.progress{margin-bottom:10px}footer{margin:5em 0}footer li{float:left;margin-right:1.5em;margin-bottom:1.5em}footer p{clear:left;margin-bottom:0}.splash{padding:4em 0 0;background-color:#141d27;color:#fff;text-align:center}.splash h1{font-size:4em}.splash #social{margin:2em 0}.splash .alert{margin:2em 0}.section-tout{padding:4em 0 3em;border-bottom:1px solid rgba(0,0,0,0.05);background-color:#eaf1f1}.section-tout .fa{margin-right:.5em}.section-tout p{margin-bottom:3em}.section-preview{padding:4em 0 4em}.section-preview .preview{margin-bottom:4em;background-color:#eaf1f1}.section-preview .preview .image{position:relative}.section-preview .preview .image:before{box-shadow:inset 0 0 0 1px rgba(0,0,0,0.1);position:absolute;top:0;left:0;width:100%;height:100%;content:"";pointer-events:none}.section-preview .preview .options{padding:1em 2em 2em;border:1px solid rgba(0,0,0,0.05);border-top:none;text-align:center}.section-preview .preview .options p{margin-bottom:2em}.section-preview .dropdown-menu{text-align:left}.section-preview .lead{margin-bottom:2em}@media (max-width:767px){.section-preview .image img{width:100%}}.sponsor{text-align:center}.sponsor a:hover{text-decoration:none}@media (max-width:767px){#banner{margin-bottom:2em;text-align:center}}
            .infobox .btn-sup { color: rgba(0,0,0,0.5); font-weight: bold; font-size: 15px; line-height: 30px; }
            .infobox .btn-sup img { opacity: 0.5; height: 30px;}
            .infobox .btn-sup span { padding-left: 10px; position: relative; top: 2px; }
            .icons-material .row { margin-bottom: 20px; }
            .icons-material .col-xs-2 { text-align: center; }
            .icons-material i { font-size: 34pt; }

            .icon-preview {
                display: inline-block;
                padding: 10px;
                margin: 10px;
                background: #D5D5D5;
                border-radius: 3px;
                cursor: pointer;
            }
            .icon-preview span {
                display: none;
                position: absolute;
                background: black;
                color: #EEE;
                padding: 5px 8px;
                font-size: 15px;
                font-family: Roboto;
                border-radius: 2px;
                z-index: 10;
            }
            .icon-preview:hover i { color: #4285f4; }
            .icon-preview:hover span { display: block; cursor: text; }

        </style>
    </head>
    <body>




            <!-- Tables
================================================== -->
           
                <div class="page-header">
                    <h1 id="tables">统一监控平台</h1>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        

                        <div class="bs-component">
                            <table class="table table-striped table-hover ">
                                <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>触发时间</th>
                                        <th>触发规则名称</th>
                                        <th>短信告知</th>
                                        <th>邮件告知</th>
                                        <th>应用名称</th>
                                        <th>应用负责人</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="mor" varStatus="vs">
                                    <tr
                                    <c:if test="${vs.count%2==0}">
                                        class="active"
                                    </c:if>
                                    <c:if test="${vs.count%2 > 0}}">
                                        class="warning"
                                    </c:if>
                                    >
                                    <td>${mor.did} -- ${vs.count}</td>
                                    <td>${mor.formaetDate}</td>
                                    <td>${mor.rname}</td>
                                    <td>
                                        <c:if test="${mor.isemail == 0}">
                                            <i class="mdi-navigation-check">邮件发送成功</i>
                                        </c:if>
                                        <c:if test="${mor.isemail == 1}">
                                            <i class="mdi-navigation-close">邮件发送失败</i>
                                        </c:if>
                                    </td>
                                    <td>
                                        <c:if test="${mor.isphone == 0}">
                                            <i class="mdi-navigation-check">短信发送成功</i>
                                        </c:if>
                                        <c:if test="${mor.isphone == 1}">
                                            <i class="mdi-navigation-close">短信发送失败</i>
                                        </c:if>
                                    </td>
                                    <td>${mor.sname}</td>
                                    <td>${mor.uname}</td>
                                    <td><a href="#" onclick="getDate(${mor.did})"><i class="mdi-editor-format-list-numbered" data-toggle="modal" data-target="#complete-dialog">详细</i></a>
                                    </td>
                                    </tr>
                                 </c:forEach>
                                </tbody>
                            </table>
                        </div><!-- /example -->
                    </div>
                </div>
           



                    <br>
            <div id="complete-dialog" class="modal fade" tabindex="-1">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">详情</h4>
                        </div>
                        <div class="modal-body">
                            <table border="0">
                                <tr><td align="left">编号:</td><td align="left"><p id="sid"></p></td></tr>
                                <tr><td align="left">应用名称:</td><td align="left"><p id="sname"></p></td></tr>
                                <tr><td align="left">应用类型:</td><td align="left"><p id="stype"></p></td></tr>
                                <tr><td align="left">应用描述:</td><td align="left"><p id="rdesc"></p></td></tr>
                                <tr><td align="left">应用负责人列表:</td><td align="left"><p id="users"></p></td></tr>
                                <tr><td align="left">规则配置信息:</td><td align="left"><p id="config"></p></td></tr>
                                <tr><td align="left">短信告知状态:</td><td align="left"><p id="phonestate"></p></td></tr>
                                <tr><td align="left">邮件告知状态:</td><td align="left"><p id="mailstate"></p></td></tr>
                                <tr>
                                    <td><button class="btn btn-primary">短信重新发送</button></td>
                                    <td><button class="btn btn-primary">邮件重新发送</button></td>
                                </tr>
                            </table>









                            <p id="Retrystate">
                                 </p>

                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-primary" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
            <style>
                #dialog h2 {
                    padding: 14px;
                    margin: 0;
                    font-size: 16px;
                    font-weight: 400;
                }
            </style>

        <script src="${ctx}/js/jquery-1.10.2.min.js"></script>
        <script src="${ctx}/js/bootstrap.min.js"></script>
        <script>

                function getDate(id) {
                    $.ajax({
                        type: "GET",
                        url: "${ctx}/get/"+id,
                        dataType: "json",
                        success: function(data){
                            $('#sid').html(data.sid);
                            $('#sname').html(data.sname);
                            $('#stype').html(data.type);
                            $('#rdesc').html(data.sdesc);
                            if(data.isphone == '0'){
                                $('#phonestate').html("<i class='mdi-navigation-check'>短信发送成功</i>");
                            }else{
                                $('#phonestate').html("<i class='mdi-navigation-close'>短信发送失败</i>");
                            }

                            if(data.isemail == '0'){
                                $('#mailstate').html("<i class='mdi-navigation-check'>邮件发送成功</i>");
                            }else{
                                $('#mailstate').html("<i class='mdi-navigation-close'>邮件发送失败</i>");
                            }

                        },
                        error:function(){
                            alert("ddddd")
                        }
                    });

                    $.ajax({
                        type: "GET",
                        url: "${ctx}/getUserConfig/"+id,
                        dataType: "json",
                        success: function(data){
                            var code = "";
                            $.each(data, function(commentIndex, comment){
                                code += comment.uname + ":" + comment.uemail + "<br>";
                            });
                            $('#users').html(code);
                        },
                        error:function(){
                            alert("ddddd")
                        }
                    });
                }



        </script>
        <script src="${ctx}/js/ripples.min.js"></script>
        <script src="${ctx}/js/material.min.js"></script>

    </body>
</html>
