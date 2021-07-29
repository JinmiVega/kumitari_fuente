<%-- <%@ page contentType="text/html; charset=UTF-8" %>
<div id="main-tree-view">
	<h3 class="efect-show">Vista General</h3>
    <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
        <span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
    </button>
    <ul id="tree-list">
        <li><a href="#">TECH</a>
            <ul>
                <li>Company Maintenance</li>
                <li>Employees
                    <ul>
                        <li>Reports
                            <ul>
                                <li><a href="">link</a></li>
                                <li><a href="">link</a></li>
                                <li><a href="">link</a></li>
                            </ul>
                        </li>
                        <li>Employee Maint.</li>
                    </ul>
                </li>
                <li>Human Resources</li>
            </ul>
        </li>
        <li>XRP
            <ul>
                <li>Company Maintenance</li>
                <li>Employees
                    <ul>
                        <li>Reports
                            <ul>
                                <li>Report1</li>
                                <li>Report2</li>
                                <li>Report3</li>
                            </ul>
                        </li>
                        <li>Employee Maint.</li>
                    </ul>
                </li>
                <li>Human Resources</li>
            </ul>
        </li>
    </ul>
</div> --%>

<%@ page contentType="text/html; charset=UTF-8" %>

<style type="text/css">
	.link-item-subnivel{
		color: #1b1b24;
	}
	
	.link-item-material{
		color: #1b1b24;
	}
	
	.link-item-ejercicio{
		color: #1b1b24;
	}

	.opt-active-tree{
		    background: #e4e5ff;
    		color: #2a1c98;
    		text-decoration: underline;
	}
</style>

<div id="main-tree-view">
	<h3 class="efect-show">Vista General</h3>
<!--     <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
        <span class="hamb-top"></span>
		<span class="hamb-middle"></span>
		<span class="hamb-bottom"></span>
    </button> -->
    <button type="button" class="hamburger is-closed" data-toggle="offcanvas">
        <i class="fa fa-indent"></i>
        <i class="fa fa-outdent"></i>
    </button>

    <hr>
    <div class="scrollbar-inner">
        <ul id="tree-list">
        </ul>
    </div>
    <div class="main-ajax">
        <div class="preloader"></div>
        <i class="icon-minedu-kumitsari"></i>
    </div>
</div>