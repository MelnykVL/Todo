<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Task editor</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

    <jsp:include page="template/header.jsp" />

    <div class="container col-md-3 border rounded mx-auto my-5 py-3">

    <form action="edit" method="POST">

           <div class="form-group">
            <label>Title:</label>
                <input type="text" class="form-control" id="title" value='<c:out value="${todo.title}" />' name="title">
           </div>

           <div class="form-group">
                <label>Description:</label>
                <textarea class="form-control" id="description" name="description"><c:out value="${todo.description}" /></textarea>
           </div>

           <div class="form-group">
            <div class="input-group mb-3">
              <div class="input-group-prepend">
                <label class="input-group-text" for="inputGroupSelect01">Status</label>
              </div>

              <select class="custom-select text-uppercase font-weight-bold" id="inputGroupSelect01" name="status">

                <c:if test="${todo.done == false}">
                  <option class="text-center align-middle text-success text-uppercase font-weight-bold" value="false" selected>in progress</option>
                  <option class="text-center align-middle text-secondary text-uppercase font-weight-bold" value="true">closed</option>
                </c:if>

                <c:if test="${todo.done == true}">
                    <option class="text-center align-middle text-success text-uppercase font-weight-bold" value="true" selected>closed</option>
                    <option class="text-center align-middle text-secondary text-uppercase font-weight-bold" value="false">in progress</option>
                </c:if>

              </select>
            </div>
           </div>

            <nav class="navbar px-0 d-flex justify-content-end">
                <button type="submit" class="btn btn-primary">Save changes</button>
            </nav>

          </form>

    </div>

</body>

</html>