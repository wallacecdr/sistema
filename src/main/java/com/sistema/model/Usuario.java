package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario
        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "usuario_id_sequence")
    private long id;
    @Column(length = 30, nullable = false)
    private String usuario;
    @Column(length = 255, nullable = false)
    private String pass;
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 60)
    private String celular;
    @Column(columnDefinition = "smallint default 0", nullable = false)
    private int inativo;
    @Column(columnDefinition = "smallint default 0", nullable = false)
    private int alterasenhaproximologin;

    public Usuario() {
    }

    public Usuario(long id, String user, String pass) {
        this.id = id;
        this.usuario = user;
        this.pass = pass;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String user) {
        this.usuario = user;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public int getAlterasenhaproximologin() {
        return alterasenhaproximologin;
    }

    public void setAlterasenhaproximologin(int alterasenhaproximologin) {
        this.alterasenhaproximologin = alterasenhaproximologin;
    }
}

