function build_table(result) {
    $("#admin_cource_table tbody").empty();
    var list = result.list;
    $.each(list, function (index, item) {
        var checkTd = $("<td><input type='checkbox' class='check_id'/></td>");
        var courceIdTd = $("<td></td>").append(item.id);
        var courceNameTd = $("<td></td>").append(item.name);
        var courceCreaterTd = $("<td></td>").append(item.creater);
        var courceClassify = $("<td></td>").append(item.classify);
        var courceSubClassify = $("<td></td>").append(item.subClassify);
        var courceIntroduce = $("<td></td>").append(item.introduce);
        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-calendar")).append(" 删除");
        delBtn.attr("delete_cource_id", item.id).attr('id', 'deleteBtn');
        var edit = $("<td></td>").append(delBtn);
        $("<tr></tr>").append(checkTd).append(courceIdTd).append(courceNameTd).append(courceCreaterTd).append(courceClassify).append(courceSubClassify).append(courceIntroduce).append(edit).appendTo("#admin_cource_table tbody");
    });
}

// 删除课程
$(document).on("click", "#deleteBtn", function () {
    var id = $(this).attr("delete_cource_id");
    var ctx = $("meta[name='ctx']").attr("context");
    $.ajax({
        url: ctx + "/user/deleteCource",
        type: "post",
        data: {
            'id': id
        },
        success: function (result) {
            alert(result.msg);
            window.location.reload();
        }
    });
});