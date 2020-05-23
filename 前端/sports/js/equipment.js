
$(document).ready(function () {
  common.activeItem(2);  // 激活
})

// 设置内容标题
var setHeadTil = function (index) {
  var msg = "篮球";
  if (index === 0) {
    msg = "篮球";
    return msg;
  }
  if (index === 1) {
    msg = "羽毛球";
    return msg;
  }
  if (index === 2) {
    msg = "乒乓球";
    return msg;
  }
  if (index === 3) {
    msg = "网球";
    return msg;
  }
};




var layer = layui.layer;
// var form = layui.form;
var rent_layer  = ''

// 租借器材
$('#rent_btn').click(function () { 
  console.log(activeIndex);
  // 出现弹窗
  rent_layer =  layer.open({
    type: 1, 
    title :'租借信息',
    content:  $('#rent-form-box')
  });

  $(".rent_name_input").val(qicai_list[activeIndex].name)

 })

// 提交租借数据
 form.on('submit(rent)', function(data){
  console.log(activeIndex);
  console.log(data.field);
  console.log(qicai_list[activeIndex])
  console.log(My_tools.Home_url)
  // 
  var user_info = JSON.parse(localStorage.getItem("userinfo"))
  console.log(user_info)

  // String equip_id = request.getParameter("equip_id");
	// 	String equip_name = request.getParameter("equip_name");
	// 	String equip_num = request.getParameter("equip_num");
	// 	String user_name = request.getParameter("user_name");
	// 	String user_id = request.getParameter("user_id");
	// 	String caozuo = request.getParameter("caozuo");

  // InsertZu
  $.ajax({
    type: "POST",
    url: My_tools.Home_url + "InsertZu" , 
    data: {
      equip_id: qicai_list[activeIndex].idt_equip , 
      equip_name: qicai_list[activeIndex].name , 
      equip_num: data.field.equip_num , 
      user_name: user_info.username , 
      user_id: user_info.idt_user, 
      caozuo: "租借" 
    },
    success: function(res){
      console.log("租借成功成功")
      console.log(res)
      qicai_list[activeIndex].num = (qicai_list[activeIndex].num - 0) - (data.field.equip_num - 0)
      $(".eq_card_counts").text((qicai_list[activeIndex].num))
    }
 });


  layer.close(rent_layer);
  return false; //阻止表单跳转
});





// 192.168.61.161:8080