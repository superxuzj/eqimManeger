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
			<li>模拟地震事件管理</li>
			<!-- <li>Dashboard</li>
						<li>Dashb省道oard</li> -->
		</ol>
	</div>
</div>
 <div class="row">
     <div class="col-lg-12">
             <section class="panel">
                 <div class="panel-body">
                     <form class="form-horizontal" role="form" action="/earthquake/list">
                         <div class="form-group col-lg-3">
                             <label for="inputPassword1" class="col-lg-3 control-label">名称</label>
                             <div class="col-lg-9">
                                 <input type="text" class="form-control" name="eqname" value="${earthquake.eqname }">
                             </div>
                         </div>
                         <div class="form-group col-lg-3">
                        	  <label for="inputPassword1" class="col-lg-3 control-label">省份</label>
                             <div class="col-lg-9">
                                 <input type="text" class="form-control" name="province" value="${earthquake.province }">
                             </div>
                         </div>
                         <div class="form-group col-lg-3">
                             <div class="col-lg-offset-2 col-lg-10">
                                 <button type="submit" class="btn">搜索</button>
                             </div>
                         </div>
                     </form>
                 </div>
             </section>

         </div>
        <div class="col-lg-12">
			<a class="btn btn-primary btn-sm" href="javascript:add();" title="新增">新增</a>
		</div>
        <div class="col-lg-12">
            <section class="panel">
                <table class="table table-striped table-advance table-hover">
                 <tbody>
                    <tr>
                       <th>地震唯一标识码</th>
                       <th>名称</th>
                       <th>位置</th>
                       <th>震级</th>
                       <th>日期</th>
                       <th>操作</th>
                    </tr>
                    
                    <#list page.list as earthquake>
                    <tr>
                       <td>${earthquake.eventid }</td>
                     <td>${earthquake.eqname }</td>
                     <td>${earthquake.location }</td>
                     <td>${earthquake.magnitude }</td>
                     <td>${earthquake.eqtime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    
                     <td>
                      <div class="btn-group">
                          <a class="btn btn-info dropdown-toggle" data-toggle="dropdown" href="" title="Bootstrap 3 themes generator">
                          	操作<span class="caret"></span></a>
                          <ul class="dropdown-menu">
                            <li><a href="/earthquake/goadd?id=${earthquake.id }" title="修改">修改</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:void(0)" onclick="send(${earthquake.id })" title="发送短信">发送短信</a></li>
                            <li class="divider"></li>
                            <li><a href="/earthquake/del?id=${earthquake.id }" title="删除">删除</a></li>
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
function send(id){
	if(window.confirm('你确定要发送短信吗？')){
		$.ajax({ 
	        type: "POST",
	        url:"/earthquake/send",
	        data:{  
	            "id" : id
	        },
	        scriptCharset: 'utf-8',
	        success: function(data) {
	        	if(data=="success"){
	        		alert("短信发送成功！");
	        	}else{
	        		alert("短信发送失败，不符合发送短信条件！");
	        	}
	        }
		});
     }else{
        //alert("取消");
        return false;
    }
}
function appoutteam(eqid){
	$.ajax({ 
        type: "POST",
        url:"/outteam/isappoutteam",
        data:{  
            "eqid" : eqid
        },
        scriptCharset: 'utf-8',
        success: function(data) {
        	if(data=="no"){
        		window.location.href = "/outteam/addapplyoutteam?eqid="+eqid;
        	}else{
        		alert("已有出队信息，请在出队管理中查看！");
        		return ;
        	}
        }
	});
	
}
function add(){
	window.location.href = "/earthquake/goadd";
}
</script>
</@override> <@extends name="/base/base.ftl"/>
