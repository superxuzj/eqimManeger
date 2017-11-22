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
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" id="name" value="${company.name}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联络人</label>
                       <div class="col-lg-6">
                          <select class="form-control m-bot15" name="liaisonid">
                       		<#list userList as user>
                       			 <option value="${user.id }" <#if company.liaisonid==user.id>selected </#if>>${user.name }</option>
                       			 </#list>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联系人</label>
                       <div class="col-lg-6">
                         <select class="form-control m-bot15" name="contactid">
                       		<#list userList as user>
                       			 <option value="${user.id }" <#if company.contactid==user.id>selected </#if>>${user.name }</option>
                       			 </#list>
                            </select>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">短信震级</label>
                       <div class="col-lg-6">
                           <#list smscodelist as sms>
                           <label><input name="smscode" type="checkbox" value="${sms.id }" <#if company.smscode?contains(sms.id?string)>checked="checked" </#if>/>
                           ${sms.name }
                           </label> 
                           </#list>
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">速报信息</label>
                       <div class="col-lg-6">
                      	 <#list quickcodelist as quick>
                          	<label><input name="quickcode" type="checkbox" value="${quick.id }"  <#if company.quickcode?contains(quick.id?string)>checked="checked" </#if>/>${quick.name } </label> 
                          </#list>
                       		
                       </div>
                   </div>
                   
                   <div class="form-group">
                       <label class="col-lg-2 control-label">灾情信息</label>
                       <div class="col-lg-6">
                        <#list messagecodelist as message>
                          	<label><input name="messagecode" type="checkbox" value="${message.id }" <#if company.messagecode?contains(message.id?string)>checked="checked" </#if>/>${message.name } </label> 
                          </#list>
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
