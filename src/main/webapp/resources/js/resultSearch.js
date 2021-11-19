

















/*function makeEditable() {
    $.ajax({
        url: "rest/offers",
        method: "GET"
    }).then(function (response) {
        for(var i = 0; i < response.length ; i++) {
            var row = $("<tr>");
            var name = $("<td>" + response[i].name + "</td>");
            var description = $("<td>" + response[i].description + "</td>");
            var price = $("<td>" + response[i].price + "</td>");

            row.append([name, description, price]).append("</tr>");
            tableBody.append(row);
        }
    });
}*/



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
