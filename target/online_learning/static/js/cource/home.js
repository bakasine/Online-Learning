$(function () {
    var ctx = $("meta[name='ctx']").attr("context");
    $.ajax({
        url: ctx + "/carousel/getEnableCarousel",
        type: "post",
        success: function (data) {
            var list = data.list;
            $.each(list, function (index, item) {
                var divTd = $("<div></div>").addClass("item");
                var aTd = $("<a></a>").attr("href", item.url);
                var imgTd = $("<img>").attr("src", ctx + "/image/" + item.picture);
                var divTd2 = $("<div></div>").addClass("carousel-caption");
                var hTd = $("<h3></h3>").append(item.name);
                divTd2.append(hTd);
                aTd.append(imgTd);
                divTd.append(aTd).append(divTd2);
                $("#carouselForm").append(divTd);
            });

        }
    });

    $.ajax({
        url: ctx + "/cource/getHomeCource",
        type: "post",
        success: function (data) {
            var list = data.list;

            $.each(list, function (index, item) {
                var divTd = $("<div></div>").addClass('col-xs-6 col-md-3');
                var aTd = $("<a></a>").addClass("thumbnail").attr("href", ctx + "/cource/courceInfo?id=" + item.id);
                aTd.append("<img>");
                var infoTd = $("<div></div>").addClass("caption");
                var hTd = $("<h3></h3>").append(item.name);
                var pTd = $("<p></p>").append(item.introduce);
                infoTd.append(hTd).append(pTd);
                aTd.append(infoTd);
                divTd.append(aTd);
                $("#random-cource").append(divTd);

            });
            $("#random-cource img").attr("src", ctx + "/image/black.png");
        }


    });
});