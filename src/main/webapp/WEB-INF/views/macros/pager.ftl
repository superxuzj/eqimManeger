<#macro pager page>
<style>
.page-1 a{
	margin-left:1px;
	padding-left:5px;
}
</style>
<#--前一个参数是总记录数，后一个参数是页面记录数-->  
<@pagination page.total page.pageSize page.pages page.pageNum /> 
</#macro>

<#macro pagination totalCount pageSize pages pageNum>  
    <#--声明一个函数transform 转换uri,在新的uri上pager_offset参数  -->  
    <#assign transform = "com.boliangshenghe.outteam.common.page.TransformURI"?new()>  
    <#assign pageCount= pages>  
    <#--得到当前的URI和请求参数,得到当前的页码-->  
    <#if pageCount gt 0>
    <#if request.queryString?exists>  
        <#assign uri=request.requestURI+"?"+request.queryString>  
        <#assign pageIndex=pageNum>  
        <#assign new_uri=transform(uri)>  
    <#else>  
        <#assign uri=request.requestURI>  
        <#assign pageIndex=pageNum>  
        <#assign new_uri=transform(uri)>  
    </#if>  
    <#if (pageIndex>pageCount)>  
        <#assign pageIndex=pageCount>  
    </#if>  
    <div class="page-1" > 
    <#if (pageIndex>1)>  
        <a href="${new_uri+1}" >首页</a>
    </#if>  
    <#--如果前面页数过多,显示"..."-->  
    <#if (pageIndex>4)>  
        <#assign prevPages=pageIndex-7>  
        <#if prevPages lt 1>  
            <#assign prevPages=1>  
        </#if>  
        <#assign start=pageIndex-3>  
        
    <#else>  
        <#assign start=1>  
     </#if>  
    <#-- 显示当前页附近的页-->  
    <#assign end=pageIndex+3>  
    <#if (end>pageCount)>  
        <#assign end=pageCount>  
    </#if>  
    
    <#list start..end as index> 
    	<#if index gt 0> 
	        <#if pageIndex==index>  
	            <a href="###" class="page-active">${index}</a>
	        <#else>  
	       		<a href="${new_uri+index}">${index}</a>
	        </#if>  
        </#if>
    </#list>  
    <#--如果后面页数过多,显示"...":-->  
    <#if (end lt pageCount)>  
        <#assign endend=end+5>  
        <#if (end>pageCount)>  
            <#assign end=pageCount>  
        </#if>  
         
    </#if>  
    <#-- 显示"下一页":-->  
    <#if (pageIndex lt pageCount)>  
    <a href="${new_uri+pageCount}">尾页</a> 
      
    </#if>

           共 ${pageCount} 页 共${totalCount}条 到第
           
           <input id="pageNo" type="text" class="input-page">
            页 <a href="#" class="ks-button" id="page_go">GO</a> </div>
           
    <script type="text/javascript">
    var pageCount=${pageCount};
    $(document).ready(function(){
    	$("#page_go").bind("click",function(){
    		var pageNo=$("#pageNo").val();
    		if(pageNo=="" ||isNaN(pageNo)){
    			alert("请输入有效的页码")
    			return false;
    		}
   			if(parseInt(pageCount)<pageNo){
   				alert("输入的页码大于总页码，请重新输入");
   				return false ;
   			}
   			top.window.location.href="${new_uri}"+pageNo;
    		
    			
    	})
    })
    </script>
    </#if>
</#macro> 
 		