function sectionSave() {
    var sectionName = $("#sectionFrom #inputSection").val();
    if (! validSectionName(sectionName)) {
        alert("章节名不合法");
        return ;
    }
    var sectionSort = $("#sectionFrom #inputSort").val();
    if (! validSort(sectionSort)) {
        alert("章节号必须为大于1的数字");
        return ;
    }
    var ctx = $("meta[name='ctx']").attr("context");
    var data = $("#sectionFrom").serialize();
    $.ajax({
        url: ctx + "/user/saveSection",
        type: "post",
        data: data,
        success: function (result) {
            alert("保存成功");
        }
    });
}

$(function () {
        $("#addSubSection").click(function () {
            $('#parentSection').empty();
            var ctx = $("meta[name='ctx']").attr("context");
            var courseId = $("#getId").val();
            $.ajax({
                url: ctx + "/user/getCourceInfo",
                type: "post",
                data: {
                    'courseId': courseId
                },
                success: function (result) {
                    $.each(result.list, function (){
                        var optionTd = $("<option></option>").append(this.name).attr('value', this.id);
                        $('#parentSection').append(optionTd);
                    });
                }
            });
        });
});


function saveSubSection() {
    var subSectionName = $("#subSectionFrom #inputSubSection").val();
    if (! validSectionName(subSectionName)) {
        alert("章节名不合法");
        return ;
    }
    var sectionSort = $("#subSectionFrom #inputSubSort").val();
    if (! validSort(sectionSort)) {
        alert("章节名必须为大于1的数字");
        return ;
    }
    var sectionVideo = $("#subSectionFrom #exampleInputFile").val();
    if (! validVideo(sectionVideo)) {
        alert("必须是AVI或者MP4格式且小于1G的视频");
        return;
    }

    var ctx = $("meta[name='ctx']").attr("context");
    var formData = new FormData(document.getElementById("subSectionFrom"));
    $.ajax({
        url: ctx + "/user/saveSubSection",
        type: 'POST',
        data: formData,
        processData:false,
        contentType:false,
        success: function (data) {
            alert("插入成功");
            $('#myModal').modal('hide');
        },
    });
}
