<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Airline Database</title>
</head>
<body>
    <h1>Lista de libros</h1>
    <ul>
 
		<!-- Lista con todos los libros que hay en la base de datos, 
			los saca de la variable libros. -->
 
        <c:forEach var="lenguaBean" items="${lstLenguaBean}">
            <li>Titulo: ${lenguaBean.codigo} - Autor:  ${lenguaBean.nombre}</li>
        </c:forEach>
    </ul>
 
    <!-- formulario en el que se recogen los datos para crear un nuevo libro,
    y al mandar llama a /addbook que será mapeado por nuestro método insertBook 
    que definimos en LibroController. -->
    
   <table class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>Codigo</th>
										<th>Usuario</th>
										<th>Nombre Largo</th>
										<th>Acci&oacute;n</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="lenguaBean" items="${lstLenguaBean}">
										<tr>
											<td><c:out value="${lenguaBean.codigo}" /></td>
											<td><c:out value="${lenguaBean.nombre}" /></td>
											<td><c:out value="${lenguaBean.nombre}" /></td>
											<td>
												<a class="btn btn-success" href="modificar?codigo=${usuario.codigo}">
													<i class="fa fa-edit "></i>
												</a>
												
												<a  class="btn btn-danger" href="javascript:eliminar('${usuario.nombreCompleto}','${usuario.codigo}')">
													<i class="glyphicon glyphicon-trash"></i>
												</a>
												
											</td>
										</tr>
								</c:forEach>
								</tbody>
							</table>
    
    
</body>
</html>
