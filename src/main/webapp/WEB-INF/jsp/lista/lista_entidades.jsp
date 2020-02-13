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
		<li class="breadcrumb-item active">${tipo}</li>
		<li class="breadcrumb-item"><a href="incluirEntidade?tipo=${tipo.toLowerCase()}">INCLUIR</a></li>
	</ol>

	<div class="card mb-3">

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-sm" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Editar</th>
							<th>Excluir</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${entidades}" var="entidade">
							<tr>
								<th scope="row">${entidade.id}</th>
								<td>${entidade.nome}</td>
								<td><a href="editarEntidade?tipo=${tipo}&id=${entidade.id}">Editar</a></td>
								<td><a
									href="excluirEntidade?tipo=${tipo}&id=${entidade.id}"
									onclick="return confirmacao(${entidade.id});">Excluir</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<c:import url="../outros/fim_conteudo.jsp"></c:import>
	<c:import url="../outros/import_footer.jsp"></c:import>
</body>
<script>
	function confirmacao(codigo){
		var resposta = confirm("Deseja mesmo remover o registro " + codigo + " ?");
		
		return resposta;
	}
	$(document).ready(function () {             
		  $('.dataTables_filter input[type="search"]').css(
		     {'width':'350px','display':'inline-block'}
		  );
		});
</script>
</html>