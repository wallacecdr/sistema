/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.model;

/**
 *
 * @author Wallace
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sistema")
public class Sistema
        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sistema_id_sequence")
    private long id;
    @Column
    private String nome;
    @Column
    private String versao;
    @Column
    private int controle;

    public Sistema() {
    }

    public Sistema(long id, String nome, String versao, int controle) {
        this.id = id;
        this.nome = nome;
        this.versao = versao;
        this.controle = controle;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return this.versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public int getControle() {
        return this.controle;
    }

    public void setControle(int controle) {
        this.controle = controle;
    }
}
