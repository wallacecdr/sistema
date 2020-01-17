package com.sistema.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade
        implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cidade_id_sequence")
    private Long id;
    @Column
    private int codigo;
    @Column
    private String nome;
    @Column
    private int idestado;
    @Column
    private int codigoibge;

    public Cidade() {
    }

    public Cidade(Long id, int codigo, int idestado, int codigoibge, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.idestado = idestado;
        this.codigoibge = codigoibge;
        this.nome = nome;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdestado() {
        return this.idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public int getCodigoibge() {
        return this.codigoibge;
    }

    public void setCodigoibge(int codigoibge) {
        this.codigoibge = codigoibge;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
