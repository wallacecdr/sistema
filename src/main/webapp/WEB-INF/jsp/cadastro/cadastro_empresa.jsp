<%@page import="java.util.ArrayList"%>
<%@page import="com.sistema.model.Estado"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.model.Empresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../outros/import_head.jsp"></c:import>

</head>
<body id="page-top">
	<c:import url="../outros/menu.jsp" />

	<ol class="breadcrumb">
		<li class="breadcrumb-item active"><c:out value="${tipo}"></c:out></li>
	</ol>

	<form class="needs-validation" method="post" action="salvarEmpresa">

		<div class="form-row">

			<!-- Inicia a div do form do lado esquerdo -->
			<div class="col-md-6 order-md-1">
				<div class="card mb-3">
					 <div class="card-body">
					 	<div class="form-row">
							<label for="id" class="col-sm-3 col-form-label col-form-label-sm">Código</label>
							<label for="enquadramento" class="col-sm-6 col-form-label col-form-label-sm">Equadramento</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-3"> 
								<input type="text" name="id" readonly="readonly" class="form-control form-control-sm" 
									id="id" value="${empresa.id}">
							</div>
							<div class="col-sm-4">
								<select
									class="form-control form-control-sm" id="enquadramento" name="enquadramento">
									<option value="0"
										<c:if test="${empresa.enquadramento == 0}">selected="selected"</c:if>
									>Simples Nacional</option>
									<%-- <option value="1"
										<c:if test="${empresa.enquadramento == 1}">selected="selected"</c:if>
									>Lucro Real</option>
									<option value="2"
										<c:if test="${empresa.enquadramento == 2}">selected="selected"</c:if>
									>Lucro Presumido</option> --%>
								</select>
							</div>
						</div>
						
						<div class="form-row">
							<label for="nome" class="col-sm-12 col-form-label col-form-label-sm">Razão Social</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="razaosoc" class="form-control form-control-sm" id="nome" 
								placeholder="Digite a razão social da empresa" value="${empresa.razaosoc}" required>
								<div class="valid-feedback">Tudo certo!</div>
							</div>
						</div>
						
						<div class="form-row">
							<label for="nome" class="col-sm-12 col-form-label col-form-label-sm">Nome</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="nome" class="form-control form-control-sm" id="nome" 
								placeholder="Digite o nome da empresa" value="${empresa.nome}" required>
								<div class="valid-feedback">Tudo certo!</div>
							</div>
						</div>
						
						<div class="form-row">
							<label for="cep" class="col-sm-4 col-form-label col-form-label-sm">Cep</label> 
							<label for="estado" class="col-sm-2 col-form-label col-form-label-sm">Estado</label>
						</div>
						<div class="form-row">
							<div class="col-sm-4">
								<input type="text" name="cep" class="form-control form-control-sm" id="cep" placeholder="Cep"
									value="${empresa.cep}">
							</div>
							
							<div class="col-sm-2">
								<select class="form-control form-control-sm" name="estado" id="estado">
									<c:forEach var="estado" items="${estados}">
										<option value="${estado.codigo}" 
											<c:if test="${empresa.estado.codigo == estado.codigo}">selected="selected"</c:if> 
										>${estado.codigo}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-row">
							<label for="cidade" class="col-sm-12 col-form-label col-form-label-sm">Cidade</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12 mb-0">
								<select class="form-control form-control-sm" name="cidade" id="cidade" data-size="auto">
									<c:forEach var="cidade" items="${cidades}">
										<option value="${cidade.nome}" 
											<c:if test="${empresa.cidade.nome == cidade.nome}">selected="selected"</c:if> 
										>${cidade.nome}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-row">
							<label for="endereco" class="col-sm-10 col-form-label col-form-label-sm">Endereço</label>
							<label for="numero" class="col-sm-2 col-form-label col-form-label-sm">Número</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-10 mb-0"> 
								<input type="text" name="endereco" class="form-control form-control-sm" 
									id="endereco" placeholder="Endereço" value="${empresa.endereco}">
							</div>
							
							<div class="col-sm-2 mb-0">
								<input type="text" name="numero" class="form-control form-control-sm" 
									id="numero" placeholder="Nº" value="${empresa.numero}">
							</div>
						</div>
						
						<div class="form-row">
							<label for="complemento" class="col-sm-12 col-form-label col-form-label-sm">Complemento</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="complemento" class="form-control form-control-sm"  
									id="complemento" placeholder="Complemento"	value="${empresa.complemento}">
							</div>
						</div>
						
						<div class="form-row">
							<label for="bairro" class="col-sm-12 col-form-label col-form-label-sm">Bairro</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="bairro"
									class="form-control form-control-sm" id="bairro" placeholder="Bairro" value="${empresa.bairro}">
								<div class="invalid-feedback">Por favor, informe um bairro
									válido.</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Inicia a div do form do lado direito -->
			<div class="col-md-6 order-md-2">
				<div class="card">
					<div class="card-body">
						<div class="form-row">
							<label for="fone" class="col-sm-6 col-form-label col-form-label-sm">Telefone</label> 
							<label for="celular" class="col-sm-6 col-form-label col-form-label-sm">Celular</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-6 mb-0">
								<input type="text" name="fone" class="form-control form-control-sm" 
									id="fone" placeholder="Telefone" value="${empresa.fone}">
							</div>
							<div class="col-sm-6 mb-0">
								<input type="text" name="celular" class="form-control form-control-sm"
									 id="celular" placeholder="Celular" value="${empresa.celular}">
								<div class="invalid-feedback">Por favor, informe seu celular</div>
							</div>
						</div>
						
						
						<div class="form-row">
								<label for="inscricaoestadual" class="col-sm-6 col-form-label col-form-label-sm">Inscrição estadual</label>
								<label for="cnpj" class="col-sm-6 col-form-label col-form-label-sm">Cnpj</label> 
						</div> 
						<div class="form-row">
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-sm" id="inscricaoestadual" name="inscricaoestadual" value="${empresa.inscricaoestadual}" placeholder="Inscrição estadual">
							</div>
							
							<div class="col-sm-6">
								<input type="text" value="${empresa.cnpj}"	class="form-control form-control-sm" id="cnpj" name="cnpj" placeholder="cnpj">
							</div>
						</div>
						
						<div class="form-row">
							<label for="nome" class="col-sm-12 col-form-label col-form-label-sm">Responsável</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="responsavel" class="form-control form-control-sm" id="nome" 
								placeholder="Digite o nome do responsável" value="${empresa.responsavel}" required>
								<div class="valid-feedback">Tudo certo!</div>
							</div>
						</div>
						
						<div class="form-row">
							<label for="email" class="col-sm-12 col-form-label col-form-label-sm">E-mail</label>
						</div>
						<div class="form-row">
							<div class="col-sm-12 mb-0"> <input type="text" name="email" class="form-control form-control-sm" 
								id="email" placeholder="E-mail" value="${empresa.email}">
							</div>
						</div>
						
						<div class="form-row">
								<label for="site" class="col-sm-12 col-form-label col-form-label-sm">Site</label>
						</div>
						<div class="form-row">
							<div class="col-md-12 mb-0"> 
								<input type="text" name="site" class="form-control form-control-sm" 
									id="site" placeholder="Site" value="${empresa.site}">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
				
		<div class="form-row">
			<div class="col-sm-6 mb-3">
				<a href="main"><button type="Button" class="btn btn-primary btn-sm">Cancelar</button></a> 
			</div>
			<div class="col-sm-6 mb-0">
				<button type="submit" class="btn btn-primary btn-sm float-right">Salvar</button>
			</div>
		</div>
		
		<div class="form-row">
			<div class="col-md-12 mb-6">
<!-- 				<button class="btn btn-primary btn-sm btn-block" type="submit">Enviar</button> -->
			</div>
		</div>
		
	</form>
	

	<c:import url="../outros/import_footer.jsp"></c:import>
	
	<!-- Script do bootstrap -->
	<script>
		// Exemplo de JavaScript inicial para desativar envios de formulário, se houver campos inválidos.
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Pega todos os formulários que nós queremos aplicar estilos de validação Bootstrap personalizados.
						var forms = document
								.getElementsByClassName('needs-validation');
						// Faz um loop neles e evita o envio
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();

	</script>
	
	<!-- Script específico -->
	<script src='<c:url value = "/style_js/entidade.js"></c:url>'></script>
</body>
</html>