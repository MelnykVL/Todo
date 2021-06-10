<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-dark bg-dark navbar-fixed-top">

    <div class="container">
        <h2>
            <a href="main" class="text-danger px-3 py-1 border border-danger rounded" style="text-decoration: none;">
                <c:out value="${username}" default="Username" />
            </a>
        </h2>
        <a href="logout" class="btn btn-sm btn-outline-warning px-2"><b>Logout</b></a>
    </div>

</nav>