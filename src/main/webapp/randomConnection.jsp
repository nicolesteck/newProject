<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="8u 12u(narrower) important(narrower)">

    <!-- Content -->
    <div class="content">
        <section>
            <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
            <c:forEach var="connection" items="${connections}">
            <header>
               <%-- <h3><italic>Let's Talk About...</italic><bold> ${connection.firstName} ${connection.lastName}</bold></h3> --%>
            </header>
                <h6><a href="/nsindieproject/home.jsp" target="_self">Refresh</a></h6>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Company</th>
                    <th>Interests</th>
                    <th>Notes</th>
                </tr>
                <tr>
                    <td class="spaced">${connection.firstName} ${connection.lastName}</td>
                    <td class="spaced">${connection.company}</td>
                    <td class="spaced">${connection.interests}</td>
                    <td class="spaced">${connection.notes}</td>
                </tr>
            </table>

            </c:forEach>


        </section>
    </div>

</div>
