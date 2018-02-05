<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ukr-sustavov
  Date: 25.01.2018
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clock</title>
</head>
<body>

<%@  include file="/hello.jsp" %>

The time is: <%=new Date() %>
</body>
</html>
