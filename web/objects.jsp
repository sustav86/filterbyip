<%@ page import="javafx.application.Application" %><%--
  Created by IntelliJ IDEA.
  User: ukr-sustavov
  Date: 25.01.2018
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Objects</title>
</head>
<body>

<%
    String userName = request.getParameter("name");

    if (userName != null) {
        session.setAttribute("sessionUserName", userName);
        application.setAttribute("appUserName", userName);
        pageContext.setAttribute("pageContextUserName", userName);
    }
//    request
//    HttpSession
//    Application
%>

<br>
User request name is: <%=userName %>
<br>
User session name is: <%=session.getAttribute("sessionUserName") %>
<br>
User application name is: <%=application.getAttribute("appUserName") %>
<br>
User pageContext name is: <%=pageContext.getAttribute("pageContextUserName") %>
</body>
</html>
