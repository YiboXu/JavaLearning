<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Upload File</h2>
<p>请选择上传文件</p>
<form method="post" enctype="multipart/form-data">
    文件:<input type="file" name="file">
    <input type="submit" value="upload"><br>
    ${msg}
</form>
</body>
</html>