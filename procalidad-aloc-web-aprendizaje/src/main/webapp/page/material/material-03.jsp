<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>


<c:choose>
	<c:when test="${material.tipoTramDoc == 0}">
		<style type="text/css">
		
				/* .cabimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
			   		min-height: 200px; 
				}
				.fooimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
			   		min-height: 170px;
				}
				.cenimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
				}
				
				.contex {
				    padding-left: 18%;
				    padding-right: 13%;
				    padding-top: 2%;
				    padding-bottom: 2%;
				} */
		</style>

<!-- <script type="text/javascript">
$('#marial3').css({"margin-top": "0px", "padding-top": "0px"});

</script> -->
</c:when>

	<c:when test="${material.tipoTramDoc == 1}">
		<style type="text/css">
			/* 	.fondo-img-material{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		 background-position: center;
					/* background-size: 782px 411px;
					
			    	background-position: 50% 57%; 
				} */
				.cabimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
			   		min-height: 200px; 
				}
				.fooimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
			   		min-height: 170px;
				}
				.cenimg{
					background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
					background-repeat: no-repeat;
					background-size: 100% 100%;
			   		background-position: center;
				}
				
				.contex {
				    padding-left: 18%;
				    padding-right: 13%;
				    padding-top: 2%;
				    padding-bottom: 2%;
				}
		</style>

<!-- <script type="text/javascript">
$('#marial3').css({"margin-top": "0px", "padding-top": "0px"});

</script> -->
</c:when>
							
<c:when test="${material.tipoTramDoc == 2}">
	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
	   		 /*width: 100%;*/
	   		/* background-size: 779px 472px;
	    	background-position: 50% 57%; 
		} */
					.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
	</style>

</c:when>
							
<c:when test="${material.tipoTramDoc == 3}">
								<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
		/* background-size: 840px 1130px;
    background-position: 50% 53%;
	} */
	
	.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
</style>
<script type="text/javascript">
$('#marial3').css({"margin-top": "3%", "top": "0px", "padding": "9%", "margin-bottom": "10%"});

</script>
							</c:when>
							
							<c:when test="${material.tipoTramDoc == 4}">
								<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
   		 /*width: 100%;*/
   		/* background-size: 779px 472px;
    	background-position: 50% 57%;
	} */
	
	.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 35px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 100px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					
					.contex {
				    padding-left: 15%;
				    padding-right: 13%;
				   /*  padding-top: 2%;
				    padding-bottom: 2%; */
				}
</style>
<script type="text/javascript">
$('#marial3').css({"margin-top": "0px",});

</script>
							</c:when>
							

							
							<c:when test="${material.tipoTramDoc == 5}">
<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
	
	.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 80px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					.contex {
				    padding-left: 20%;
    				padding-right: 15%;
				    padding-top: 2%;
				    padding-bottom: 2%;
				}
</style>
<script type="text/javascript">
$('#marial3').css({"margin-top": "0px", "top": "0px", "padding": "7%", "margin-bottom": "5%"});

</script>
							</c:when>
														<c:when test="${material.tipoTramDoc == 6}">
<style type="text/css">
/* 	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
	
	.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 35px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 100px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					
					.contex {
				    padding-left: 15%;
				    padding-right: 13%;
				   /*  padding-top: 2%;
				    padding-bottom: 2%; */
				}
</style>
<script type="text/javascript">
/* $('#marial3').css({"margin-top": "0px", "top": "0px", "padding": "7%", "margin-bottom": "5%"});
 */
</script>
							</c:when>
							
							<c:when test="${material.tipoTramDoc == 7}">
<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
					.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 120px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 120px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					.contex{
						padding-left: 6%;
    					padding-right: 6%;
					}
					.MsoNoSpacing{
						color: white;
					}
					.MsoNormal {
					    color: white;
					}
</style>
<script type="text/javascript">
 $('#marial3').css({"padding": "10%","margin-top": "24px"});

</script>
							</c:when>
									<c:when test="${material.tipoTramDoc == 8}">
<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
					.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					
					.contex{
					    padding-left: 11%;
    					padding-right: 11%;
					}
</style>
<script type="text/javascript">
/* $('#marial3').css({"margin-top": "0px", "top": "0px", "padding": "7%", "margin-bottom": "5%"});
 */
</script>
							</c:when>
							<c:when test="${material.tipoTramDoc == 9}">
<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
					.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
					
					.contex	{
					    padding-left: 10%;
					    padding-right: 10%;
					    padding-top: 1%;
    					padding-bottom: 1%;
					}
</style>
<script type="text/javascript">
/* $('#marial3').css({"margin-top": "0px", "top": "0px", "padding": "7%", "margin-bottom": "5%"});
 */
</script>
							</c:when>
							
							<c:when test="${material.tipoTramDoc == 10}">
<style type="text/css">
	/* .fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
	.cabimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px; 
					}
					.fooimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
				   		min-height: 200px;
					}
					.cenimg{
						background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
						background-repeat: no-repeat;
						background-size: 100% 100%;
				   		background-position: center;
					}
</style>
<!-- <script type="text/javascript">
/* $('#marial3').css({"margin-top": "0px", "top": "0px", "padding": "7%", "margin-bottom": "5%"});
 */
</script> -->
							</c:when>
														<c:when test="${material.tipoTramDoc == 30}">
<style type="text/css">
/* 	.fondo-img-material{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		 background-position: center;
	} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	.contex{
	    padding-left: 10%;
    	padding-right: 10%;
	}
</style>
<!-- <script type="text/javascript">
 $('.contex').css({"padding-left": "19%","padding-right": "14%"});
 
</script>  -->
							</c:when>
<c:when test="${material.tipoTramDoc == 31}">
	<style type="text/css">
	/* 	.fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
		.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 290px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	.contex{
	padding-left: 10%;
    padding-right: 10%;
    padding-top: 10px;
	}
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "4%", "top": "15px","margin-bottom": "13%","padding-left": "4%","padding-right": "6%"});
	 
	</script> -->

</c:when>
<c:when test="${material.tipoTramDoc == 32}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
		.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
	    padding-left: 13%;
    	padding-right: 13%;
    	padding-top: 10px;
	}
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "86px", "top": "15px","margin-bottom": "-9px","padding": "117px"});
	 
	</script> -->

</c:when>
<c:when test="${material.tipoTramDoc == 33}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
		.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 8%;
    	padding-right: 8%;
	}
	
	.MsoNoSpacing{
		color: white;
	}
	.MsoNormal {
					    color: white;
	}
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 34}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
		.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 8%;
    	padding-right: 8%;
	}
	
	.MsoNoSpacing{
		color: white;
	}
	.MsoNormal {
					    color: white;
	}
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 35}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
		.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 180px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 150px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 30%;
    	padding-right: 24%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 36}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 180px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 150px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 30%;
    	padding-right: 24%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 37}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 180px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 170px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 11%;
    	padding-right: 11%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 38}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 100px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 11%;
    	padding-right: 11%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 39}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
	
	.contex{
		padding-left: 11%;
    	padding-right: 11%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>


<c:when test="${material.tipoTramDoc == 40}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-size: contain;
    	background-repeat-y: repeat;
	}
	
	.contex{
		padding-left: 12%;
  		padding-right: 12%;
  		padding-top: 3%;
  		
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>
<c:when test="${material.tipoTramDoc == 41}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-size: contain;
    	background-repeat-y: repeat;
	}
	
	.contex{
		padding-left: 12%;
  		padding-right: 11%;
  		padding-top: 3%;
  		
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 42}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		/* background-size: contain;
    	background-repeat-y: repeat; */
    	background-repeat: NO-REPEAT;
    	background-size: 100% 100%;
    	background-position: center;
	}
	
	.contex{
		padding-left: 6%;
    	padding-right: 6%;
	}
	
	.MsoNoSpacing{
		color: white;
	}
	.MsoNormal {
					    color: white;
	}
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 43}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 115px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		/* background-size: contain;
    	background-repeat-y: repeat; */
    	background-repeat: NO-REPEAT;
    background-size: 100% 100%;
    background-position: center;
	}
	
	.contex{
		padding-left: 8%;
    	padding-right: 8%;
	}
	
	.MsoNoSpacing{
		color: white;
	}
	.MsoNormal {
					    color: white;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 44}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-size: contain;
    	background-repeat: repeat-y;
    	min-height: 200px;
	}
	
	.contex{
		padding-left: 17%;
    	padding-right: 10%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>

<c:when test="${material.tipoTramDoc == 45}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		/* background-size: contain;
    	background-repeat-y: repeat; */
    	background-size: contain;
    	background-repeat: repeat-y;
    	min-height: 200px;
	}
	
	.contex{
		padding-left: 17%;
    	padding-right: 10%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>


<c:when test="${material.tipoTramDoc == 46}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 160px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		/* background-repeat: repeat-y;
   		background-size: contain; */
   		background-size: contain;
    	background-repeat: repeat-y;
    	min-height: 200px;
	}
	
	.contex{
		padding-left: 14%;
   		padding-right: 14%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>


<c:when test="${material.tipoTramDoc == 47}">

	<style type="text/css">
		/* .fondo-img-material{
			background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
			background-repeat: no-repeat;
			background-size: 100% 100%;
	   		 background-position: center;
		} */
	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 120px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-size: contain;
   		background-repeat: repeat-y;
    	min-height: 270px;
	}
	
	.contex{
		padding-left: 13%;
   		padding-right: 13%;
	}
	
	</style>
	<!-- <script type="text/javascript">
	 $('#marial3').css({"margin-top": "10px", "top": "15px","margin-bottom": "41px","padding": "80px"});
	 
	</script> -->

</c:when>
				
	<c:otherwise>
		<style type="text/css">
/* .fondo-img-material {
	background-image:
		url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-position: center;
	/* background-size: 782px 411px;background-position: 50% 57%; 
		
    	
} */

	.cabimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.nomImgTipoTramDoc}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px; 
	}
	.fooimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor2}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
   		min-height: 200px;
	}
	.cenimg{
		background-image: url('${pageContext.request.contextPath}/maestra/${material.valor1}');
		background-repeat: no-repeat;
		background-size: 100% 100%;
   		background-position: center;
	}
</style>
<script type="text/javascript">
//console.log('codlenguaTreeVal lengua castellano');
if ($('#codlenguaTreeVal').val()==24) {
	 $('#marial3').css({"margin-top": "0px", "top": "0px", "padding-top": "0px", "margin-bottom": "0px"});
}
/*
 */
</script>
	</c:otherwise>
</c:choose>
 
 <c:if test="${lenguaBean.codigo==24}">
 <script type="text/javascript">
  $('#marial3').css({"margin-top": "0px", "top": "0px", "padding-top": "0px", "margin-bottom": "0px"});
  </script>
 </c:if>

<!-- marial 03 -->

	<div class="row row-bottom-padded-md">
			<!-- <div class="col-md-10 to-animate col-md-offset-1"> -->
			<div class="col-md-12 to-animate fondo-lectura fadeInUp animated">
				<span class="bg-img-mt-top"></span>

				<div class="row main-nav-pag">
					<div class="col-md-12">
						<c:if test="${not empty material.comprension}">
							<span class="material-style">${material.comprension}</span>
						</c:if>
					</div>
				</div>

				<div class="row main-nav-pag">
					<div class="col-md-12">
						<nav id="pagination-leccion">
						<ul class="control-box pager">
							<li><a id="glosario-link" onclick="mostrarGlosario()" href="#">Glosario <i class="fa fa-sort-alpha-desc"></i></a></li>
							<li><a data-slide="prev" href="#" class="opt-before-exercise"><i class="fa fa-mail-reply"></i></a></li>
							<li><a data-slide="next" onclick="irHaciaEjercicios()" href="#" class="opt-next-exercise"><i class="fa fa-mail-forward"></i></a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
				   		<div id="content-text-glosario" style="display: none;">
				   			<span id="content-icon-m">
				   				<i class="icon-notebook"></i>
				   			</span>
							<div id="textoGlosario"></div>
							<span class="close-conten" onclick="ocultarDivGlosario()"></span>
				   		</div>
					</div>
				</div>

				<input type="hidden" id="codmaterialVal" value="${material.codigo}">
				<input type="hidden" id="codmaterialValEncrypt" value="${material.codigoEncrypt}">
		
				<input type="hidden" id="tipoMaterialVal" value="${material.situacionLeccionMaterial.codigoRegistro}">
				<input type="hidden" value="${material.nomImgTipoTramDoc}">
				<input type="hidden" value="${material.tipoTramDoc}">
				
				<c:if test="${not empty material.indicacion}">
					<div class="row">
						<div class="col-md-12" id="nav-link-name">
							<!-- <i class="icon-pencil pull-left pencil-styel"></i> -->
								<i class="pull-left img-icon-indicacion">
									<img src="${pageContext.request.contextPath}/assets/images/icono-ejercicio/ICONOS-3.png"  height="20px" style="margin-bottom: 40px;">
								</i>
							<!-- <i onclick="mostrarDiv()" class="icon-info pencil-styel pull-left" title="Información"></i> -->
							<h4 class="sub-title-app">${material.indicacion}</h4>
						</div>
						
					</div>
				</c:if>
				<c:if test="${not empty material.descripcionMaterial}">
						<div class="row">
							<div class="col-md-12">
								<h2 class="title-minendu format-size">${material.descripcionMaterial}</h2>
							</div>
						</div>
							
				</c:if>
				<div class="row" <%-- <c:if test="${not empty material.nomImgTipoTramDoc}">fondo-img-material</c:if> " --%> style="-webkit-border-image: inherit;border: 0px solid transparent;"> 
						
				<!-- <div id="marial3" class="col-md-12" > --> <!-- style="margin-bottom: 24px;margin-top: 0px;padding: 30px;bottom: 0;top: 15px;" -->
					
						<div class="col-md-12">
							<div class="cabimg"></div><!-- <img src="${pageContext.request.contextPath}/assets/images/DIAPO-1.png"> -->
							<div class="cenimg">
							
								<div class="text-format resetCSS contex">${material.contexto}</div><!--text-format resetCSS contex  -->
							
							</div>
							<div class="fooimg"></div><!-- <img src="${pageContext.request.contextPath}/assets/images/DIAPO-2.png"> -->
						</div>
						<br>
				<!-- </div> -->
				</div>
				
			<c:if test="${not empty material.comentario}">
				<div class="row">
				<c:choose>
					<c:when test="${lenguaBean.codigo==24}">
						<div class="col-md-12">
					   		<div id="content-text-castellano">
								${material.comentario}
					   		</div>
						</div>
					</c:when>
					<c:otherwise>
					    <div class="col-md-12">
							<span onclick="mostrarDivNew()" id="idShowIndGram">
					   				<i class="icon-notebook"></i>
					   		</span>
						</div>
						<div class="col-md-12">
					   		<div id="content-text-info">
					   			<span id="content-icon-m">
					   				<i class="icon-notebook"></i>
					   			</span>
								${material.comentario}
								<span class="close-conten" onclick="ocultarDivNew()"></span>
					   		</div>
						</div>
					</c:otherwise>
				</c:choose>
				</div>
			</c:if>

				<div class="row">
					<div class="col-md-12" style="margin-top: 15px;">
						<div class="form-group text-center">
							<a id="btnNextMaterial" class="btn btn-primary btn-lg icon-arrow" onclick="irHaciaEjercicios()" href="#"><i class="icon-arrow-right2"></i></a>
						</div>
					</div>
				</div>
			</div>
	</div>
<script type="text/javascript" charset="utf-8">
	traducirSub();
</script>