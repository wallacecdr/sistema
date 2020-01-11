/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Wallace
 */
@Entity
@Table(name = "Unidademedida")
public class Unidademedida implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "unidademedida_id_sequence")
    private Long id;
    @Column(length = 10)
    private String codigo;
    @Column(length = 100)
    private String nome;
    @Column
    private int casasdecimais; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCasasdecimais() {
        return casasdecimais;
    }

    public void setCasasdecimais(int casasdecimais) {
        this.casasdecimais = casasdecimais;
    }
}
