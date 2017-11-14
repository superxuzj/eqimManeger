<@override name="head"> 

</@override> <@override name="body">
<style>
.form-group{
border-bottom:0px !important;
padding-bottom:1px !important;
margin-bottom:1px !important;
}
</style>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			您的位置：
			<li><a href="/">首页</a></li>
			<li>地震事件管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
 <div class="row">
     <div class="col-lg-12">
         <section class="panel">
             <table class="table table-striped table-advance table-hover">
              <tbody>
                 <tr>
                    <th>ID</th>
                    <th>event_id</th>
                    <th>保存时间</th>
                    <th>发生时间</th>
                    <th>深度</th>
                    <th>位置</th>
                    <th>操作</th>
                 </tr>
                 
                 <#list page.list as catalog>
                 <tr>
                    <td>${catalog.cataId }</td>
                  <td>${catalog.eventId }</td>
                  <td>${catalog.saveTime }</td>
                  <td>${catalog.oTime }</td>
                  <td>${catalog.depth }</td>
                  <td>${catalog.locationCname }</td>
                  <td>
                   <div class="btn-group">
                       <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                       	操作<span class="caret"></span></a>
                       <ul class="dropdown-menu">
                         <li><a href="/earthquake/info?id=${earthquake.id }" title="详情">详情</a></li>
                         <#if sessionroleid==2>
                         <li><a href="javascript:appoutteam('${earthquake.id }');" title="申请出队">申请出队</a></li>
                        	</#if>
                        <#if sessionroleid==1>
                         <li class="divider"></li>
                         <li><a href="/earthquake/goadd?id=${earthquake.id }" title="修改">修改</a></li>
                         <!-- <li class="divider"></li>
                         <li><a href="" title="Bootstrap 3 themes generator">结束</a></li> -->
                              </#if>
                            </ul>
                        </div>
                        </td>
                    </tr>
                   </#list>
                 </tbody>
                 		
              </table>
            </section>
        </div>
        <div class="col-lg-12">
<#import "/macros/pager.ftl" as p/>
<@p.pager page/>
</div>
</div>

<script type="text/javascript">
</script>
</@override> <@extends name="/base/base.ftl"/>
