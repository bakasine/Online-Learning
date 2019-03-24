

function toMain() {
    var ctx = $("meta[name='ctx']").attr("context");
    ctx += "/home";
    window.location.href = ctx;
}

function doChange() {
    var nickname = $("#inputNickname").val();

    if (nickname.length > 9 || nickname.length < 1) {
        alert("昵称不能超过9位且不能少于1位");
        return;
    }
    var wechat = $("#inputWechat").val();
    var ctx = $("meta[name='ctx']").attr("context");
    var data = $("#info-form").serialize();

    $.ajax({
        url: ctx + "/user/changeInfo",
        type: "post",
        data: data,
        success: function (result) {
            alert("修改成功");
            window.location.reload();
        }
        
    });

}