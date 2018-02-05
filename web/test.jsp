<%--
  Created by IntelliJ IDEA.
  User: ukr-sustavov
  Date: 25.01.2018
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Testing JSPs</h3>

<%!
    public int add(int a, int b) {
        return a + b;
    }
%>
<%
    int i = 1;
    int j = 2;
    int k;

    k = i + j;

    out.println("Value of k is " + k);
%>

<%
    k=add(333, 456);
%>

<br>

The value of k is: <%=k %>
</body>
</html>
