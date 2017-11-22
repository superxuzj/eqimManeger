<@override name="head"> </@override> <@override name="body">

<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>成员管理</li>
			<li>成员详情</li>
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
                           <input type="text" class="form-control" name="id" value="${user.id}"/>
                       </div>
                   </div>
                  <div class="form-group">
                       <label class="col-lg-2 control-label">姓名</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" value="${user.name}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">职责</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="profession" value="${user.profession}" />
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">职务</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="job" value="${user.job}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">单位</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="province" value="${user.company}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">手机</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="location" value="${user.phone}"/>
                       </div>
                   </div>
                   
                    <div class="form-group">
                       <label class="col-lg-2 control-label">是否接收短信</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="ismessage">
                       			 <option value="1" <#if user.ismessage=='1' >selected</#if> >是</option>
                                 <option value="2"  <#if user.ismessage=='2' >selected</#if> >否</option>
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
