<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Content</title>
<%@include file="../../../resources.jsp" %>

<style type="text/css">

    .layout-panel { 
		position: static 
	}  

</style>

<script type="text/javascript">

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',title:'North Title',href:'<%=basePath%>/system/loginout/navigation.action'" style="height:75px;background:#eee;"></div>   
    <div id="layout-center" data-options="region:'center',title:'center title',split:true,border:true">
	   	<div id="tabs" class="easyui-tabs">
		  <div title="Home">
	           <div class="cs-home-remark">
	               <p><h1>这里是home</h1>
	               <p><h1>HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME   HOME</h1>
	           </div>
	       </div>
	    </div>
     </div>   
     <div data-options="region:'south',title:'South Title',split:true,border:true" style="height:100px;"></div>
</body>
</html>