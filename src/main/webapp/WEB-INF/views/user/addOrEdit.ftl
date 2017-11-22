<@override name="head"> </@override> <@override name="body">
<style>
label{
margin-left:10px;
width:60%;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a>
			</li>
			<li>成员管理</li>
			<li>
			<#if company.id??>
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
               <form class="form-horizontal" action="/user/save" id="userForm" method="POST">                                                  
                   <input type="hidden" id="hiddenid" name="id" value="${user.id}"/>
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
                           <select class="form-control m-bot15" name="cid">
                       		<#list companyList as company>
                       			 <option value="${company.id }" <#if company.id==user.cid>selected </#if>>${company.name }</option>
                       			 </#list>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">手机</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="phone" value="${user.phone}"/>
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
		$("#userForm").submit();
	}
	
	
	
</script>
</@override> <@extends name="/base/base.ftl"/>
