function toUpload() {
    var ctx = $("meta[name='ctx']").attr("context");
    window.location.href = ctx + "/user/toUpload";
}

function doUpload() {
    var ctx = $("meta[name='ctx']").attr("context");
    var data = $("#cource-info").serialize();
    $.ajax({
        url: ctx + "/user/doUpload",
        type: "post",
        data: data,
        dataType: "json",
        success: function (result) {
            alert(result.msg);
        }
    });
}

$(function () {
   $('#classify_select').change(function () {
       var ctx = $("meta[name='ctx']").attr("context");
       var classify = $('#classify_select').val();
       $.ajax({
           url: ctx + "/user/getCourceClassify",
           type: 'post',
           data: {
               'classify': classify
           },
           success: function (result) {
               $('#subClassify').empty();
               var list = result.list;
               $.each(list, function (index, item) {
                   $('#subClassify').append("<option value='" + item.courceCode + "'>" + item.courceName + "</option>")
               })
           }
       });
   });
});