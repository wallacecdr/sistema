package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cep")
public class Cep
        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cep_id_sequence")
    private Long id;
    @Column
    private String endereco;
    @Column
    private String bairro;
    @Column
    private Long idcidade;
    @Column
    private Long idmunicipio;
    @Column
    private String cep;

    public Cep() {
    }

    public Cep(Long id, String endereco, String bairro, Long idcidade, Long idmunicipio, String cep) {
        this.id = id;
        this.endereco = endereco;
        this.bairro = bairro;
        this.idcidade = idcidade;
        this.idmunicipio = idmunicipio;
        this.cep = cep;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getIdcidade() {
        return this.idcidade;
    }

    public void setIdcidade(Long idcidade) {
        this.idcidade = idcidade;
    }

    public Long getIdmunicipio() {
        return this.idmunicipio;
    }

    public void setIdmunicipio(Long idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
