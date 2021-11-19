function updateMainOffers(category) {
    clearMainOffers();
    $.ajax({
        type: "GET",
        url: "/offers?category=" + category,
        dataType: 'json',
        success: function (data) {
            var cardDeck = $("#card-deck");
            $.each(data, function (index, offer) {

                var col4 =   $('<div class="col-md-4">\n' +
                    '            <div class="card-sl">\n' +
                    '                <div class="card-image">\n' +
                    '                    <img src="/resources/png/not_image.png" />\n' +
                    '                </div>\n' +
                    '                <a class="card-action" href="#"><i class="fa fa-heart"></i></a>\n' +
                    '                <div class="card-heading">\n' +
                    '                    Audi Q8\n' +
                    '                </div>\n' +
                    '                <div class="card-text">\n' +
                    '                    Audi Q8 is a full-size luxury crossover SUV coupé made by Audi that was launched in 2018.\n' +
                    '                </div>\n' +
                    '                <div class="card-text">\n' +
                    '                    $67,400\n' +
                    '                </div>\n' +
                    '                <a href="#" class="card-button"> Purchase</a>\n' +
                    '            </div>\n' +
                    '        </div>')
                cardDeck.append(col4);
            });
        }
    })
}

function clearMainOffers() {
    $("div").remove(".col-md-4");
}
/*function searchOffers() {
    $.ajax({
        type: "GET",
        url:  "search",
        data: $("#filter").serialize(),
    });
}*/

/*$('#filter').keydown(function (e) {
    if (e.which === 13) {
        $.ajax({
            type: "GET",
            url: "search",
            data: $("#filter").serialize()
        });
    }
})*/

/*$('#inputSearch').keydown(function (e) {
    if (e.which === 13) {
        return false;
    }
})*/


/*$('form[method="get"]').submit(function(){
    $(this).find(':input').each(function() {
        var inp = $(this);
        if (!inp.val()) {
            inp.remove();
        }
    });
});*/

/*
$(function () {
    $.ajax({
        url: "https://jsonplaceholder.typicode.com/posts",
        success: function (result) {
            $.each(result, function (index, item) {
                var userId = item.userId;
                var typeId = item.id;
                var titleId = item.title;
                var bodyId = item.body;
                var $info = $("<p/>").html("user id: " + userId + "<br>"
                    + "id: " + typeId + "<br>"
                    + "title: " + titleId + "<br>"
                    + "body: " + bodyId);

                var html = '<div id="card-body>';

                for (let i = 0; i < $(result).length; i++) {
                    const element = $(result)[i];
                }

                html += '</div>';

                $(".addDiv").append(html);

                $("div#card-body").append($info);
            });
            // console.log('success', result);
            // console.log(result[0].body);
            // console.log($(result).length);
        }
    });
});*/
