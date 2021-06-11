<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Signup</title>
    <link rel="stylesheet"
         href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
         integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
         crossorigin="anonymous">
</head>
<body>

    <div class="container col-md-3 border rounded mx-auto my-5 py-3 shadow bg-white">

        <c:if test="${message != null}">
            <div class="alert alert-danger" role="alert">
                <b><c:out value="${message}"/></b>
            </div>
        </c:if>

          <h1 class="text-center">Registration</h1>

          <form action="signup" method="post">

          <div class="form-group">
            <label>First Name:</label>
            <input type="text" class="form-control" id="first-name" placeholder="First Name" name="first-name">
          </div>

          <div class="form-group">
            <label>Last Name:</label>
            <input type="text" class="form-control" id="last-name" placeholder="Last Name" name="last-name">
          </div>

           <div class="form-group">
            <label>Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
           </div>

           <div class="form-group">
            <label>Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
           </div>

           <nav class="navbar px-0">
                <a href="login" class="btn btn-sm btn-secondary">Back</a>
                <button type="submit" class="btn btn-primary">Signup</button>
           </nav>

          </form>

    </div>

</body>
</html>