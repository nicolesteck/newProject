<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="head.jsp"%>

<html><body>


<!-- Main -->
<article id="main">

    <header class="special container">
        <span class="icon fa-laptop"></span>
        <h2>View All <strong>Users</strong></h2>
    </header>

    <!-- One -->
    <section class="wrapper style4 container">

        <div class="row 150%">
            <div class="4u 12u(narrower)">

                <!-- Sidebar -->
                <div class="sidebar">
                    <section>
                        <header>
                            <h3>LEFT SIDEBAR</h3>
                        </header>

                    </section>
                </div>

            </div>
            <div class="8u 12u(narrower) important(narrower)">

                <!-- Content -->
                <div class="content">
                    <section>
                        <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
                        <header>
                            <h3>Update Connection</h3>
                        </header>
                        <c:forEach var="curr" items="${user}">
                        <FORM ACTION="completeUserUpdate?id=${curr.id}" METHOD="POST">
                            <TABLE>
                                <TR><TD>First Name: <INPUT TYPE="TEXT" NAME="firstName" VALUE="${curr.firstName}"></TD></TR>
                                <TR><TD>Last Name: <INPUT TYPE="TEXT" NAME="lastName" VALUE="${curr.lastName}"></TD></TR>
                                <TR><TD>Email: <INPUT TYPE="TEXT" NAME="email" VALUE="${curr.email}"></TD></TR>
                              <%--
                                <TR><TD>Role:
                                    <INPUT TYPE="select" NAME="roleName" value="${curr.roles.get(0).roleName}">
                                    <SELECT>
                                        <option value="admin">Admin</option>
                                        <option value="user">User</option>
                                    </SELECT>

                                </TD></TR>
                                --%>
                                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Update"></TH></TR>
                            </TABLE>
                            </c:forEach>
                        </FORM>


                    </section>
                </div>

            </div>
        </div>
    </section>

    <!-- Two --

    <section class="wrapper style1 container special">
        <div class="row">
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>This is Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>Also Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
            <div class="4u 12u(narrower)">

                <section>
                    <header>
                        <h3>Probably Something</h3>
                    </header>
                    <p>Sed tristique purus vitae volutpat ultrices. Aliquam eu elit eget arcu commodo suscipit dolor nec nibh. Proin a ullamcorper elit, et sagittis turpis. Integer ut fermentum.</p>
                    <footer>
                        <ul class="buttons">
                            <li><a href="#" class="button small">Learn More</a></li>
                        </ul>
                    </footer>
                </section>

            </div>
        </div>
    </section> -->

</article>

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
