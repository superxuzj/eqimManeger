<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>单位管理</li>
			<li>单位详情</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" role="form">                                                  
                   <div class="form-group">
                       <label class="col-lg-2 control-label">ID</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="id" value="${earthquake.id}"/>
                       </div>
                   </div>
                  <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eqname" value="${earthquake.eqname}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震唯一标识码</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="eventid" value="${earthquake.eventid}" />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">区域</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="area" value="${earthquake.area}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">省市</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${earthquake.province}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">位置</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="location" value="${earthquake.location}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">地震等级</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="magnitude" value="${earthquake.magnitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">经度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="longitude" value="${earthquake.longitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">纬度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="latitude" value="${earthquake.latitude}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">发震日期</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control"  value="${earthquake.eqdate}">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">发震时刻</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control"  value="${earthquake.eqtime}">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">震源深度</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control"  value="${earthquake.depth}">
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">响应等级</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15">
                                              <option <#if earthquake.responseid==1>selected</#if>>一级响应</option>
                                              <option <#if earthquake.responseid==2>selected</#if>>二级响应</option>
                                          </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <div class="col-lg-offset-2 col-lg-10">
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
</script>

</@override> <@extends name="/base/base.ftl"/>
