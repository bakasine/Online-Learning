function toRegister() {
    // window.location.href="http://baidu.com";
    var ctx = $("meta[name='ctx']").attr("context");
    ctx += "/user/register";

    window.location.href = ctx;
}

function doLogin() {
    var username = $("#username").val();
    var password = $("#password").val();
    /*0记住我 1不记住*/
    var remember = ($("#remember").is(":checked") == true) ? 0 : 1;
    var ctx = $("meta[name='ctx']").attr("context");
    $.ajax({
        url: ctx + "/user/doLogin",
        data: $("#form-login").serialize(),
        type: "post",
        success: function (result) {
            alert(result.msg);
            if (result.status == 0) {
                return ;
            }
            if (result.isAdmin == 0) {

            }
            window.location.href = ctx + "/";
        }
    });
}