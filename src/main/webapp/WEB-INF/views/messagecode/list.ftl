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
			<li>灾情信息CODE管理</li>
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
                    <th>名称</th>
                    <th>编码</th>
                    <th>操作</th>
                 </tr>
                 
                 <#list list as messagecode>
                 <tr>
                    <td>${messagecode.id }</td>
                  <td>${messagecode.name }</td>
                  <td>${messagecode.code }</td>
                  <td>
                   <div class="btn-group">
                       <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                       	操作<span class="caret"></span></a>
                      	 <ul class="dropdown-menu">
                      	  <li><a href="#" title="无">无</a></li>
                        <!--  <li><a href="/earthquake/info?id=${earthquake.id }" title="详情">详情</a></li> -->
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
$(document).ready(function(){ 
	
	console.log("1");
	　$("#tongglehide").click();  
}); 
</script>
</@override> <@extends name="/base/base.ftl"/>
