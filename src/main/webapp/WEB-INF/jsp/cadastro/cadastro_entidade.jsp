<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="../outros/import_head.jsp"></c:import>
</head>
<body id="page-top">
	<c:import url="../outros/menu.jsp"/>
	
	<form action="salvarEntidade" method="post">
		
		<ol class="breadcrumb">
			<li class="breadcrumb-item active"><c:out value="${tipo}"></c:out></li>
		</ol>

		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text" id="basic-addon1">Nome:</span>
			</div>
			<input type="text" name="nome" value="${entidade.nome}" class="form-control"
				placeholder="Digite seu nome" aria-label="nome"
				aria-describedby="basic-addon1">
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
	
	<c:import url="../outros/import_footer.jsp"></c:import>
</body>
</html>