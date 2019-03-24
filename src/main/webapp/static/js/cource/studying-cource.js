function build_cource_table(result) {
    $("#cource_table tbody").empty();
    var list = result.list;
    $.each(list, function (index, item) {
        var checkTd = $("<td><input type='checkbox' class='check_id'/></td>");
        var idTd = $("<td></td>").append(item.id);
        var courceNameTd = $("<td></td>").append(item.courceName);
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" 进入学习");
        editBtn.attr("cource_id", item.courceId).attr('id', 'courceBtn');
        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-calendar")).append(" 不学了");
        delBtn.attr("delete_cource_id", item.id).attr('id', 'deleteBtn');
        var edit = $("<td></td>").append(editBtn).append(" ").append(delBtn);
        $("<tr></tr>").append(checkTd).append(idTd).append(courceNameTd).append(edit).appendTo("#cource_table tbody");
    });
}

$(function () {
    // 删除课程
    $(document).on("click", "#deleteBtn", function () {
        var id = $(this).attr("delete_cource_id");
        var ctx = $("meta[name='ctx']").attr("context");
        $.ajax({
            url: ctx + "/cource/deleteMyStudyingCource/" + id ,
            type: "post",
            success: function (result) {
                alert("删除成功");
                window.location.reload();
            }
        });
    });

    $(document).on("click", "#courceBtn", function () {
        var courceId = $(this).attr("cource_id");
        var ctx = $("meta[name='ctx']").attr("context");
        window.location.href = ctx + "/cource/studyCource?courseId=" + courceId;

    });

});

