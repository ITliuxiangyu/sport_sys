(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["editor"],{"37c3":function(t,e,i){},"9eda":function(t,e,i){"use strict";var n=i("37c3"),o=i.n(n);o.a},ae84:function(t,e,i){"use strict";i.r(e);var n=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("div",{staticClass:"crumbs"},[i("el-breadcrumb",{attrs:{separator:"/"}},[i("el-breadcrumb-item",[i("i",{staticClass:"el-icon-lx-calendar"}),t._v(" 表单")]),i("el-breadcrumb-item",[t._v("编辑器")])],1)],1),i("div",{staticClass:"container"},[t._m(0),i("quill-editor",{ref:"myTextEditor",attrs:{options:t.editorOption},model:{value:t.content,callback:function(e){t.content=e},expression:"content"}}),i("el-button",{staticClass:"editor-btn",attrs:{type:"primary"},on:{click:t.submit}},[t._v("提交")])],1)])},o=[function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"plugins-tips"},[t._v("\n            Vue-Quill-Editor：基于Quill、适用于Vue2的富文本编辑器。\n            访问地址："),i("a",{attrs:{href:"https://github.com/surmon-china/vue-quill-editor",target:"_blank"}},[t._v("vue-quill-editor")])])}],r=(i("121a"),i("7e41"),i("96be"),i("b881")),a={name:"editor",data:function(){return{content:"",editorOption:{placeholder:"Hello World"}}},components:{quillEditor:r["quillEditor"]},methods:{onEditorChange:function(t){t.editor;var e=t.html;t.text;this.content=e},submit:function(){console.log(this.content),this.$message.success("提交成功！")}}},s=a,c=(i("9eda"),i("e90a")),l=Object(c["a"])(s,n,o,!1,null,"f6394cb6",null);e["default"]=l.exports}}]);