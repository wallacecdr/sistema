package com.sistema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa
        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "empresa_id_sequence")
    private Long id;
	
	@ManyToOne
    private Estado estado;
    @ManyToOne
    private Cidade cidade;
    
    @Column(length = 4)
    private String codigo;
    @Column
    private int enquadramento;
    @Column(length = 60)
    private String razaosoc;
    @Column(length = 60)
    private String nome;
    @Column(length = 10)
    private String cep;
    @Column(length = 50)
    private String endereco;
    @Column(length = 6)
    private String numero;
    @Column(length = 50)
    private String complemento;
    @Column(length = 50)
    private String bairro;
    @Column(length = 16)
    private String fone;
    @Column(length = 16)
    private String celular;
    @Column(length = 18)
    private String cnpj;
    @Column(length = 17)
    private String inscricaoestadual;
    @Column(length = 50)
    private String responsavel;
    @Column(length = 200)
    private String email;
    @Column(length = 200)
    private String site;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazaosoc() {
        return this.razaosoc;
    }

    public void setRazaosoc(String razaosoc) {
        this.razaosoc = razaosoc;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
		return celular;
	}
    
    public void setCelular(String celular) {
		this.celular = celular;
	}
    
    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getEnquadramento() {
        return enquadramento;
    }

    public void setEnquadramento(int enquadramento) {
        this.enquadramento = enquadramento;
    }

    public String getInscricaoestadual() {
        return inscricaoestadual;
    }

    public void setInscricaoestadual(String inscricaoestadual) {
        this.inscricaoestadual = inscricaoestadual;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
