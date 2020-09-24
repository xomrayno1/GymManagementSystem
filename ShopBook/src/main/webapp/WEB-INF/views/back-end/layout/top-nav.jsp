<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<div class="top_nav">
            <div class="nav_menu">
                <nav>
                	<div class="nav toggle">
                 	 	<a id="menu_toggle"><i class="fa fa-bars"></i></a>
                	</div>
                <ul class="nav navbar-nav navbar-right" >
               
                  <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true" id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                      <img src='<c:url value="/resources/backend/images/img.jpg"></c:url>' alt="">${userInfo.name}
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right"> 
                      <li><a   href="javascript:;"> Profile</a></li>
                        <li><a   href="javascript:;">
                          <span class="badge bg-red pull-right">50%</span>
                          <span>Settings</span>
                        </a>
                        </li>
                   <li><a   href="javascript:;">Help</a></li>
                     <li><a  href='<c:url value="/manage/logout"></c:url>'><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                    </ul>
                  </li>
  				</ul>
                           
                </nav>
            </div>
          </div>