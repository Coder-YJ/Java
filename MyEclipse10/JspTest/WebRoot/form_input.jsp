<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body bgcolor=green><FONT size=3>
		<FORM action="form_process.jsp" method="post">
			<INPUT type="text" name="input_text"> 
			<INPUT type="submit" value="提交">
		</FORM>
		
	<%
     for(int i=1;i<=8;i++){
        out.println("Hello "+i);%><BR><%
    }%>
		
</body>
</html>
