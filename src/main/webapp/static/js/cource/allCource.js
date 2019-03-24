$(function () {
    var ctx = $("meta[name='ctx']").attr("context");

    $.ajax({
        url: ctx + "/cource/getAllCource",
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
                $("#all-cource").append(divTd);

            });
            $("#all-cource img").attr("src", ctx + "/image/black.png");
        }

    });

    $(function () {
        $("#courceClassify").change(function () {
            $('#all-cource').empty();
            var ctx = $("meta[name='ctx']").attr("context");
            var classify = $("#courceClassify").val();
            $.ajax({
                url: ctx + "/cource/getCourceByType",
                type: "post",
                data: {
                    'classify': classify
                },
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
                        $("#all-cource").append(divTd);

                    });
                    $("#all-cource img").attr("src", ctx + "/image/black.png");
                }
            });
        });
    });

});