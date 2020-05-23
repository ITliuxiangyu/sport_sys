var My_tools = {
    Home_url: "http://localhost:8080/webPro2/",
    my_get: function (url , callFn) {
        var xhr = new XMLHttpRequest()
        xhr.open("get" , url , true)
        xhr.send()
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                callFn(xhr.responseText)
            }
        }
    }
}