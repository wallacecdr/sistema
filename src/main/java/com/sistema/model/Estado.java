package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Estado")
public class Estado
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "estado_id_sequence")
    private int id;
    @Column
    private String codigo;
    @Column
    private String nome;
    @Column
    private int codigoibge;
    @Column
    private int idpais;

    public Estado() {
    }

    public Estado(int id, String codigo, String nome, int codigoibge, int idpais) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.codigoibge = codigoibge;
        this.idpais = idpais;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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
        /*     */    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdpais() {
        return this.idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public int getCodigoibge() {
        return this.codigoibge;
    }

    public void setCodigoibge(int codigoibge) {
        this.codigoibge = codigoibge;
    }
}
