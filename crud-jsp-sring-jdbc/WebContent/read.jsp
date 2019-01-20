<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Read</title>
  </head>
  <body>
    <h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
    <p><strong>User List is Here | <a href="create.jsp">Click here for Create</a></strong></p>
    <table border="1">
      <tr>
        <th>Name</th>
        <th>Password</th>
      </tr>
      <c:forEach var="user" items="${listUser}">
        <tr>
          <td>${user.name}</td>
          <td>${user.pass}</td>
          <td><a href="update/<c:out value='${user.id}'/>">Update</a> | 
            <a href="delete/<c:out value='${user.id}'/>">Delete</a></td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>