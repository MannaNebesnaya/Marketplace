<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<script type="text/javascript" src="resources/js/main.js" defer></script>
<jsp:include page="fragments/bodyHeader.jsp"/>


<div class="container">

    <div class="category-change clearfix">
        <div class="change-buttons-container right-side clearfix">
            <a class="change-button bigger-on-mobile" onclick="updateMainOffers('goods')">Купить</a>
            <a class="change-button bigger-on-mobile" onclick="updateMainOffers('services')">Услуги</a>
            <a class="change-button bigger-on-mobile" onclick="updateMainOffers('realty')">Недвижимость</a>
        </div>
    </div>

    <div class="row">
        <div class="card-deck" id="card-deck">
        </div>
    </div>
    <jsp:include page="fragments/footer.jsp"/>
</div>

</body>
</html>
