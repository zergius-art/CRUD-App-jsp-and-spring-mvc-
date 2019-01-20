<%@ page isELIgnored="false"%>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <h3>Spring MVC Create, Read, Update and Delete (CRUD) Example</h3>

    <form action="login" method="post">
      <pre>
        <strong>Login Here | <a href="create.jsp">Click here to create new User</a></strong>

        User Id: <input type="text" name="name" />

        Password: <input type="password" name="pass" />

        <input type="submit" value="Login" />
      </pre>
    </form>
    ${msg}
  </body>
</html>