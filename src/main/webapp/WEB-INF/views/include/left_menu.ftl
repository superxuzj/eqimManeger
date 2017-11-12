 <style>

</style>   
 
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu">  
             	 <li <#if _request.requestURI?index_of("/index")!=-1> class="active" </#if>>
                      <a class="" href="/index">
                          <span>首页</span>
                      </a>
                  </li>              
                  <li <#if _request.requestURI?index_of("/earthquake")!=-1> class="active" </#if>>
                      <a class="" href="/earthquake">
                          <span>地震事件管理</span>
                      </a>
                  </li>
                  <li <#if _request.requestURI?index_of("/outteam")!=-1> class="active" </#if>>
                      <a class="" href="/outteam">
                          <span>出队管理</span>
                      </a>
                  </li>
                  
                  <li <#if _request.requestURI?index_of("/leave")!=-1> class="active" </#if>>
                      <a class="" href="/leave">
                          <span>撤离管理</span>
                      </a>
                  </li>
                  
                  <#if sessionroleid==1>
                  <li <#if _request.requestURI?index_of("/company")!=-1> class="active" </#if>>
                      <a class="" href="/company">
                          <span>单位管理</span>
                      </a>
                  </li>
                  
                  <li class="sub-menu">
                      <a href="javascript:;" class="" id="tongglehide">
                          <span>预案管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="/hbplan">华北预案管理</a></li>
                          <li><a class="" href="/onduty">轮值管理 </a></li> 
                          <li><a class="" href="/respond">响应等级</a></li>
                          <li><a class="" href="/link">联动管理</a></li>
                      </ul>
                  </li>
                  </#if>
				  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <span>用户管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="/user">用户管理</a></li>                          
                          <li><a class="" href="/role">角色管理</a></li>
                      </ul>
                  </li> 
                  
                  <li class="sub-menu">
                      <a href="javascript:;" class="">
                          <span>个人信息</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="/person">我的信息</a></li>                          
                         
                          <!-- <li><a class="" href="/personteam">我的出队</a></li> -->
                      </ul>
                  </li>  
                  
                   <li>
                      <a class="" href="#">
                          <span>统计分析</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
<script>

</script>