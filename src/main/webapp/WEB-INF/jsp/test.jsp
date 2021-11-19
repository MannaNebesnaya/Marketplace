<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/main.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a href="#">
                <img class="rounded-circle" src="resources/png/goods.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Купить</h2>
            </a>
        </div>
        <div class="col-lg-4">
            <a href="#">
                <img class="rounded-circle" src="resources/png/service.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Услуги</h2>
            </a>
        </div>
        <div class="col-lg-4">
            <a href="#">
                <img class="rounded-circle" src="resources/png/realty.png" alt="Generic placeholder image" width="140" height="140">
                <h2>Недвижимость</h2>
            </a>
        </div>
    </div>
</div>



<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
