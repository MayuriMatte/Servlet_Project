<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
input{
   width:400px;
   height:40px;

}
</style>
</head>
<body>
<jsp:include page="index.html"></jsp:include>
<br>
 <center>
 <form name='frm' action='userReg' method='post'>
 <input type='text' name='name' value='' placeholder='Enter Name' /><br><br>
 <input type='text' name='email' value='' placeholder='Enter Email' /><br><br>
 <input type='text' name='contact' value='' placeholder='Enter Contact' /><br><br>
 <input type='text' name='username' value='' placeholder='Enter Username' /><br><br>
 <input type='text' name='password' value='' placeholder='Enter Password' /><br><br>
 <input type='submit' name='s' value='Resister'/>
 </form>
 </center>
</body>
</html>