<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../outros/import_head.jsp"></c:import>
</head>
<body id="page-top">
	<c:import url="../outros/menu.jsp" />

	<ol class="breadcrumb">
		<li class="breadcrumb-item active">Clientes</li>
		<li class="breadcrumb-item"><a href="incluirEntidade">Incluir</a></li>
	</ol>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Código</th>
				<th scope="col">Nome</th>
				<th scope="col">Editar</th>
				<th scope="col">Excluir</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${entidades}" var="entidade">
				<tr>
					<th scope="row">${entidade.id}</th>
					<td>${entidade.nome}</td>
					<td><a href="editarEntidade?id=${entidade.id}">Editar</a></td>
					<td><a href="excluirEntidade?id=${entidade.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="../outros/fim_conteudo.jsp"></c:import>
	<c:import url="../outros/import_footer.jsp"></c:import>
</body>
</html>