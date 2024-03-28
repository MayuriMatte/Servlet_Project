<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="index.html"></jsp:include>
    <br><br>
    <center>
    <form name="frm" action="uservalidatecontroller" method="post">
    <input type="text" name="username" value="" style="width:400px;height:40px"/><br><br>
     <input type="text" name="password" value="" style="width:400px;height:40px"/><br><br>
      <input type="submit" name="s" value="login user" style="width:400px;height:40px"/>
      </form>
    </center>
</body>
</html>