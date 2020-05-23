// 通用方法
var common = {
  //  激活指定导航项
  activeItem: function (index) {
    // console.log($('#nav_wrap > li').eq(index))
    $("#nav_wrap > li")
      .eq(index)
      .addClass("nav_item_active")
      .siblings()
      .removeClass("nav_item_active");
  },
  // 激活指定菜单
  activeMenuItem: function (ele, index, className) {
    $("#" + ele + " > li")
      .eq(index)
      .removeClass(className)
      .addClass(className)
      .siblings()
      .removeClass(className);
  },
  // 用户是否登录
  islogin: function () {
    var islogin = localStorage.getItem("islogin");
    var userinfo = JSON.parse(localStorage.getItem("userinfo"));
    if (islogin) {
      // 已登录
      $("#login_btn").hide();
      $("#user_box").show();
      $(".ts-wrap .username").text(userinfo.name);
    }else{
      $("#login_btn").show();
      $("#user_box").hide();
      
      if (location.href.indexOf("/index.html") == -1) {
        alert("请您登录")
        setTimeout(() => {
          // location.href = "/sports/index.html"
          location.href = "/webPro2/static/sports/index.html"
        }, 100);
        
      }
      
    }
  },
};

// layui内置模块
var layer = layui.layer;
var form = layui.form;

//
common.islogin();

// 登录
var login_layer = "",
  reg_layer = "";
$(document).on("click", ".login_btn", function () {
  login_layer = layer.open({
    type: 1,
    area: ["400px"],
    title: false,
    content:
      '<form class="layui-form   login_box" action="" > ' +
      '<h2 class="til">登录</h2>' +
      ' <div class="layui-form-item">' +
      '<label class="layui-form-label">账号</label>' +
      ' <div class="layui-input-inline">' +
      ' <input type="text" name="count" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">' +
      "</div>" +
      " </div>" +
      '<div class="layui-form-item">' +
      '<label class="layui-form-label">密码框</label>' +
      '<div class="layui-input-inline">' +
      '<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">' +
      "</div>" +
      " </div>" +
      '<div class="layui-form-item" style="text-align: right;">' +
      '<span class="reg_btn"  style="color:#014999;  cursor: pointer; ">注册账号</span>' +
      "</div>" +
      ' <div class="layui-form-item">' +
      ' <div class="layui-input-block" style="margin: 20px 40px;">' +
      ' <button style="width:100%;" class="layui-btn layui-btn-normal  layui-btn-lg" lay-submit lay-filter="login">登录</button>' +
      "</div>" +
      " </div>" +
      "  </form>",
  });
});

//登录提交
form.on("submit(login)", function (data) {
  console.log(data.field);

  $.ajax({
    type: "POST",
    url: My_tools.Home_url + "Login" , 
    data: {
      account: data.field.count , 
      password: data.field.password
    },
    success: function(res){
      res = JSON.parse(res)
      if (res.err == 0) {

        console.log("登录成功")
        console.log(res)
        if (res.user.type == "0" || res.user.type == 0) {
          layer.msg("不能用管理员身份进行登录" , {icon: 2})
        } else {
          layer.msg("登陆成功", { icon: 1 }, function () {
            //
            layer.close(login_layer);
        
            // 记录用户名
            localStorage.setItem("islogin", true);
            localStorage.setItem(
              "userinfo",
              JSON.stringify(res.user)
            );
        
            // 显示用户信息
            $("#login_btn").hide();
            $("#user_box").show();
            $(".ts-wrap .username").text(data.field.name);
          });
        }
        
      } else {
        console.log("登录失败")
        layer.msg("登录失败", { icon: 2 }, function () {
          
        });
      }
    }
 });

  // 验证数据

  // 发送请求
  

  return false;
});

function prepare_regist_form(title){
  layer.close(login_layer);

  var content_str = ' <form class="layui-form   reg_box" action="" > ' +
  '<h2 class="til">' + title + '</h2>' +
  `
  <div class="layui-form-item">
  <label class="layui-form-label">昵称</label>
  <div class="layui-input-inline">
  <input type="text" name="user_name" required  lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
  </div>
  </div>
  `+
  '<div class="layui-form-item">' +
  '<label class="layui-form-label">账号</label>' +
  '<div class="layui-input-inline">' +
  '<input type="text" name="title" required  lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">' +
  " </div>" +
  " </div>" +
  ' <div class="layui-form-item">' +
  '<label class="layui-form-label">密码框</label>' +
  '<div class="layui-input-inline">' +
  '<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">' +
  "</div>" +
  "</div>" +
  '<div class="layui-form-item">' +
  '<label class="layui-form-label">性别</label>' +
  '<div class="layui-input-block">' +
  '<input type="radio" name="sex" value="男" title="男">' +
  '<input type="radio" name="sex" value="女" title="女" checked>' +
  " </div>" +
  " </div>" +
  '<div class="layui-form-item">' +
  '<label class="layui-form-label">出生日期</label>' +
  ' <div class="layui-input-inline">' +
  ' <input type="date" name="birthday" required  lay-verify="required" placeholder="请输入出生日期" autocomplete="off" class="layui-input">' +
  "</div>" +
  "</div>" +
  '<div class="layui-form-item">' +
  '<label class="layui-form-label">电话</label>' +
  '<div class="layui-input-inline">' +
  '<input type="text" name="phone"   required lay-verify="requiredphone" placeholder="请输入电话" autocomplete="off" class="layui-input">' +
  "</div>" +
  " </div>" +
  '<div class="layui-form-item">' +
  '<div class="layui-input-block" style="margin: 20px 40px;">' +
  '<button style="width:100%;" class="layui-btn layui-btn-normal  layui-btn-lg" lay-submit lay-filter="reg">注册</button>' +
  "</div>" +
  "</div>" +
  "</form>"

  if (title == "个人信息") {
    var user_info = JSON.parse(localStorage.getItem("userinfo"))
    console.log("用户信息")
    console.log(user_info)
    content_str = `<form class="layui-form   reg_box" action="" >` +
  '<h2 class="til">' + title + '</h2>' +
  `
  <div class="layui-form-item">
  <label class="layui-form-label">昵称</label>
  <div class="layui-input-inline">
  <input type="text" name="user_name" required  lay-verify="required" value="` + user_info.username + `" autocomplete="off" class="layui-input">
  </div>
  </div>
  `+
  `<div class="layui-form-item">
  <label class="layui-form-label">原密码</label>
  <div class="layui-input-inline">
  <input type="password" name="password" placeholder="请输入原密码" autocomplete="off" class="layui-input">
  </div>
  </div>` 
  
  +

  `<div class="layui-form-item">
  <label class="layui-form-label">新密码</label>
  <div class="layui-input-inline">
  <input type="password" name="newpwd" placeholder="请输入新密码" autocomplete="off" class="layui-input">
  </div>
  </div>`

  +

  `<div class="layui-form-item">
  <label class="layui-form-label">确认密码</label>
  <div class="layui-input-inline">
  <input type="password" name="confirmpwd" placeholder="请确认新密码" autocomplete="off" class="layui-input">
  </div>
  </div>`

  +

  `<div class="layui-form-item">
  <label class="layui-form-label">性别</label>
  <div class="layui-input-block">
  <input type="radio" name="sex" value="男" title="男"` + (user_info.gender == "男" ? "checked" : "") + `>
  <input type="radio" name="sex" value="女" title="女"` + (user_info.gender == "女" ? "checked" : "") + `>
  </div>
  </div>`
  
  +

  `<div class="layui-form-item">
  <label class="layui-form-label">电话</label>
  <div class="layui-input-inline">
  <input type="text" name="tel"   required lay-verify="requiredphone" value="` + user_info.tel + `" autocomplete="off" class="layui-input">
  </div>
  </div>` 
  
  +

  '<div class="layui-form-item">' +
  '<div class="layui-input-block" style="margin: 20px 40px;">' +
  '<button style="width:100%;" class="layui-btn layui-btn-normal  layui-btn-lg" lay-submit lay-filter="modify">修改</button>' +
  "</div>" +
  "</div>" +
  "</form>"
  }

  reg_layer = layer.open({
    type: 1,
    area: ["400px"],
    title: false,
    content: content_str,
    success: function () {
      form.render(); //更新全部
    },
  });
}

// 注册页面
$(document).on("click", ".reg_btn", function () {
  prepare_regist_form("注册")
});

$("#user_box img").click(function () {
  prepare_regist_form("个人信息")
})


//监听 修改
form.on("submit(modify)", function (data) {
  console.log("要修改了...")
  event.preventDefault()

  console.log(data.field);
  var user_info = JSON.parse(localStorage.getItem("userinfo"))
  if (data.field.password.length > 0) {
    if (data.field.password != user_info.password) {
      layer.msg("原密码输入错误", { icon: 2 });
      return false
    } else {
      if (data.field.newpwd.length <= 0) {
        layer.msg("请输入新密码", { icon: 2 });
        return false
      } else if (data.field.newpwd != data.field.confirmpwd) {
        layer.msg("两次密码输入不一样", { icon: 2 });
        return false
      } else {
        var modify_data = {
          user_id: user_info.idt_user , 
          account: user_info.account , 
          password: data.field.confirmpwd.length > 0 ? data.field.confirmpwd : user_info.password,
          user_name: data.field.user_name,
          gender: data.field.sex,
          birthday: user_info.birthday,
          tel: data.field.tel , 
          type: user_info.type
        }
        $.ajax({
            type: "POST",
            url: My_tools.Home_url + "ModifyUser" , 
            data: modify_data,
            success: function(res){
              user_info.account = modify_data.account
              user_info.birthday = modify_data.birthday
              user_info.gender = modify_data.gender
              user_info.idt_user = modify_data.user_id
              user_info.password = modify_data.password
              user_info.tel = modify_data.tel
              user_info.type = modify_data.type
              user_info.username = modify_data.user_name
              localStorage.setItem("userinfo" , JSON.stringify(user_info))
            }
        });
        // return false
      }
    }
  } else {
    var modify_data = {
      user_id: user_info.idt_user , 
      account: user_info.account , 
      password: data.field.confirmpwd.length > 0 ? data.field.confirmpwd : user_info.password,
      user_name: data.field.user_name,
      gender: data.field.sex,
      birthday: user_info.birthday,
      tel: data.field.tel , 
      type: user_info.type
    }
    $.ajax({
        type: "POST",
        url: My_tools.Home_url + "ModifyUser" , 
        data: modify_data,
        success: function(res){
          layer.msg("修改成功", { icon: 1 });
          user_info.account = modify_data.account
          user_info.birthday = modify_data.birthday
          user_info.gender = modify_data.gender
          user_info.idt_user = modify_data.user_id
          user_info.password = modify_data.password
          user_info.tel = modify_data.tel
          user_info.type = modify_data.type
          user_info.username = modify_data.user_name
          localStorage.setItem("userinfo" , JSON.stringify(user_info))
        }
    });
  }
  

  
  

});



//监听提交
form.on("submit(reg)", function (data) {
  console.log(data.field);
  

  $.ajax({
      type: "POST",
      url: My_tools.Home_url + "Regist" , 
      data: {
        account: data.field.title , 
        password: data.field.password,
        user_name: data.field.user_name,
        gender: data.field.sex,
        birthday: data.field.birthday,
        tel: data.field.phone
      },
      success: function(res){
        layer.msg("注册成功", { icon: 1 });
        
      }
  });

  // ajax

  

  return false;
});

// 推出登录
$("#userout").click(function () {
  // 显示用户信息
  $("#login_btn").show();
  $("#user_box").hide();
  localStorage.removeItem("islogin");
  localStorage.removeItem("userinfo");
});





// 我的预约
$("#userOrder").click(function () {
  var user_info = JSON.parse(localStorage.getItem("userinfo"))
  $.ajax({
    type: "POST",
    url: My_tools.Home_url + "GetYueByUserid" , 
    data:{
      user_id: user_info.idt_user
    },
    success: function(res){
      res = JSON.parse(res)
      var tr_str = ""
      console.log("预约记录....")
      console.log(res)
      for (var i = 0; i < res.length; i++) {
        tr_str += `
            <tr>
                <td>` + res[i].area_name + `</td>
                <td>` + res[i].area_bianhao + `</td>
                <td>` + res[i].yue_time + `</td>
                <td><button yue_id="` + res[i].idt_yue_log + `" type="button" class="cancel_btn layui-btn layui-btn-xs">取消</button></td>
            </tr>
        `
      }
      tr_str = `
        <table border="1" class="layui-table">
                <thead>
                  <th>场地名</th>
                  <th>场地编号</th>
                  <th>预约时间</th>
                  <th>操作</th>
                </thead>
                <body>`
                  
                + tr_str + 
                  
                `</body>
        </table>
      `
      var yue_layer = layer.open({
          type: 1,
          area: ["400px"],
          title: false,
          content: tr_str , 
          success: function () {
            $(".cancel_btn").click(function () {
              console.log($(this).attr("yue_id"))
              $.ajax({
                  type: "POST",
                  url: My_tools.Home_url + "DeleteYue" ,
                  data: {yue_id: $(this).attr("yue_id")},
                  success: function (res) {
                    console.log("取消成功")
                    window.location.reload()
                  }
              })
            })
          }
      })
    }
 });
  
  
});



// 我的租借
$("#userZujie").click(function () {

  var user_info = JSON.parse(localStorage.getItem("userinfo"))

  $.ajax({
    type: "POST",
    url: My_tools.Home_url + "GetZuByPerson" ,
    data: {
      user_id: user_info.idt_user
    } ,
    success: function(res){
      res = JSON.parse(res)
      var tr_str = ""
      console.log("租借记录....")
      console.log(res)
      for (var i = 0; i < res.length; i++) {
        var is_disable = ""
        if (res[i].caozuo != "租借") {
          is_disable = "layui-btn-disabled"
        }
        tr_str += `
            <tr>
                <td>` + res[i].equip_name + `</td>
                <td>` + res[i].equip_num + `</td>
                <td>` + res[i].user_name + `</td>
                <td class="zu_caozuio">` + res[i].caozuo + `</td>
                <td><button equip_num="` + res[i].equip_num + `" equip_id="` + res[i].equip_id + `" caozuo="` + res[i].caozuo + `" zu_id="` + res[i].idt_zu_log + `" type="button" class="cancel_btn layui-btn layui-btn-xs ` + is_disable + `">退租</button></td>
            </tr>
        `
      }
      tr_str = `
        <table border="1" class="layui-table">
                <thead>
                  <th>设备名</th>
                  <th>数量</th>
                  <th>租借人</th>
                  <th>记录</th>
                  <th>操作</th>
                </thead>
                <body>`
                  
                + tr_str + 
                  
                `</body>
        </table>
      `
      var yue_layer = layer.open({
          type: 1,
          area: ["400px"],
          title: false,
          content: tr_str , 
          success: function () {
            $(".cancel_btn").click(function () {
              var that = this
              console.log($(this).attr("zu_id"))
              $.ajax({
                  type: "POST",
                  url: My_tools.Home_url + "TuiZu" ,
                  data: {
                    zu_id: $(this).attr("zu_id") , 
                    equip_id: $(this).attr("equip_id") , 
                    equip_num: $(this).attr("equip_num") ,
                  },
                  success: function (res) {
                    console.log("退租成功")
                    window.location.reload()
                    
                    // $(that).addClass("layui-btn-disabled")
                    // $(that).parents("tr").find(".zu_caozuio").text("已退租")
                  }
              })
            })
          }
      })
    }
 });
  
  
});
