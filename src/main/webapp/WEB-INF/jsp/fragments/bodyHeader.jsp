<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
    <h5 class="my-0 mr-md-auto font-weight-normal">Marketplace</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="#">Войти</a>
        <a class="p-2 text-dark" href="#">Зарегистрироваться</a>
    </nav>
</div>
<section class="jumbotron text-center">
    <div class="container">
        <form method="get" action="search" id="filter">
            <div class="row" id="rowSearch">
                <div class="col-7">
                    <input type="text" id="inputSearch"  class="form-control form-input" name="name" placeholder="Search anything...">
                </div>
                <div class="col-2">
                    <select class="form-control form-input" name="category" id="inputParam">
                        <option value="">Выберите категорию</option>
                        <option value="goods">Куплю</option>
                        <option value="service">Услуги</option>
                        <option value="realty">Недвижимость</option>
                    </select>
                </div>
                <div class="col-2">
                    <select class="form-control form-input" name="region" id="inputParam">
                        <option value="">Выберите регион</option>
                        <option value="100004">Челябинская область</option>
                        <option value="100005">Свердловская область</option>
                    </select>
                </div>
            </div>
        </form>
    </div>
</section>




