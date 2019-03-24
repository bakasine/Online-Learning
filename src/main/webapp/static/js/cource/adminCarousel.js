$(function () {
    var ctx = $("meta[name='ctx']").attr("context");

    $.ajax({
        url: ctx + "/carousel/getCarousel",
        type: "post",
        success: function (data) {
            build_table(data);
        }
    });
});

function build_table(result) {
    $("#admin_carousel_table tbody").empty();
    var list = result.list;
    $.each(list, function (index, item) {
        var carouselIdTd = $("<td></td>").append(item.id);
        var carouselNameTd = $("<td></td>").append(item.name);
        var carouselImg = $("<td></td>").append(item.picture);
        var carouselUrl = $("<td></td>").append(item.url);
        var carouselEnable = $("<td></td>").append(item.enable == true ? "已加入" : "未加入");
        var changeBtn = $("<button></button>").addClass("btn btn-success btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-calendar")).append(" 修改播放状态");
        changeBtn.attr("carousel_id", item.id).attr('id', 'changeBtn').attr('enable', item.enable);
        var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm").append($("<span></span>").addClass("glyphicon glyphicon-calendar")).append(" 删除");
        delBtn.attr("delete_carousel_id", item.id).attr('id', 'deleteBtn');
        var edit = $("<td></td>").append(changeBtn).append(" ").append(delBtn);
        $("<tr></tr>").append(carouselIdTd).append(carouselNameTd).append(carouselImg).append(carouselUrl).append(carouselEnable).append(edit).appendTo("#admin_carousel_table tbody");
    });
}

$(function () {
    $("#addCarousel").click(function () {
        $('#carouselUrl').empty();
        var ctx = $("meta[name='ctx']").attr("context");
        $.ajax({
            url: ctx + "/cource/getAllCource",
            type: "post",
            success: function (result) {
                $.each(result.list, function (){
                    var optionTd = $("<option></option>").append(this.name).attr('value', ctx + "/cource/courceInfo?id=" + this.id);
                    $('#carouselUrl').append(optionTd);
                });
            }
        });
    });

    $(document).on("click", "#changeBtn", function () {
        var id = $(this).attr("carousel_id");
        var enable = $(this).attr("enable");
        var ctx = $("meta[name='ctx']").attr("context");
        $.ajax({
            url: ctx + "/carousel/changeEnable",
            type: "post",
            data: {
                'id': id,
                'enable': enable
            },
            success: function (result) {
                alert("修改成功");
                window.location.reload();
            }
        });
    });

    $(document).on("click", "#deleteBtn", function () {
        var id = $(this).attr("delete_carousel_id");
        var ctx = $("meta[name='ctx']").attr("context");
        $.ajax({
            url: ctx + "/carousel/deleteCarousel",
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
});

function saveCarousel() {
    var carouselImg = $("#carouselFrom #carouselImg").val();
    if (! validImage(carouselImg)) {
        alert("必须是PNG或者JPG格式");
        return;
    }
    var ctx = $("meta[name='ctx']").attr("context");
    var formData = new FormData(document.getElementById("carouselFrom"));
    $.ajax({
        url: ctx + "/carousel/addCarousel",
        type: 'POST',
        data: formData,
        processData:false,
        contentType:false,
        success: function (data) {
            alert("插入成功");
            $('#myModal').modal('hide');
            window.location.reload();
        },
    });
}