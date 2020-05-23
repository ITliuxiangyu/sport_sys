// 设置内容标题
var setHeadTil = function (index) {
  var msg = "篮球场地";
  if (index === 0) {
    msg = "篮球场地";
    return msg;
  }
  if (index === 1) {
    msg = "羽毛球场地";
    return msg;
  }
  if (index === 2) {
    msg = "乒乓球场地";
    return msg;
  }
  if (index === 3) {
    msg = "网球场地";
    return msg;
  }
};


// 模拟场地数据
var placeData = {
  Basketball: {
    name: "篮球场地",
    type: 0,
    imgs: [
      {
        id: 0,
        path: "news1.jpg",
        txt: "篮球场1",
      },
      {
        id: 1,
        path: "news1.jpg",
        txt: "篮球场2",
      },
      {
        id: 2,
        path: "news1.jpg",
        txt: "篮球场3",
      },
      {
        id: 3,
        path: "news1.jpg",
        txt: "篮球场4",
      },
    ],
  },
  Badminton: {
    name: "羽毛球场地",
    type: 1,
    imgs: [
      {
        id: 0,
        path: "news1.jpg",
        txt: "羽毛球场地1",
      },
      {
        id: 1,
        path: "news1.jpg",
        txt: "羽毛球场地2",
      },
      {
        id: 2,
        path: "news1.jpg",
        txt: "羽毛球场地3",
      },
    ],
  },

  TableTennis: {
    name: "乒乓球场地",
    type: 2,
    imgs: [
      {
        id: 0,
        path: "news1.jpg",
        txt: "乒乓球场地1",
      },
      {
        id: 1,
        path: "news1.jpg",
        txt: "乒乓球场地2",
      }

    ],
  },
  Tennis: {
    name: "网球场地",
    type: 3,
    imgs: [
      {
        id: 0,
        path: "news1.jpg",
        txt: "网球场地1",
      }

    ],
  },
};

// 动态插入场地节点
function initplace(data) {
  var htmlStr = '';
  if (data.imgs && Array.isArray(data.imgs)) {
    data.imgs.forEach(function (v) {
      htmlStr += '<div class="place_item">' +
        '<div class="place_item_top">' +
        '<div class="place_item_layer">' +
        '<button type="button" class="layui-btn layui-btn-normal layui-btn-sm" id="order_btn" data-type="' + data.type + '" data-id="' + v.id + '">预约场地</button>' +
        '</div>' +
        '<img class="place_item_img" src="../sources/imgs/' + v.path + '" width="200px" alt="">' +
        ' </div>' +
        '<p class="place_item_txt"><a href="">' + v.txt + '</a></p>' +
        '</div>'
    })

  }
  $('.place_imgs').empty().append(htmlStr);

}




common.activeItem(3); // 激活水平导航

// 默认激活第一个菜单
var activeIndex = 0;
common.activeMenuItem("place_menus", 0, "layui-nav-itemed");
$(".place_content_wrap > .til > span").text(setHeadTil(activeIndex * 1));
// initplace(placeData.Basketball);


// private String idt_area;
// private String img;
// private String is_yue;
// private String yue_person;
// private String yue_time;
// private String title;
// private String bianhao;
var changdi_list = []
var big_data = {}
$.ajax({
  url: My_tools.Home_url + "GetArea" , 
  success: function (res) {
    changdi_list = JSON.parse(res)
    console.log("场地诗句.....")
    console.log(changdi_list)

    changdi_list.forEach(function (item , index) {
      var title = item.title
      if (big_data.hasOwnProperty(title)) {
        
      } else {
        big_data[title] = []
      }
      big_data[title].push(item)
    }) 
    console.log("大数据....")
    console.log(big_data)

    var xxx = ""
    var i = 0
    

    var tmp_side = ``
    

    for (var key in big_data) {
      if (i == 0) {
        xxx = `layui-nav-itemed`
      }
      i++
      tmp_side += `<li class="layui-nav-item ` + xxx + ` "><a href="javascript:;">` + key + `</a></li>`
      xxx = ''
    }
    $(".layui-nav-bar").remove()
    $(".layui-nav").html(tmp_side)

    // renderContentByIndex(0);

    nei_rong_fn(0)
    


  }
})

function nei_rong_fn(index) {
    var item = {} 
    var tmp_i = 0
    var tmp_key = ""
    for (key in big_data) {
      if (tmp_i == index) {
        item = big_data[key]
        tmp_key = key
        break;
      } 
      tmp_i++
    }

    var nei_str = `<h2 class="til"><span>` + tmp_key + `地</span></h2>
    <div class="place_imgs"></div>
    <div class="order_wrap">
        <h2 class="order_til"><span>预约</span></h2>
        <div class="order_box">
          <p class="order_rule">预约规则：每天8:00 - 18:00接受预约，仅限当天预约。</p>
          <div class="layui-btn-container" id="order"></div>
        </div>
    </div>
    `
    $(".place_content_wrap").empty().append($(nei_str))
    nei_str = ""
    for (var i = 0; i < item.length; i++) {
      console.log("0000")

      nei_str += `<div class="place_item">
      <div class="place_item_top">
      <div class="place_item_layer">
      <button type="button" 
        class="layui-btn layui-btn-normal layui-btn-sm" 
        id="order_btn" 
        changdi_id="` + item[i].idt_area + `" data-type="` + item[i].title + `" data-id="` + item[i].bianhao + `">预约场地</button>
      </div>
      <img class="place_item_img" src="../sources/imgs/news1.jpg" width="200px" alt="">
       </div>
       <p class="place_item_txt">
            <a href="">` + item[i].title + item[i].bianhao + `</a></p>
       </div>'`
    }

    $(".place_imgs").empty().append($(nei_str))
}



    




//器材管理菜单点击事件
$("#place_menus").click(function (event) {
  var nodeName = event.target.nodeName;
  if (nodeName === "A") {
    var index = $(event.target).parent().index();
    activeIndex = index;

    common.activeMenuItem("place_menus", index, "layui-nav-itemed");

    // 动态标题
    $(".place_content_wrap > .til > span").text(setHeadTil(index * 1));

    // 动态插入对应节点
    nei_rong_fn(index)
    // 每次切换菜单要保证预约按钮列表关闭状态
    $(".order_wrap").hide();

  }
});


// 显示预约按钮列表
var placeType = 0, placeIndex = 0;
$(document).on('click', "#order_btn", function (event) {
  placeType = $(this).attr('data-type')
  placeIndex = $(this).attr('data-id')
  changdi_id = $(this).attr('changdi_id')
  console.log(placeType , placeIndex , changdi_id)

  var yue_str = ""
  var chandi_info = ""

  // 查询场地预约记录
  $.ajax({
    url: My_tools.Home_url + "GetYue" , 
    success: function (res) {
      res = JSON.parse(res)
      var time_arr = ["8:00-9:00" , "9:00-10:00" , "10:00-11:00" , "11:00-12:00" , "12:00-13:00" , "13:00-14:00" , "14:00-15:00" , "15:00-16:00" , "16:00-17:00" , "17:00-18:00"]

      for (var i = 0; i < time_arr.length; i++) {
        var xxx = ""
        for (var j = 0; j < res.length; j++) {
          if (res[j].area_id == changdi_id && res[j].yue_time == time_arr[i]) {
            xxx = "layui-btn-disabled"
            break
          }
        }
        
        yue_str += `<button type="button" bianhao="` + placeIndex + `" title="` + placeType + `" changdi_id="` + changdi_id + `" class="time_btn layui-btn  layui-btn-sm  layui-btn-normal ` + xxx + `" data-index="0">` + time_arr[i] + `</button>`
      }

      $(".order_wrap").empty().append(yue_str)

      $(".order_wrap").show();


      // 获取当前场地预约状态

  $(".time_btn").click(function () {
    console.log("00000")
    var that = this
    

    if ($(this).hasClass('layui-btn-disabled')) {
      // 已经被预约
      layer.msg('当前时间段已被预约了', {
        icon: 2,
        time: 1000 //2秒关闭（如果不配置，默认是3秒）
      }, function () {
        //do something
      });
  
    } else {
      // 可以预约
      var time = $(this).text()
      var title = $(this).attr("title")
      var changdi_id = $(this).attr("changdi_id")
      var bianhao = $(this).attr("bianhao")
      
      var user_info = JSON.parse(localStorage.getItem("userinfo"))

      $.ajax({
        type: "POST",
        url: My_tools.Home_url + "AddYue" , 
        data: {
          user_id: user_info.idt_user , 
          yue_time: time , 
          area_id: changdi_id , 
          yue_type: "2" , 
          area_name: title, 
          area_bianhao: bianhao 
        },
        success: function(res){
          console.log("修改信息成功")
        }
     });


  
      // 提交预约信息， placeType  placeIndex  ， time
  
      layer.msg('预约成功', {
        icon: 1,
        time: 1000 //2秒关闭（如果不配置，默认是3秒）
      }, function () {
        $(that).addClass('layui-btn-disabled');
      });
  
  
    }
  })

    }
  })

  

  
  

});



// 预约
$("#order").click(function (event) {
  


  


});



