<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>


<!-- Main -->
<article id="main">

    <header id="header" >
        <%@include file="nav.jsp"%>
        <br />
    </header>
    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>View All <strong>Users</strong></h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 container">

        <div class="row 150%">
            <div class="content">
                <section>

                    <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                    <header>
                        <h3>Connections</h3>
                    </header>
                    <table>
                        <tr>
                            <th>First</td>
                            <th>Last</td>
                            <th>Email</td>
                            <th>Update</th>
                        </tr>

                        <c:forEach var="curr" items="${users}">
                            <tr>

                                <td>${curr.firstName}</td>
                                <td>${curr.lastName}</td>
                                <td>${curr.email}</td>

                                <td><a href="updateUser?id=${curr.id}">Update Info</a>
                                <br /><a href="removeUser?id=${curr.id}">Remove ${curr.email} </a></td>
                            </tr>

                        </c:forEach>


                    </table>

                </section>
            </div>
            <!--
                            </div> -->
        </div>
    </section>


</article>

<!-- Footer -->
<footer id="footer">

</footer>

</div>

<!-- Scripts -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.dropotron.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/jquery.scrollgress.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
<script src="assets/js/main.js"></script>

</body>
</html>
