<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>TodoApp</title>

            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossorigin="anonymous">
            <style>
                .checkbox-xl::before,
                .checkbox-xl::after {
                    top: 1.2rem;
                    width: 1.85rem;
                    height: 1.85rem;
                }
            </style>
        </head>

        <body>


            <nav class="navbar navbar-dark bg-dark navbar-fixed-top">

                <div class="container" style="overflow: auto">
                    <button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">Add
                        new task</button>
                    <a href="logout" class="btn btn-sm btn-outline-warning">Logout</a>
                </div>

            </nav>

            <div class="container">

                <table class="table table-bordered table-hover my-4">
                    <thead class="text-center">
                        <tr>
                            <th style="width: 10%" scope="col">Title</th>
                            <th scope="col">Description</th>
                            <th style="width: 20%" scope="col">Status</th>
                            <th style="width: 20%" scope="col">Action</th>
                        </tr>
                    </thead>
                    <c:forEach var="todo" items="${todoList}">
                        <c:if test="${todo.done == false}">
                            <tbody>
                                <tr>
                                    <th class="text-center" scope="row">
                                        <c:out value="${todo.title}" />
                                    </th>
                                    <td>
                                        <c:out value="${todo.description}" />
                                    </td>

                                    <td class="text-center align-middle text-success text-uppercase font-weight-bold">
                                        in progres
                                    </td>

                                    <td class="text-center align-middle font-weight-bold">
                                        <a href="edit?id=<c:out value='${todo.id}' />" class="text-warning px-3">Edit</a>
                                        <a href="delete?id=<c:out value='${todo.id}' />" class="text-danger px-3">Delete</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>

                <hr>
                <hr>

                <table class="table table-bordered table-hover my-4">
                    <thead class="text-center">
                        <tr>
                            <th style="width: 10%" scope="col">Title</th>
                            <th scope="col">Description</th>
                            <th style="width: 20%" scope="col">Status</th>
                            <th style="width: 20%" scope="col">Action</th>
                        </tr>
                    </thead>
                    <c:forEach var="todo" items="${todoList}">
                        <c:if test="${todo.done == true}">
                            <tbody>
                                <tr>
                                    <th class="text-center" scope="row">
                                        <c:out value="${todo.title}" />
                                    </th>
                                    <td>
                                        <c:out value="${todo.description}" />
                                    </td>

                                    <td class="text-center align-middle text-secondary text-uppercase font-weight-bold">
                                        closed
                                    </td>

                                    <td class="text-center align-middle font-weight-bold">
                                        <a href="edit?id=<c:out value='${todo.id}' />" class="text-warning px-3">Edit</a>
                                        <a href="delete?id=<c:out value='${todo.id}' />" class="text-danger px-3">Delete</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:if>
                    </c:forEach>
                </table>

            </div>

            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New task</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="main" method="post">
                                <div class="form-group">
                                    <label class="col-form-label">Title:</label>
                                    <input type="text" class="form-control" id="title" name="title">
                                </div>
                                <div class="form-group">
                                    <label class="col-form-label">Description:</label>
                                    <textarea class="form-control" id="description" name="description"
                                        rows="5"></textarea>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-primary">Add</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>



            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
                crossorigin="anonymous">
                </script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
                integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
                crossorigin="anonymous">
                </script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
                integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
                crossorigin="anonymous">
                </script>
            <script>
                $('#myModal').on('shown.bs.modal', function () {
                    $('#myInput').trigger('focus')
                })
            </script>
        </body>

        </html>