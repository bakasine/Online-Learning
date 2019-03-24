function validUsername(username) {

    //用户名正则，6到16位（字母，数字，下划线，减号）
    var regex = /^[a-zA-Z0-9_-]{6,16}$/;
    return regex.test(username);
}

function validPassword(password) {
    var regex = /^[a-zA-Z0-9@#$%^&*_-]{6,16}$/;
    return regex.test(password);
}

function validWechat(wechat) {
    var regex = /^[a-zA-Z0-9_-]{3,16}$/;
    return regex.test(wechat);
}

function validSectionName(ele) {

    return ele.length >= 1;
}

function validSort(ele) {

    return !isNaN(ele) && ele > 0;
}

function validImage(ele) {
    var ext = ele.substring(ele.lastIndexOf("."));
    ext = ext.toLowerCase();
    if (ext == ".png" || ext == ".jpg") return true;
    return false;
}

function validVideo(ele) {
    var ext = ele.substring(ele.lastIndexOf("."));
    ext = ext.toLowerCase();
    if (ext == ".mp4" || ext == ".avi") return true;
    return false;
}