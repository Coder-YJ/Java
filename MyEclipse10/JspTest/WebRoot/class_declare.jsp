<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<body>
	<P> 请输入圆的半径：<BR>
	   <FORM action="class_declare.jsp" method=get>
	      <INPUT type="text" name="radius" value=<%=request.getParameter("radius")%>>
	      <INPUT type="submit" value="计算">
	   </FORM>
	<%!  public class Circle{
	               double r;
	               Circle(double r){
	                     this.r=r;
	               }
	               double area_computing(){
	                     return Math.PI*r*r;
	               }
	               double circumference_computing(){
	                     return 2*Math.PI*r;
	               } 
	}%>
	
	<% String str=request.getParameter("radius");
       double r;
       if(str!=null){
             r=Double.valueOf(str).doubleValue();
             Circle circle=new Circle(r);%>
             <P> 圆的面积是：<BR>
                   <%= circle.area_computing()%>
             <P> 圆的周长是：<BR>
                   <%= circle.circumference_computing()%>
       <%}%><br>

		<%
			for (int i = 1; i <= 4; i++) {
		%>
		<h<%=i%>>Hello</h<%=i%>><br>
		<%
			}
		%>
		</body>
</html>
