<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <link rel="stylesheet"
     href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
     integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
     crossorigin="anonymous">
</head>
<body>

    <div class="container col-md-3 border rounded mx-auto my-5 py-3 shadow bg-white">
      <h1 class="text-center">Login Form</h1>
      <form action="login" method="post">

       <div class="form-group">
        <label>Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
       </div>

       <div class="form-group">
        <label>Password:</label>
        <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
       </div>

        <nav class="navbar px-0">
            <button type="submit" class="btn btn-primary">Login</button>
            <a href="signup" class="btn btn-sm btn-secondary">Signup</a>
        </nav>

      </form>

     </div>

</body>
</html>