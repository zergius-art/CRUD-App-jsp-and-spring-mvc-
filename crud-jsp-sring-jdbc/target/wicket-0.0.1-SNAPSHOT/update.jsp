<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Update</title>
  </head>
  <body>
    <h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
    <p><strong>Update Here | <a href="/wicket/read">Click for Read</a></strong></p>
    <form action="../update" method="post">
    <pre>
    <c:forEach var="user" items="${listUser}">

           <input type="hidden" name="id" value="${user.id}"/>
Name:  	   <input type="text" name="name" value="${user.name}" />

Password:  <input type="text" name="pass" value="${user.pass}" />


        <input type="submit" value="Update" />	
    </c:forEach>    
    </pre>
    </form>
  ${msg}
  </body>
</html>