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
        <script>
            $(document).on("click", "#buttonLoad", function() {
                $.get("listajax", function(responseJson) {
                    var $select = $("#dropdownlist");
                    $select.find("option").remove();  
                    $.each(responseJson, function(index, category) {
                        $("<option>").val(category.id).text(category.name).appendTo($select);
                    });                   
                     
                });
            });
             
            $(document).on("click", "#buttonSubmit", function() {
                var params = {category : $("#dropdownlist option:selected").text()};
                $.post("listajax", $.param(params), function(responseText) {
                    alert(responseText);                   
                });
            });
        </script>
 
</head>
<body id="page-top">
	<c:import url="../outros/menu.jsp" />

	<ol class="breadcrumb">
		<li class="breadcrumb-item active"><c:out value="${tipo}"></c:out></li>
	</ol>

	<form class="needs-validation" method="post" action="salvarEntidade">
		
		<div class="form-group row">

			<!-- Inicia a div do form do lado esquerdo -->
			<div class="col-md-6 order-md-1">
				<div class="form-group row">
					<label for="codigo" class="col-sm-1 col-form-label col-form-label-sm">Código</label>
					<div class="col-sm-2"> 
						<input type="text" name="id" readonly="readonly" class="form-control form-control-sm" id="codigo" value="${entidade.id}">
					</div>
				</div>
				<div class="form-group row">
					<label for="nome" class="col-sm-1 col-form-label col-form-label-sm">Nome</label>
					<div class="col-sm-10"> 
						<input type="text" name="nome" class="form-control form-control-sm" id="nome" 
						placeholder="Digite seu nome" value="${entidade.nome}" required>
						<div class="valid-feedback">Tudo certo!</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label for="cep">Cep</label> <input type="text" name="cep"
							class="form-control form-control-sm" id="cep" placeholder="Cep"
							value="${entidade.cep}">
						<div class="invalid-feedback">Por favor, informe seu cep.</div>
					</div>
					<div class="col-md-3 mb-3">
						<div class="ui-widget">
							<label for="estado">Estado</label>
							<select class="form-control form-control-sm" name="estado" id="estado">
								<c:forEach var="estado" items="${estados}">
									<option value="${estado.codigo}" 
										<c:if test="${entidade.estado.codigo == estado.codigo}">selected="selected"</c:if> 
									>${estado.codigo}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="col-md-5 mb-3">
						<div class="ui-widget">
							<label for="pais">País</label>
							<select class="form-control" name="pais" id="pais">
								<c:forEach var="pais" items="${paises}">
									<option value="${pais.nome}" 
										<c:if test="${entidade.pais.nome == pais.nome}">selected="selected"</c:if> 
									>${pais.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-11 mb-3">
						<div class="ui-widget">
							<label for="cidade">Cidade</label>
							<select class="form-control" name="cidade" id="cidade" data-size="auto">
								<c:forEach var="cidade" items="${cidades}">
									<option value="${cidade.nome}" 
										<c:if test="${entidade.cidade.nome == cidade.nome}">selected="selected"</c:if> 
									>${cidade.nome}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-9 mb-3">
						<label for="endereco">Endereço</label> <input type="text" name="endereco"
							class="form-control" id="endereco" placeholder="Endereço" value="${entidade.endereco}">
						<div class="invalid-feedback">Por favor, informe um endereço
							válido.</div>
					</div>
					<div class="col-md-2 mb-3">
						<label for="numero">Número</label> <input type="text" name="numero"
							class="form-control" id="numero" placeholder="Nº" value="${entidade.numero}">
						<div class="invalid-feedback">Por favor, informe um numero
							válido.</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-11 mb-3">
						<label for="complemento">Complemento</label> <input type="text" name="complemento"
							class="form-control" id="complemento" placeholder="Complemento"	value="${entidade.complemento}">
						<div class="invalid-feedback">Por favor, informe um
							complemento válido.</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-11 mb-3">
						<label for="bairro">Bairro</label> <input type="text" name="bairro"
							class="form-control" id="bairro" placeholder="Bairro" value="${entidade.bairro}">
						<div class="invalid-feedback">Por favor, informe um bairro
							válido.</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-3 mb-3">
						<label for="pessoa">Pessoa</label> <select onchange="alterarPainel()" name="pessoa"
							class="custom-select d-block w-100" id="pessoa">
							<option value="">Física</option>
							<option>Jurídica</option>
						</select>
					</div>
				</div>
			</div>

			<!-- Inicia a div do form do lado direito -->
			<div class="col-md-6 order-md-2">

				<div class="form-row">
					<div class="col-md-6 mb-3">
						<label for="fone">Telefone</label> <input type="text" name="fone"
							class="form-control" id="fone" placeholder="Telefone" value="${entidade.fone}">
						<div class="invalid-feedback">Por favor, informe seu
							telefone.</div>
					</div>
					<div class="col-md-6 mb-3">
						<label for="celular">Celular</label> <input type="text" name="celular"
							class="form-control" id="celular" placeholder="Celular" value="${entidade.celular}">
						<div class="invalid-feedback">Por favor, informe seu celular</div>
					</div>
				</div>

				<div class="form-row">
					<div class="col-md-12 mb-3">
						<label for="email">E-mail</label> <input type="text" name="email"
							class="form-control" id="email" placeholder="E-mail" value="${entidade.email}">
						<div class="invalid-feedback">Por favor, informe seu e-mail.</div>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-12 mb-3">
						<label for="site">Site</label> <input type="text" name="site"
							class="form-control" id="site" placeholder="Site" value="${entidade.site}">
						<div class="invalid-feedback">Por favor, informe seu site.</div>
					</div>
				</div>

				<hr class="mb-4"></hr>
				<div class="form-row">
					<div class="col-md-2 mb-3">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" id="cliente" name="cliente" 
								<c:if test="${entidade.cliente == 1}">checked="checked"</c:if>
							>
							<label class="custom-control-label" for="cliente">Cliente</label>
						</div>
					</div>
					<div class="col-md-2 mb-3">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input" name="fornecedor" id="fornecedor"
								<c:if test="${entidade.fornecedor == 1}">checked="checked"</c:if>
							> 
							<label class="custom-control-label"	for="fornecedor">Fornecedor</label>
						</div>
					</div>
				</div>
				<hr class="mb-4">
				
				<!-- Tabbed pane -->
				<div class="form-row">
				
					<div class="col-md-12 mb-3">
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
							      	<div class="col-md-11 mb-3">
										<label for="data">Data de nascimento</label> <input class="form-control"  name="nascimento"
										type="date" value="${entidade.nascimento}" id="nascimento">
										
										<label for="cpf">Cpf</label> <input type="text" name="cpfcnpj"
											class="form-control" id="cpf" placeholder="Cpf"
											value="${entidade.cpfcnpj}">
											
										<label for="rg">RG</label> <input type="text"
											class="form-control" id="rg" placeholder="Rg" value="${entidade.rg}">
									</div>
								</div>
								
								<div class="col-md-6 order-md-2">
									<div class="col-md-12 mb-3">
										<label for="tipocontribuintepj">Tipo de contribuinte</label> <select
											class="custom-select d-block w-100" id="tipocontribuintepj">
											<option value="">Não contribuinte</option>
											<option>Contribuinte Isento</option>
											<option>Contribuinte ICMS</option>
										</select>
										
										<label for="inscricaoestadualpj">Inscrição estadual</label> <input type="text"
											class="form-control" id="inscricaoestadualpj" placeholder="Inscrição estadual" value="${entidade.inscricaoestadual}">	
									</div>
								</div>
								
							</div>
					    </div>
					    
					    <div class="tab-pane fade" id="juridica" role="tabpanel" aria-labelledby="profile-tab"><br>
					      	<div class="form-row">
					      		
					      		<div class="col-md-6 order-md-1">
							      	<div class="col-md-11 mb-3">
										<label for="razaosocial">Razão Social</label> <input type="text"
											class="form-control" id="razaosocial" placeholder="Razão Social"
											value="${entidade.razaosocial}">
										
										<label for="cnpj">Cnpj</label> <input type="text" name="cpfcnpj"
											class="form-control" id="cnpj" placeholder="cnpj"
											>
									</div>
								</div>
								
								<div class="col-md-6 order-md-2">
									<div class="col-md-12 mb-3">
										<label for="tipocontribuinte">Tipo de contribuinte</label> <select
											class="custom-select d-block w-100" id="tipocontribuinte">
											<option value="">Não contribuinte</option>
											<option>Contribuinte Isento</option>
											<option>Contribuinte ICMS</option>
										</select>
										
										<label for="inscricaoestadual">Inscrição estadual</label> <input type="text"
											class="form-control" id="inscricaoestadual" placeholder="Inscrição estadual" value="${entidade.inscricaoestadual}">	
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
			<div class="col-md-12 mb-3">
				<button class="btn btn-primary btn-lg btn-block" type="submit">Enviar</button>
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