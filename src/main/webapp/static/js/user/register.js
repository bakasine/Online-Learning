function doRegister() {

    var ctx = $("meta[name='ctx']").attr("context");

    var username = $('#username').val();
    if (!validUsername(username)) {
        alert("用户名必须6到16位，可以包含字母，数字，下划线，减号");
        return;
    }

    var password = $('#password').val();

    if (!validPassword(password)) {
        alert("密码必须6到16位，可以包含符号，字母，数字");
        return;
    }
    var repassword = $("#repassword").val();
    if (repassword != password) {
        alert("两次密码必须一致");
        return;
    }

    var data = $('#register-form').serialize();

    $.ajax({
        url: ctx + "/user/doRegister",
        type: "post",
        data: data,
        dataType: "json",
        success: function (result) {
            if (result.status != 0) {
                alert(result.msg);
                window.location.href = ctx + "/";
            } else {
                console.log(result);
                alert("失败"+result.msg);
                window.location.href = ctx + "/user/register";
            }
        }
    });
}