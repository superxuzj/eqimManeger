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
			<li>用户管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
 <div class="row">
	<div class="col-lg-12">
		<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
	</div>
     <div class="col-lg-12">
         <section class="panel">
             <table class="table table-striped table-advance table-hover">
              <tbody>
                 <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>职责</th>
                    <th>职务</th>
                    <th>单位</th>
                    <th>手机</th>
                    <th>状态</th>
                    <th>操作</th>
                 </tr>
                 
                 <#list page.list as user>
                 <tr>
                    <td>${user.id }</td>
                  <td>${user.name }</td>
                  <td>${user.profession }</td>
                  <td>${user.job }</td>
                  <td>${user.company }</td>
                  <td>${user.phone }</td>
                  <td>${user.state }</td>
                  <td>
                   <div class="btn-group">
                       <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                       	操作<span class="caret"></span></a>
                       <ul class="dropdown-menu">
                         <li><a href="/user/info?id=${user.id }" title="详情">详情</a></li>
                         <li class="divider"></li>
                         <li><a href="/user/goadd?id=${user.id }" title="修改">修改</a></li>
                         <li class="divider"></li>
                         <li><a href="/user/del?id=${user.id }" title="Bootstrap 3 themes generator">注销</a></li>
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
function add(){
	window.location.href = "/user/goadd";
}
</script>
</@override> <@extends name="/base/base.ftl"/>