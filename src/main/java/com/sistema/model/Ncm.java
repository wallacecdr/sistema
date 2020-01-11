/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author Wallace
 */
@Entity
@Table(name = "Ncm")
public class Ncm implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ncm_id_sequence")
    private Long id;
    @Column(length = 10)
    private String codigo;
    @Column(length = 3)
    private String codigoexcecao;
    @Column
    @Type(type = "text")
    private String descricao;
    @Column(precision = 5, scale = 2)
    private BigDecimal percentualmva;
    @Column(precision = 5, scale = 2)
    private BigDecimal percentualreducaomva;
    @Column(precision = 5, scale = 2)
    private BigDecimal percentualimpostoaproximado;
    @Column(precision = 5, scale = 2)
    private BigDecimal percimpostoaproximportacao;
    @Column
    private short tipo;
    @Column
    private short inativo;

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

    public String getCodigoexcecao() {
        return codigoexcecao;
    }

    public void setCodigoexcecao(String codigoexcecao) {
        this.codigoexcecao = codigoexcecao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPercentualmva() {
        return percentualmva;
    }

    public void setPercentualmva(BigDecimal percentualmva) {
        this.percentualmva = percentualmva;
    }

    public BigDecimal getPercentualreducaomva() {
        return percentualreducaomva;
    }

    public void setPercentualreducaomva(BigDecimal percentualreducaomva) {
        this.percentualreducaomva = percentualreducaomva;
    }

    public BigDecimal getPercentualimpostoaproximado() {
        return percentualimpostoaproximado;
    }

    public void setPercentualimpostoaproximadomva(BigDecimal percentualimpostoaproximadomva) {
        this.percentualimpostoaproximado = percentualimpostoaproximadomva;
    }

    public BigDecimal getPercimpostoaproximportacao() {
        return percimpostoaproximportacao;
    }

    public void setPercimpostoaproximportacao(BigDecimal percimpostoaproximportacao) {
        this.percimpostoaproximportacao = percimpostoaproximportacao;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public short getInativo() {
        return inativo;
    }

    public void setInativo(short inativo) {
        this.inativo = inativo;
    }
}
