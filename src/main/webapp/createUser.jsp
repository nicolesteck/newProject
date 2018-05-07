<%@ page import="java.util.Properties" %>
<%@include file="head.jsp"%>
<%--
  Created by IntelliJ IDEA.
  User: nicolesteck
  Date: 3/1/18
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Create an Account</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]>
    <script src="../assets/js/ie/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="../assets/css/main.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="../assets/css/ie8.css"/><![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="../assets/css/ie9.css"/><![endif]-->
</head>
<body class="no-sidebar">
<div id="page-wrapper">

    <!-- Header -->
    <header id="header" class="alt">

        <%@include file="nav.jsp"%>
    </header>

    <!-- Main -->
    <article id="main">

        <header class="special container">
            <span class="icon fa-mobile"></span>
            <h2>Create An Account!</h2>
        </header>

        <!-- One -->
        <section class="wrapper style4 container">

            <!-- Content -->
            <div class="content">
                <section>
                    <FORM ACTION="newUser" METHOD="POST">
                        <TABLE>
                            <TR><TD>First Name: <INPUT TYPE="TEXT" NAME="firstName"></TD></TR>
                            <TR><TD>Last Name: <INPUT TYPE="TEXT" NAME="lastName"></TD></TR>
                            <TR><TD>Email: <INPUT TYPE="TEXT" NAME="email"></TD></TR>
                            <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="password"></TD></TR>
                            <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In"></TH></TR>
                        </TABLE>
                    </FORM>
                </section>
            </div>

        </section>

    </article>
</div>

<!-- Scripts -->
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/jquery.dropotron.min.js"></script>
<script src="../assets/js/jquery.scrolly.min.js"></script>
<script src="../assets/js/jquery.scrollgress.min.js"></script>
<script src="../assets/js/skel.min.js"></script>
<script src="../assets/js/util.js"></script>
<!--[if lte IE 8]>
<script src="../assets/js/ie/respond.min.js"></script><![endif]-->
<script src="../assets/js/main.js"></script>


</body>
</html>

