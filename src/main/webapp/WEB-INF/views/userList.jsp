<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
      <h3>用户信息列表</h3>
      <hr/>
      <table border="1px">
          <tr>
              <td>编号</td>
              <td>姓名</td>
              <td>年龄</td>
          </tr>
          <c:forEach items="${list}" var="u">
              <tr>
                  <td>${u.id}</td>
                  <td>${u.name}</td>
                  <td>${u.age}</td>
              </tr>
          </c:forEach>
      </table>
</body>
</html>
