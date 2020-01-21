/*Máscaras*/
$('#cep').mask("99.999-999");
$('#rg').mask("99.999.999-9");
$('#cpf').mask("999.999.999-99");
$('#cnpj').mask("99.999.999/9999-99");
$('#fone').mask("(99)9999-9999");
$('#celular').mask("(99)99999-9999");
$('#inscricaoestadualpf').mask("99999999999");
$('#inscricaoestadualpj').mask("99999999999");

$('#tipocontribuintepf').change(function() {

	var selecionado = $(this).children('option:selected').val();
	var iepf = document.querySelector("#inscricaoestadualpf");

	if (selecionado == '9') {
		iepf.setAttribute('readonly', 'readonly');
	} else {
		iepf.removeAttribute('readonly');
	}
});

$('#tipocontribuintepj').change(function() {

	var selecionado = $(this).children('option:selected').val();
	var iepf = document.querySelector("#inscricaoestadualpj");

	if (selecionado == '9') {
		iepf.setAttribute('readonly', 'readonly');
	} else {
		iepf.removeAttribute('readonly');
	}
});

$('#tipocontribuintepf').change(function() {

	var selecionado = $(this).children('option:selected').val();
	var iepf = document.querySelector("#inscricaoestadualpf");

	if (selecionado == '9') {
		iepf.setAttribute('readonly', 'readonly');
	} else {
		iepf.removeAttribute('readonly');
	}
});

$('#estado').change(function() {

	var estado = document.querySelector('#estado');

	setCidade("");
	setarPais(estado.value);
});

/*
 * Insere a data atual no campo nascimento var todayDate = new
 * Date().toISOString().slice(0, 10);
 * document.getElementById('nascimento').value = todayDate;
 */

/* Função que altera o painel de dados para pessoa física ou jurídica */

function alterarPainel() {

	var e = document.getElementById("tipopessoa");
	var itemSelecionado = e.options[e.selectedIndex].value;

	if (itemSelecionado == "0") {
		$('#myTab a[href="#fisica"]').tab('show')
	} else {
		$('#myTab a[href="#juridica"]').tab('show')
	}
};


/* Altera o combobox de acordo com a aba selecionada no tabbedpane */
function alterarComboBox(tipoPessoa) {

	var e = document.getElementById("tipopessoa");

	if (tipoPessoa == "fisica") {
		e.value = e.options[0].value;
	} else {
		e.value = e.options[1].value;
	}
}

function setarPais(estado) {

	var pais = document.querySelector('#pais');

	if (estado != 'EX') {
		pais.value = 'BRASIL';
		pais.setAttribute('disabled', true);
	} else {
		pais.removeAttribute('disabled');
	}
}

/* Seleciona a cidade no combobox, conforme passado por parâmetro */
function setCidade(city) {
	var base_url = "/getCidades";
	$.get("/sistema/getCidades?codEstado="
			+ $('#estado').val(), function(responseJson) {
		var $select = $("#cidade");
		$select.find("option").remove();
		$.each(responseJson, function(index, cidade) {
			if (cidade.nome != city) {
				$("<option>").val(cidade.nome).text(cidade.nome).appendTo(
						$select);
				console.log('Entrou');
			} else {
				$("<option>").val(cidade.nome).text(cidade.nome).attr(
						'selected', 'selected').appendTo($select);
				console.log('Saiu');
			}
		});

	});
}

/* Script ViaCep */
$(document).ready(
		function() {

			function limpa_formulário_cep() {
				// Limpa valores do formulário de cep.
				$("#ender").val("");
				$("#bairro").val("");
				// $("#cidade").val("");
				$("#estado").val("");
				// $("#ibge").val("");
			}

			// Quando o campo cep perde o foco.
			$("#cep").blur(
					function() {

						// Nova variável "cep" somente com dígitos.
						var cep = $(this).val().replace(/\D/g, '');

						// Verifica se campo cep possui valor informado.
						if (cep != "") {

							// Expressão regular para validar o CEP.
							var validacep = /^[0-9]{8}$/;

							// Valida o formato do CEP.
							if (validacep.test(cep)) {

								// Preenche os campos com "..." enquanto
								// consulta webservice.
								$("#rua").val("...");
								$("#bairro").val("...");
								$("#cidade").val("...");
								$("#estado").val("...");
								$("#ibge").val("...");

								// Consulta o webservice viacep.com.br/
								$.getJSON("https://viacep.com.br/ws/" + cep
										+ "/json/?callback=?", function(dados) {

									if (!("erro" in dados)) {
										// Atualiza os campos com os valores da
										// consulta.
										var endereco = dados.logradouro;
										var cidade = dados.localidade;
										var estado = dados.uf;

										$("#endereco").val(
												endereco.toUpperCase());
										$("#bairro").val(dados.bairro);
										$("#estado").val(estado.toUpperCase());
										setCidade(cidade.toUpperCase());
										$("#ibge").val(dados.ibge);
										setarPais(estado.toUpperCase());
									} // end if.
									else {
										// CEP pesquisado não foi encontrado.
										limpa_formulário_cep();
										alert("CEP não encontrado.");
									}
								});
							} // end if.
							else {
								// cep é inválido.
								limpa_formulário_cep();
								alert("Formato de CEP inválido.");
							}
						} // end if.
						else {
							// cep sem valor, limpa formulário.
							limpa_formulário_cep();
						}
					});
		});