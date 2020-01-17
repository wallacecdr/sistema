<%@page import="java.util.ArrayList"%>
<%@page import="com.sistema.model.Estado"%>
<%@page import="java.util.List"%>
<%@page import="com.sistema.model.Entidade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="../outros/import_head.jsp"></c:import>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
 
</head>
<body id="page-top">
	<c:import url="../outros/menu.jsp" />

	<ol class="breadcrumb">
		<li class="breadcrumb-item active"><c:out value="${tipo}"></c:out></li>
	</ol>

	<form class="needs-validation" method="post" action="salvarEntidade">

		<div class="form-row">

			<!-- Inicia a div do form do lado esquerdo -->
			<div class="col-md-6 order-md-1">
				<div class="card mb-3">
					 <div class="card-body">
						<div class="form-row">
							<label for="id" class="col-sm-12 col-form-label col-form-label-sm">Código</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-3"> 
								<input type="text" name="id" readonly="readonly" class="form-control form-control-sm" 
									id="id" value="${entidade.id}">
							</div>
						</div>
						
						<div class="form-row">
							<label for="nome" class="col-sm-12 col-form-label col-form-label-sm">Nome</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="nome" class="form-control form-control-sm" id="nome" 
								placeholder="Digite seu nome" value="${entidade.nome}" required>
								<div class="valid-feedback">Tudo certo!</div>
							</div>
						</div>
						<div class="form-row">
							<label for="cep" class="col-sm-4 col-form-label col-form-label-sm">Cep</label> 
							<label for="estado" class="col-sm-2 col-form-label col-form-label-sm">Estado</label>
							<label for="pais" class="col-sm-6 col-form-label col-form-label-sm">País</label>
						</div>
						<div class="form-row">
							<div class="col-sm-4">
								<input type="text" name="cep" class="form-control form-control-sm" id="cep" placeholder="Cep"
									value="${entidade.cep}">
							</div>
							
							<div class="col-sm-2">
								<select class="form-control form-control-sm" name="estado" id="estado">
									<c:forEach var="estado" items="${estados}">
										<option value="${estado.codigo}" 
											<c:if test="${entidade.estado.codigo == estado.codigo}">selected="selected"</c:if> 
										>${estado.codigo}</option>
									</c:forEach>
								</select>
							</div>
							
							<div class="col-sm-6">
								<select class="form-control form-control-sm" name="pais" id="pais">
									<c:forEach var="pais" items="${paises}">
										<option value="${pais.nome}" 
											<c:if test="${entidade.pais.nome == pais.nome}">selected="selected"</c:if> 
										>${pais.nome}</option>
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
											<c:if test="${entidade.cidade.nome == cidade.nome}">selected="selected"</c:if> 
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
									id="endereco" placeholder="Endereço" value="${entidade.endereco}">
							</div>
							
							<div class="col-sm-2 mb-0">
								<input type="text" name="numero" class="form-control form-control-sm" 
									id="numero" placeholder="Nº" value="${entidade.numero}">
							</div>
						</div>
						
						<div class="form-row">
							<label for="complemento" class="col-sm-12 col-form-label col-form-label-sm">Complemento</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="complemento" class="form-control form-control-sm"  
									id="complemento" placeholder="Complemento"	value="${entidade.complemento}">
							</div>
						</div>
						
						<div class="form-row">
							<label for="bairro" class="col-sm-12 col-form-label col-form-label-sm">Bairro</label> 
						</div>
						<div class="form-row">
							<div class="col-sm-12"> 
								<input type="text" name="bairro"
									class="form-control form-control-sm" id="bairro" placeholder="Bairro" value="${entidade.bairro}">
								<div class="invalid-feedback">Por favor, informe um bairro
									válido.</div>
							</div>
						</div>
						<div class="form-row">
							<label for="pessoa" class="col-sm-12 col-form-label col-form-label-sm">Pessoa</label>
						</div>
						<div class="form-row">
							<div class="col-md-3 mb-4">
						  		<select onchange="alterarPainel()" name="pessoa" class="form-control form-control-sm" id="pessoa">
									<option value="">Física</option>
									<option>Jurídica</option>
								</select>
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
									id="fone" placeholder="Telefone" value="${entidade.fone}">
							</div>
							<div class="col-sm-6 mb-0">
								<input type="text" name="celular" class="form-control form-control-sm"
									 id="celular" placeholder="Celular" value="${entidade.celular}">
								<div class="invalid-feedback">Por favor, informe seu celular</div>
							</div>
						</div>
		
						<div class="form-row">
							<label for="email" class="col-sm-12 col-form-label col-form-label-sm">E-mail</label>
						</div>
						<div class="form-row">
							<div class="col-sm-12 mb-0"> <input type="text" name="email" class="form-control form-control-sm" 
								id="email" placeholder="E-mail" value="${entidade.email}">
							</div>
						</div>
						
						<div class="form-row">
								<label for="site" class="col-sm-12 col-form-label col-form-label-sm">Site</label>
						</div>
						<div class="form-row">
							<div class="col-md-12 mb-0"> 
								<input type="text" name="site" class="form-control form-control-sm" 
									id="site" placeholder="Site" value="${entidade.site}">
							</div>
						</div>
		
						<hr class="mb-2"></hr>
						<div class="form-row">
							<div class="col-md-2 mb-0">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" id="cliente" name="cliente" 
										<c:if test="${entidade.cliente == 1}">checked="checked"</c:if>
									>
									<label class="custom-control-label" for="cliente">Cliente</label>
								</div>
							</div>
							<div class="col-md-2 mb-0">
								<div class="custom-control custom-checkbox">
									<input type="checkbox" class="custom-control-input" name="fornecedor" id="fornecedor"
										<c:if test="${entidade.fornecedor == 1}">checked="checked"</c:if>
									> 
									<label class="custom-control-label"	for="fornecedor">Fornecedor</label>
								</div>
							</div>
						</div>
						<hr class="mb-2">
						
						<!-- Tabbed pane -->
						<div class="form-row">
						
							<div class="col-md-12 mb-0">
								<ul class="nav nav-tabs" id="myTab" role="tablist">
							    <li class="nav-item">
							      <a class="nav-link active" id="home-tab" onclick="alterarComboBox('fisica')" data-toggle="tab" href="#fisica" role="tab" aria-controls="home" aria-selected="true">Física</a>
							    </li>
							    <li class="nav-item">
							      <a class="nav-link" id="profile-tab" onclick="alterarComboBox('juridica')" data-toggle="tab" href="#juridica" role="tab" aria-controls="profile" aria-selected="false">Jurídica</a>
							    </li>
							  </ul>
							
							  <!-- Tab panes -->
							  <div class="tab-content" id="myTabContent">
							    <div class="tab-pane fade show active" id="fisica" role="tabpanel" aria-labelledby="home-tab"><br>
							      	<div class="form-row">
							      		
							      		<div class="col-md-6 order-md-1">
									      	<div class="col-md-11 mb-2">
									      		
								      			<div class="form-row">
													<label for="data" class="col-sm-12 col-form-label col-form-label-sm">Data de nascimento</label> 
								      			</div>
								      			<input class="form-control form-control-sm"  name="nascimento" 
								      				type="date" value="${entidade.nascimento}" id="nascimento">
								      			
								      			<div class="form-row">
								      				<label for="cpf" class="col-sm-12 col-form-label col-form-label-sm">Cpf</label> 
								      			</div>
												<input type="text" name="cpfcnpj" class="form-control form-control-sm" 
													id="cpf" placeholder="Cpf" value="${entidade.cpfcnpj}">
												
												<div class="form-row">	
													<label for="rg" class="col-sm-12 col-form-label col-form-label-sm">Rg</label>
												</div> 
												<input type="text" class="form-control form-control-sm" 
													id="rg" placeholder="Rg" value="${entidade.rg}">
											</div>
										</div>
										
										<div class="col-md-6 order-md-2">
											<div class="col-md-12 mb-0">
												
												<div class="form-row">
													<label for="tipocontribuintepj" class="col-sm-12 col-form-label col-form-label-sm">Tipo de contribuinte</label> 
												</div>
												<select
													class="form-control form-control-sm" id="tipocontribuintepj">
													<option value="">Não contribuinte</option>
													<option>Contribuinte Isento</option>
													<option>Contribuinte ICMS</option>
												</select>
												
												
												<div class="form-row">
													<label for="inscricaoestadualpj" class="col-sm-12 col-form-label col-form-label-sm">Inscrição estadual</label>
												</div> 
												<input type="text" class="form-control form-control-sm" 
													id="inscricaoestadualpj" placeholder="Inscrição estadual" value="${entidade.inscricaoestadual}">	
											</div>
										</div>
										
									</div>
							    </div>
							    
							    <div class="tab-pane fade" id="juridica" role="tabpanel" aria-labelledby="profile-tab"><br>
							      	<div class="form-row">
							      		
							      		<div class="col-md-6 order-md-1">
									      	<div class="col-md-11 mb-0">
									      		<div class="form-row">
													<label for="razaosocial" class="col-sm-12 col-form-label col-form-label-sm">Razão Social</label>
												</div> 
												<input type="text" class="form-control form-control-sm" 
													id="razaosocial" placeholder="Razão Social"	value="${entidade.razaosocial}">
												
												<div class="form-row">
													<label for="cnpj" class="col-sm-12 col-form-label col-form-label-sm">Cnpj</label> 
												</div>
												<input type="text" name="cpfcnpj"
													class="form-control form-control-sm" id="cnpj" placeholder="cnpj">
											</div>
										</div>
										
										<div class="col-md-6 order-md-2">
											<div class="col-md-12 mb-0">
												<div class="form-row">
													<label for="tipocontribuinte" class="col-sm-12 col-form-label col-form-label-sm">Tipo de contribuinte</label> 
												</div>
												<select
													class="form-control form-control-sm" id="tipocontribuinte">
													<option value="">Não contribuinte</option>
													<option>Contribuinte Isento</option>
													<option>Contribuinte ICMS</option>
												</select>
												
												<div class="form-row">
													<label for="inscricaoestadual" class="col-sm-12 col-form-label col-form-label-sm">Inscrição estadual</label> 
												</div>
												<input type="text"
													class="form-control form-control-sm" id="inscricaoestadual" placeholder="Inscrição estadual" value="${entidade.inscricaoestadual}">	
											</div>
										</div>
										</div>
									</div>
							    </div>
							  </div>
							</div>
					</div>
			</div>
		</div>
		</div>
		
				
		<div class="form-row">
			<div class="col-sm-12 mb-3">
				<button type="submit" class="btn btn-primary btn-sm">Salvar</button>
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
	<script>
		/*Máscaras*/
		$('#cep').mask("99.999-999");
		$('#cpf').mask("999.999.999-99");
		$('#cnpj').mask("99.999.999/9999-99");
		$('#fone').mask("(99)9999-9999");
		$('#celular').mask("(99)99999-9999");
		
		/*Insere a data atual no campo nascimento
		var todayDate = new Date().toISOString().slice(0, 10);
		document.getElementById('nascimento').value = todayDate;*/
		
		/*Função que altera o painel de dados para pessoa física ou jurídica*/
		function alterarPainel(){
			
			var e = document.getElementById("pessoa");
			var itemSelecionado = e.options[e.selectedIndex].value;

			if(itemSelecionado == "Jurídica"){
				$('#myTab a[href="#juridica"]').tab('show')
			}else{
				$('#myTab a[href="#fisica"]').tab('show')
			}
		}
		
		/*Função que altera o combobox de acordo com a aba selecionada no tabbedpane*/
		function alterarComboBox(tipoPessoa){
			
			var e = document.getElementById("pessoa");
			
			if(tipoPessoa == "fisica"){
				e.value = e.options[0].value;	
			}else{
				e.value = e.options[1].value;
			}
		}
	</script>
	
	<!-- JavaScript ViaCep -->
    <script type="text/javascript" >

        $(document).ready(function() {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#ender").val("");
                $("#bairro").val("");
                //$("#cidade").val("");
                $("#estado").val("");
                //$("#ibge").val("");
            }
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {
      

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#estado").val("...");
                        $("#ibge").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                var endereco = dados.logradouro;
                                var cidade = dados.localidade;
                                var estado = dados.uf;
                                
                                $("#endereco").val(endereco.toUpperCase());
                                $("#bairro").val(dados.bairro);
                                $("#estado").val(estado.toUpperCase());
//                                 $("#cidade").val(cidade.toUpperCase());
								setCidade(cidade.toUpperCase());
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });
    </script>
    <script type="text/javascript">	
    
    	/*Função para setar a cidade quando*/
    	function setCidade(city){
   			var base_url = "/getCidades";
			$.get("${pageContext.request.contextPath}/getCidades?codEstado="+$('#estado').val(), function(responseJson) {
   				var $select = $("#cidade");
                   $select.find("option").remove(); 
                   $.each(responseJson, function(index, cidade) {
                   	   if(cidade.nome != city){
                       		$("<option>").val(cidade.nome).text(cidade.nome).appendTo($select);
                       }else{
                       		$("<option>").val(cidade.nome).text(cidade.nome).attr('selected','selected').appendTo($select);
                       }
                   });                   
                    
               });
    	}
    
    	$(function(){
    		var base_url = "/getCidades";
			$('#estado').change(function(){
// 				$.get("${pageContext.request.contextPath}/getCidades?codEstado="+$('#estado').val(), function(responseJson) {
//     				var $select = $("#cidade");
//                     $select.find("option").remove();  
//                     $.each(responseJson, function(index, cidade) {
//                         $("<option>").val(cidade.nome).text(cidade.nome).appendTo($select);
//                     });                   
                     
//                 });
				setCidade("");
    		});
    	});	
    </script>
</body>
</html>