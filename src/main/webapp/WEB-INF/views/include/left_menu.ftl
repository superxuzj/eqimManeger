 <style>
</style>   
 <aside>
     <div id="sidebar"  class="nav-collapse ">
         <!-- sidebar menu start-->
         <ul class="sidebar-menu">  
        	 <li <#if request.requestURI?index_of("/index")!=-1> class="active" </#if>>
                 <a class="" href="/index">
                     <span>首页</span>
                 </a>
             </li>              
             <li <#if request.requestURI?index_of("/sourcecatalog")!=-1> class="active" </#if>>
                 <a class="" href="/sourcecatalog">
                     <span>地震事件管理</span>
                 </a>
             </li>
            
             <li <#if request.requestURI?index_of("/earthquake")!=-1> class="active" </#if>>
                 <a class="" href="/earthquake">
                     <span>模拟地震事件管理</span>
                 </a>
             </li>
          
             <li <#if request.requestURI?index_of("/company")!=-1> class="active" </#if>>
                 <a class="" href="/company">
                     <span>单位管理</span>
                 </a>
             </li>
             
              <li <#if request.requestURI?index_of("/user")!=-1> class="active" </#if>>
                 <a class="" href="/user">
                     <span>成员管理</span>
                 </a>
             </li>
            <li class="sub-menu">
                      <a href="#" id="tongglehide">
                          <span>规则管理</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
                      <ul class="sub">
                          <li><a class="" href="/smscode">短信震级CODE</a></li>
                          <li><a class="" href="/quickcode">速报CODE</a></li> 
                          <li><a class="" href="/messagecode">灾情信息CODE</a></li>
                      </ul>
                  </li>
         </ul>
         <!-- sidebar menu end-->
     </div>
 </aside>
<script>

</script>