<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#btn").click(function(){
                $.post("json",function(data){
                    var html="";
                    for(var i=0;i<data.length;i++){
                        html+="<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td>"+data[i].psw+"</td></tr>";
                    }
                    $("#content").html(html);
                });
            });
        });
    </script>
</head>
<body>
<h2>Hello Ajax Json!</h2>
<input id="btn" type="button" value="加载数据" />
<table width="80%" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>密码</td>
    </tr>
    <tbody id="content">
    </tbody>
</table>
</body>
</html>
