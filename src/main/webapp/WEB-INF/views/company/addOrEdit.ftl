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
			<li>
			<#if company.id??>
			修改
			<#else>
			添加
			</#if>
			</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<section class="panel">                                          
           <div class="panel-body bio-graph-info">
               <form class="form-horizontal" action="/company/save" id="companyForm" method="POST">                                                  
                   <input type="hidden" id="hiddenid" name="id" value="${company.id}"/>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">名称</label>
                       <div class="col-lg-6">
                           <input type="text" class="form-control" name="name" id="name" value="${company.name}"/>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联络人</label>
                       <div class="col-lg-6">
                           <select class="form-control m-bot15" name="area" id="area">
                       			 <option value="非华北" <#if earthquake.area=='非华北' >selected</#if> >张三</option>
                                 <option value="华北"  <#if earthquake.area=='华北' >selected</#if> >李四</option>
                            </select>
                       </div>
                   </div>
                   <div class="form-group">
                       <label class="col-lg-2 control-label">联系人</label>
                       <div class="col-lg-6">
                       		<select class="form-control m-bot15" name="area" id="area">
                       			 <option value="非华北" <#if earthquake.area=='非华北' >selected</#if> >张三</option>
                                 <option value="华北"  <#if earthquake.area=='华北' >selected</#if> >李四</option>
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
		$("#companyForm").submit();
	}
	
	
	
</script>
</@override> <@extends name="/base/base.ftl"/>
