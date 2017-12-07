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
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqname" id="eqname"
                           value="${earthquake.eqname}" <#if earthquake??>readonly</#if> />
                       </div>
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
                           <input type="text" class="form-control" name="longitude" id="longitude"
                            placeholder="必填"
                            value="${earthquake.longitude}" <#if earthquake??>readonly</#if>/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">纬度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="latitude" id="latitude"
                            placeholder="必填"
                            value="${earthquake.latitude}" <#if earthquake??>readonly</#if>/>
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
                           <input type="text" class="form-control" name="eqtime" id="eqtime" <#if earthquake??>readonly</#if>
                            value="${earthquake.eqtime?string('yyyy-MM-dd HH:mm:ss') }" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
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
                       <label class="col-lg-3 control-label">震中100公里范围内</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="hazardcount" 
                           placeholder="发生5.0级以上地震共1次。最大地震是2004年11月21日在重庆市忠县发生的5.1级地震。"
                           value="${earthquake.hazardcount}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-3 control-label">震区未来3天气象信息</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="weather" 
                           placeholder="周五，阴，14 ~ 9℃，周六，多云，15 ~ 9℃，周日，多云，17 ~ 10℃。"
                           value="${earthquake.weather}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-3 control-label">震中20公里范围内</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="towncount" 
                           placeholder="有17个乡（镇、街道）,有0个村"
                           value="${earthquake.towncount}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-3 control-label">震中50公里范围内</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="peoplesum" 
                            placeholder="的人口密度约150人/平方公里,人口约120万人。"
                           value="${earthquake.peoplesum}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-3 control-label">震中10公里海拔</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="demaver" 
                           value="${earthquake.demaver}" <#if earthquake??>readonly</#if> />
                       </div>
                   </div>
<div class="alert alert-warning fade in divheng">
     <strong>单位信息</strong>
 </div>
					<div class="form-group">
                       <label class="col-lg-2 control-label">选择单位</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="cid" id="cid">
                       		<#list companylist as company>
                       			 <option value="${company.id }"  <#if company.id==22>selected</#if>>${company.name }</option>
                       		</#list>
                            </select>
                       </div>
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
	
	if($("#longitude").val()==""){
		alert("请输入经度！");
		return false;
	}
	if(isNaN($("#longitude").val())){//必须是数字
   		alert("经度只能填数字");
   	    return false;
   	}
	if($("#latitude").val()==""){
		alert("请输入纬度！");
		return false;
	}
	if(isNaN($("#latitude").val())){//必须是数字
   		alert("纬度只能填数字");
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
	
	$("#earthquakeForm").submit();
}
	

</script>
</@override> <@extends name="/base/base.ftl"/>
