
<!--
  	自定义宏.
-->

<!--===========================For static start============================================== -->

<#macro s>/outteamstatic</#macro>

<!--outteam 状态 -->
<#macro outteamstate state>
	<#if state='1'>
通知
	<#elseif state='2'>
出队
	<#elseif state='3'>
撤退申请 
	<#elseif state='4'>
撤退同意
	<#elseif state='5'>
结束
	<#else>  
无
	</#if>
</#macro>

<!--leave状态 -->
<#macro leavestate state>
	<#if state='1'>
申请
	<#elseif state='2'>
撤离
	<#else>  
撤离
	</#if>
</#macro>


<!--user  用户角色-->
<#macro userroleid roleid>
	<#if roleid='1'>
	 系统管理员
	<#elseif roleid='2'>
	 单位管理员
	<#elseif roleid='3'>
	   领导
	<#elseif roleid='4'>
	  队员
	<#else>  
	  队员
	</#if>
</#macro>

