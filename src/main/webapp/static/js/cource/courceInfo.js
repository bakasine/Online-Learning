$(function () {
    var ctx = $("meta[name='ctx']").attr("context");
    $("#addToMine").click(function () {
        var courceId = $("meta[name='getCourceId']").attr("context");
        var userId = $("#getUserId").val();
        var courceName = $("#getCourceName").text();
        var classify = $("#getCourceClassify").text();
        if (userId == null || userId == "") {
            alert("请先登录");
            return;
        }
        $.ajax({
            url: ctx + "/cource/addStudyingCource",
            type: "post",
            data: {
                'courceId': courceId,
                'userId': userId,
                'courceName': courceName,
                'classify': classify
            },
            success: function (data) {
                alert("添加成功");
            }
        });

    });
});