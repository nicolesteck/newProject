<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="LinkedIn Annotation Tool" />
<%@include file="head.jsp"%>

<html>
<body class="index">
<div id="page-wrapper">

    <!-- Header -->
    <header id="header" class="alt">

        <%@include file="nav.jsp"%>
    </header>

    <!-- Banner -->
    <section id="banner">

        <!--
            ".inner" is set up as an inline-block so it automatically expands
            in both directions to fit whatever's inside it. This means it won't
            automatically wrap lines, so be sure to use line breaks where
            appropriate (<br />).
        -->
        <div class="inner">

            <header>
                <h2>ANNOTATE</h2>
            </header>
            <p>You have successfully removed your connection!
            They won't be bothering you anymore. </p>


          <!--
            <footer>
                <ul class="buttons vertical">
                    <li><a href="#main" class="button fit scrolly">Tell Me More</a></li>
                </ul>
            </footer>
            -->

        </div>

    </section>


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
