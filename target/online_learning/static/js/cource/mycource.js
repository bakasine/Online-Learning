function build_table(result) {
    $("#cource_table tbody").empty();
    var list = result.list;
    $.each(list, function (index, item) {
        var checkTd = $("<td><input type='checkbox' class='check_id'/></td>");
        var courceIdTd = $("<td></td>").append(item.id);
        var courceNameTd = $("<td></td>").append(item.name);
        var courceClassify = $("<td></td>").append(item.classify);
        var courceSubClassify = $("<td></td>").append(item.subClassify);
        var courceIntroduce = $("<td></td>").append(item.introduce);
        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append(" 添加章节");
        editBtn.attr("add_section_id", item.id).attr('id', 'sectionBtn');
        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-calendar")).append(" 删除");
        delBtn.attr("delete_cource_id", item.id).attr('id', 'deleteBtn');
        var edit = $("<td></td>").append(editBtn).append(" ").append(delBtn);
        $("<tr></tr>").append(checkTd).append(courceIdTd).append(courceNameTd).append(courceClassify).append(courceSubClassify).append(courceIntroduce).append(edit).appendTo("#cource_table tbody");
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

// 添加章节
$(document).on("click", "#sectionBtn", function () {
    var courceId = $(this).attr("add_section_id");
    var ctx = $("meta[name='ctx']").attr("context");
    $.ajax({
        url: ctx + "/user/setCourceId",
        type: "post",
        data: {
            'courceId': courceId
        },
        success: function (result) {
            window.location.href = ctx + "/user/toAddSection";
        }
    });
});