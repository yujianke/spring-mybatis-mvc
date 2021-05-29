<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta name="viewport"
    content="width=device-width,
minimum-scale=1.0, maximum-scale=2.0" />
  <head>
    <title>测试</title>
    <style type="text/css">
ul {
    list-style:none;
    margin-top: 15%;
    font-size: smaller
    
}
 
li{
    line-height: 30px;
    color: balck
    
}
.title{
    margin-top: 10%;
    color: #48a94c;
    font-weight: bold;
    font-size: smaller
    
 }
 .hr0{
     width: 100%;
    float: left
 }
 .userInfo{
     margin-left: 90px
 }
</style>
   </head>
  
  <body>
  <div class="title">您的注册信息</div>
  <hr class="hr0"/>
 
  <ul>
	  <li>联系电话<span class="userInfo">${user.username}</span></li>
	  <li>联系<span class="userInfo">${testmodel}</span></li>
</ul>
 
<div class="title">测试</div>
  <hr class="hr0"/>
  </body>
</html>