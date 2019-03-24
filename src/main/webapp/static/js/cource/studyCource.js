$(function () {

    var ctx = $("meta[name='ctx']").attr("context");
    var courseId = $("meta[name='courceId']").attr("context");
    $.ajax({
        url: ctx + "/cource/getMainSection",
        type: "post",
        data: {
            'courseId': courseId
        },
        success: function (data) {
            var list = data.list;
            $.each(list, function (index, item) {
                var divTd = $("<div></div>").addClass("chapter").attr("id", item.id);
                var aTd = $("<a></a>").addClass("js-open").attr("href", "javascript:void(0);");
                var hTd = $("<h3></h3>").append(item.name);
                var spanTd = $("<span></span>").addClass().append("▼")
                hTd.append(spanTd);
                aTd.append(hTd);
                var ulTd = $("<ul></ul>").addClass("chapter-sub");
                divTd.append(aTd).append(ulTd);
                $("#video-course-fix").append(divTd);
            });
        }
    });

    $.ajax({
        url: ctx + "/cource/getSubSection",
        type: "post",
        data: {
            'courseId': courseId
        },
        success: function (data) {
            var list = data.list;
            $.each(list, function (index, item) {
                var aTd = $("<a></a>").addClass("clickEvent").attr("href", "#").attr("videoUrl", ctx + "/video/" + item.url);
                var liTd = $("<li></li>").addClass("ellipsis video-li").append("▶" + item.name);
                aTd.append(liTd);
                var parentRoot = "#" + item.parentId + " .chapter-sub";
                $(parentRoot).append(aTd);
            });
        }
    });
    $(document).on("click", ".clickEvent", function () {
        // $("videoNow").attr("src", $(this).attr("videoUrl"));
        var obj = $(this);
        var path = obj.attr("videoUrl");
        $(".course-video video").attr("src", path);

    });
});



$(function(){




    $('.chapter li').hover(function(){
        $(this).find('.icon-video').css('color','#0089D2');
    },function(){
        $(this).find('.icon-video').css('color','#777');
    });

    $('.js-open').click(function(){
        var display = $(this).parent().find('ul').css('display');
        if(display == 'none'){
            $(this).parent().find('ul').css('display','block');
            $(this).find('.drop-down').html('▼');
        }else{
            $(this).parent().find('ul').css('display','none');
            $(this).find('.drop-down').html('▲');
        }
    });
});