package com.sistema.model;
// Generated 20/07/2018 20:42:39 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "entidade")
public class Entidade implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO, generator = "entidade_id_sequence")
     private Long id;
     @ManyToOne
     private Estado estado;
     @ManyToOne
     private Pais pais;
     @ManyToOne
     private Cidade cidade;
     @Column(length = 10)
     private String codigo;
     @Column(length = 50)
     private String nome;
     @Column(columnDefinition = "smallint default 0")
     private int inativo;
     @Column(length = 20)
     private String cep;
     @Column(length = 50)
     private String endereco;
     @Column(length = 10)
     private String numero;
     @Column(length = 50)
     private String complemento;
     @Column(length = 50)
     private String bairro;
     @Column
     private int tipopessoa;
     @Column(length = 20)
     private String fone;
     @Column(length = 20)
     private String celular;
     @Column(length = 50)
     private String email;
     @Column(length = 50)
     private String site;
     @Column(length = 40)
     private String nascimento;
     @Column(length = 20)
     private String cpfcnpj;
     @Column
     private int tipocontribuinte;
     @Column(length = 20)
     private String inscricaoestadual;
     @Column(length = 20)
     private String rg;
     @Column(columnDefinition = "smallint default 0")
     private int cliente;
     @Column(columnDefinition = "smallint default 0")
     private int fornecedor;
     @Column(length = 60)
     private String razaosocial;

    public Entidade() {
    }

	
    public Entidade(Long id) {
        this.id = id;
    }
    public Entidade(Long id, String codigo, String nome, Short inativo, String cep, Estado estado,
            Pais pais, Cidade cidade, String endereco, String numero, String complemento,
            String bairro, Short tipopessoa, String fone, String celular, String email, String site,
            String nascimento, String cpfcnpj, Short tipocontribuinte, String inscricaoestadual, String rg,
            String razaosocial) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.inativo = inativo;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.tipopessoa = tipopessoa;
        this.fone = fone;
        this.celular = celular;
        this.email = email;
        this.site = site;
        this.nascimento = nascimento;
        this.cpfcnpj = cpfcnpj;
        this.tipocontribuinte = tipocontribuinte;
        this.inscricaoestadual = inscricaoestadual;
        this.rg = rg;
        this.razaosocial = razaosocial;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getInativo() {
        return this.inativo;
    }
    
    public void setInativo(int inativo) {
        this.inativo = inativo;
    }
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Estado getEstado() {
        return this.estado;
    }
    
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    public Pais getPais() {
        return this.pais;
    }
    
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public Cidade getCidade() {
        return this.cidade;
    }
    
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getTipopessoa() {
        return this.tipopessoa;
    }
    
    public void setTipopessoa(int tipopessoa) {
        this.tipopessoa = tipopessoa;
    }
    public String getFone() {
        return this.fone;
    }
    
    public void setFone(String fone) {
        this.fone = fone;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSite() {
        return this.site;
    }
    
    public void setSite(String site) {
        this.site = site;
    }
    public String getNascimento() {
        return this.nascimento;
    }
    
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public String getCpfcnpj() {
        return this.cpfcnpj;
    }
    
    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }
    public int getTipocontribuinte() {
        return this.tipocontribuinte;
    }
    
    public void setTipocontribuinte(int tipocontribuinte) {
        this.tipocontribuinte = tipocontribuinte;
    }
    public String getInscricaoestadual() {
        return this.inscricaoestadual;
    }
    
    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }
    public String getRg() {
        return this.rg;
    }
    
    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaoSocial) {
        this.razaosocial = razaoSocial;
    }
    
    
    


}


