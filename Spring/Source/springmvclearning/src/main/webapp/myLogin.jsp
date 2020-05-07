<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Login</h2>
<p>${msg}</p>
<form method="post" action="/myLogin">
    Name:<input type="text" name="name"><br>
    Password:<input type="password" name="psw"><br>
    Remember-me: <input type="checkbox" name="remember-me" title="Remember-me">
    <input type="submit" value="add">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>