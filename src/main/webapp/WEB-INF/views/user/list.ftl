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
         <section class="panel">
             <table class="table table-striped table-advance table-hover">
              <tbody>
                 <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>职责</th>
                    <th>职责</th>
                    <th>单位</th>
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
                         <li><a href="/company/info?id=${company.id }" title="详情">详情</a></li>
                         <li class="divider"></li>
                         <li><a href="/company/goadd?id=${company.id }" title="修改">修改</a></li>
                         <li class="divider"></li>
                         <li><a href="" title="Bootstrap 3 themes generator">注销</a></li>
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
