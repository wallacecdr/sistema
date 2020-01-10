package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pais")
public class Pais
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pais_id_sequence")
    private int id;
    @Column
    private String nome;
    @Column
    private int codigoibge;

    public Pais() {
    }

    public Pais(int id, String nome, int codigoibge) /*    */ {
        this.id = id;
        this.nome = nome;
        this.codigoibge = codigoibge;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoibge() {
        return this.codigoibge;
    }

    public void setCodigoibge(int codigoibge) {
        this.codigoibge = codigoibge;
    }
}
