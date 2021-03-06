<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>


<div class="container">

<br><br><br><br><br><br><br><br><br><br><br>

</div>

<div class="container" style="margin-top:50px;">
    <h2 class="card-title">Результаты поиска</h2>
    <div class="card-deck">
        <c:forEach items="${offers}" var="offer">
            <jsp:useBean id="offer" type="ru.marketplace.model.Offer"/>
            <div class="col-md-4">
                <div class="card-sl">
                    <div class="card-image">
                        <img src="resources/png/not_image.png" />
                    </div>
                    <a class="card-action" href="#"><i class="fa fa-heart"></i></a>
                    <div class="card-heading">
                            ${offer.name}
                    </div>
                    <div class="card-text">
                        ${offer.description}
                    </div>
                    <div class="card-text">
                        ${offer.price} рублей
                    </div>
                    <a href="#" class="card-button">Посмотреть</a>
                </div>
            </div>
        </c:forEach>
    </div>



    <%--<div class="container">--%>

    <%--    <div class="row">--%>
    <%--        <c:forEach items="${offers}" var="offer">--%>
    <%--            <jsp:useBean id="offer" type="ru.marketplace.model.Offer"/>--%>
    <%--            <div class="col-md-4">--%>
    <%--                <div class="card mb-4 box-shadow">--%>
    <%--                    <a href="/offers/${offer.id}" >--%>
    <%--                        <img class="card-img-top"--%>
    <%--                             data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail"--%>
    <%--                             alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;"--%>
    <%--                             src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22347%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20347%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_17d2da6c4b7%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_17d2da6c4b7%22%3E%3Crect%20width%3D%22347%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22119.5%22%20y%3D%22120.10000019073486%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E"--%>
    <%--                             data-holder-rendered="true">--%>
    <%--                    </a>--%>
    <%--                    <div class="card-body">--%>
    <%--                        <p class="card-text">${offer.description}</p>--%>
    <%--                        <div class="d-flex justify-content-between align-items-center">--%>
    <%--                            <div class="btn-group">--%>
    <%--                                <button type="button" class="btn btn-sm btn-outline-secondary">View</button>--%>
    <%--                                <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>--%>
    <%--                            </div>--%>
    <%--                            <small class="text-muted">9 mins</small>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </c:forEach>--%>
    <%--    </div>--%>
    <%--</div>--%>

    <script>
        var target = $(".card-title").offset().top;
        $(window).scrollTop(target);
    </script>

<jsp:include page="fragments/footer.jsp"/>
</body>
</html>

