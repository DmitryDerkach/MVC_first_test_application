<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:if test="${not empty sessionScope.user}">
        <div>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit">Log out</button>
            </form>
        </div>
    </c:if>
</div>