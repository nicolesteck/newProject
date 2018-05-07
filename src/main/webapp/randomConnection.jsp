<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="8u 12u(narrower) important(narrower)">

    <!-- Content -->
    <div class="content">
        <section>
            <a href="#" class="image featured"><img src="images/pic02.jpg" alt="" /></a>
            <c:forEach var="connection" items="${connections}">
            <header>
                <h3>Let's jump right in! Add some information about ${connection.firstName} ${connection.lastName}</h3>
            </header>
            <table style="width:100%">
                <tr>
                    <td style="width: 15em;">Name</td>
                    <td style="width: 15em; padding-left: 20px;">Company</td>
                    <td style="width: 30em; padding-left: 20px;">Interests</td>
                    <td style="width: 40em; padding-left: 20px;">Notes</td>
                </tr>
                <tr>
                    <td style="width: 15em;">${connection.firstName} ${connection.lastName}</td>
                    <td style="width: 15em; padding-left: 20px;">${connection.company}</td>
                    <c:choose>
                        <c:when test="${empty connection.interests}">
                            <td style="width: 30em; padding-left: 20px;">There's nothing here! Update ${connection.firstName}'s interests <a href="updateConnection?linkedInId=${connection.linkedInId}">now!</a></td>
                        </c:when>
                        <c:otherwise>
                            <td style="width: 30em; padding-left: 20px;">${connection.interests}</td>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                    <c:when test="${empty connection.notes}">
                    <td style="width: 40em; padding-left: 20px;">No notes yet. Add some notes about ${connection.firstName} <a href="updateConnection?linkedInId=${connection.linkedInId}">now!</a></td>
                    </c:when>
                    <c:otherwise>
                    <td style="width: 40em; padding-left: 20px;">${connection.notes}</td>
                    </c:otherwise>
                    </c:choose>
            </table>

                  <h3>
                      <a href="updateConnection?linkedInId=${connection.linkedInId}">Update your notes on ${connection.firstName} </a><br />
                      <a href="removeConnection?linkedInId=${connection.linkedInId}">Remove ${connection.firstName} </a></td>
                  </h3>

            </c:forEach>


        </section>
    </div>

</div>
