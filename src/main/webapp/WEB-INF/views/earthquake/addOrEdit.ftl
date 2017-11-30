<@override name="head"> </@override> <@override name="body">
<style>
.divheng{
pading:8px !important;
margin-bottom:8px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>模拟地震事件管理</li>
			<li>
			<#if earthquake.id??>
			修改
			<#else>
			添加
			</#if>
			</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" action="/earthquake/save" id="earthquakeForm" method="POST">                                                  
                   <input type="hidden" id="hiddenid" name="id" value="${earthquake.id}"/>
<div class="alert alert-warning fade in divheng">
	<strong>速报信息</strong>
 </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震唯一标识码</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eventid" 
                            placeholder=" 例如：CC20171113105907 ，CD20171118141241"
                           value="${earthquake.eventid}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">经度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="longitude" value="${earthquake.longitude}" <#if earthquake??>readonly</#if>/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">纬度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="latitude" value="${earthquake.latitude}" <#if earthquake??>readonly</#if>/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震等级</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control"
                           placeholder="必填"
                            name="magnitude" id="magnitude" value="${earthquake.magnitude}" <#if earthquake??>readonly</#if>/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">发震时刻</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqtime" id="eqtime"
                            value="${earthquake.eqdate }" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">震源深度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="depth" value="${earthquake.depth}" <#if earthquake??>readonly</#if>/>
                       </div>
                   </div>
<div class="alert alert-warning fade in divheng">
     <strong>灾情信息</strong>
 </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
                           <button type="button" class="btn btn-primary" onclick="save()">保存</button>
                           <button type="button" class="btn btn-danger" onclick="gohistory()">返回</button>
                       </div>
                   </div>
               </form>
           </div>
       </section>
	</div>
</div>

<script type="text/javascript">
function gohistory(){
	window.history.go(-1);
}


function save(){
	if($("#eqname").val()==""){
		alert("请输入地震名称！");
		return false;
	}
	if($("#magnitude").val()==""){
		alert("请输入地震等级！");
		return false;
	}
	if(isNaN($("#magnitude").val())){//必须是数字
   		alert("震级只能填数字");
   	    return false;
   	}
	if($("#area").val()=="非华北" && $("#responseid").val()==""){
		alert("请选择响应等级");
		return false;
	}
	var rid=$("#responseid").val();
	var id = $("#hiddenid").val();
	//新增
	if(id==null || id==''){
		$.ajax({ 
            type: "POST",
            url:"/earthquake/savenew",
            data:$('#earthquakeForm').serialize(),// 你的formid
            async: false,
            success: function(data) {
            	$("#hiddenid").val(data);//返回的地震id赋值给id框
            	layer.open({
        			type: 2,
        		    area: ['780px', '561px'],
        		    fix: false, //不固定
        		    title: "出队列表",
        		    maxmin: true,
        		    content: '/earthquake/ruleoutteam?id='+data+"&rid="+rid
        		}); 
            }
		});
	}else{
		
		 layer.open({
			type: 2,
		    area: ['780px', '561px'],
		    fix: false, //不固定
		    title: "出队列表",
		    maxmin: true,
		    content: '/earthquake/ruleoutteam?id='+id+"&rid="+rid
		}); 
		
		/* $.ajax({  
	         type : "POST",  //提交方式  
	         url : "/earthquake/valCompany",//判断是否已经安排了出队
	         data:$('#earthquakeForm').serialize(),// 你的formid
	         success : function(result) {//返回数据根据结果进行相应的处理  
	         	if(result=="success"){
	         		layer.open({
	        			type: 2,
	        		    area: ['780px', '561px'],
	        		    fix: false, //不固定
	        		    title: "出队列表",
	        		    maxmin: true,
	        		    content: '/earthquake/ruleoutteam?id='+id+"&rid="+rid
	        		}); 
	         	}else{
	         		alert("已确定出队单位，请在出队管理界面查看！");
	         		window.location.href="/earthquake/list";
	         	}
	         }
	     }); */
	}
	
	// $("#earthquakeForm").submit();
}
	
	
$(document).on("change",'select#area',function(){
	var val = $(this).val();
	if(val=="华北"){
		$("#responddiv").hide();
	}else{
		$("#responddiv").show();
	}
});
$(document).ready(function(){
	var val = $("#area").val();
	if(val=="华北"){
		$("#responddiv").hide();
	}else{
		$("#responddiv").show();
	}
});
</script>
</@override> <@extends name="/base/base.ftl"/>
