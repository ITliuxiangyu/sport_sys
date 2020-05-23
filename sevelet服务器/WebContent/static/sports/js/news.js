// 新闻，详情页js
common.activeItem(1);

// 获取新闻id
console.log(location)
var getpath = location.pathname.split('/');
var filename = getpath.pop()
console.log(filename)
  if(filename == 'news.html'){
    console.log(1)

  }else if(filename == 'news-detail.html'){
   
    var getsearchStr = location.search.split('?')[1] ;
    var id = getsearchStr.split('=')[1];

console.log(id)
  }