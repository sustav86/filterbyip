<%--
  Created by IntelliJ IDEA.
  User: ukr-sustavov
  Date: 25.01.2018
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Init page</title>
</head>

<%!
    public void jspInit() {
        String defuser = getServletConfig().getInitParameter("defaultUser");

        ServletContext context = getServletConfig().getServletContext().getContext(defuser);

//        context.setAttribute("defaultUser", defuser);

    }
%>



<body>

  Default user name is:   <%=getServletConfig().getInitParameter("defaultUser")%>

<br>

    <%--Servlet Context Name is: <%=getServletConfig().getServletContext().getAttribute("defaultUser")%>--%>
</body>
</html>
