<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#txtName").blur(function(){
                $.post("ajax",{"name":$("#txtName").val()},function(data){
                    alert(data);
                });
            });
        });
    </script>
</head>
<body>
<h2>Hello Ajax!</h2>
用户名<input type="text" id="txtName" />
</body>
</html>