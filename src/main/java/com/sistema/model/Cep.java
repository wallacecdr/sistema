package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cep")
public class Cep
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cep_id_sequence")
    private long id;
    @Column
    private String endereco;
    @Column
    private String bairro;
    @Column
    private long idcidade;
    @Column
    private long idmunicipio;
    @Column
    private String cep;

    public Cep() {
    }

    public Cep(long id, String endereco, String bairro, long idcidade, long idmunicipio, String cep) {
        this.id = id;
        this.endereco = endereco;
        this.bairro = bairro;
        this.idcidade = idcidade;
        this.idmunicipio = idmunicipio;
        this.cep = cep;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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

    public long getIdcidade() {
        return this.idcidade;
    }

    public void setIdcidade(long idcidade) {
        this.idcidade = idcidade;
    }

    public long getIdmunicipio() {
        return this.idmunicipio;
    }

    public void setIdmunicipio(long idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
