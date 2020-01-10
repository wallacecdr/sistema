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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Wallace
 */
@Entity
@Table(name = "Item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "item_id_sequence")
    private Long id;
    @ManyToOne
    private Operacao operacao;
    @ManyToOne
    private Produto produto;
    @Column(columnDefinition = "smallint", nullable = false)
    private int contador;
    @Column(precision = 15, scale = 6)
    private BigDecimal quantidade;
    @Column(precision = 12, scale = 2)
    private BigDecimal precounitario;
    @Column(precision = 12, scale = 2)
    private BigDecimal descontoitem;
    @Column(precision = 12, scale = 2)
    private BigDecimal precobruto;
    @Column(precision = 12, scale = 2)
    private BigDecimal precoliquido;
    @Column(columnDefinition = "smallint")
    private int cancelado;
    @Column(length = 10)
    private String usuariodescontoitem;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecounitario() {
        return precounitario;
    }

    public void setPrecounitario(BigDecimal precounitario) {
        this.precounitario = precounitario;
    }

    public BigDecimal getDescontoitem() {
        return descontoitem;
    }

    public void setDescontoitem(BigDecimal descontoitem) {
        this.descontoitem = descontoitem;
    }

    public BigDecimal getPrecobruto() {
        return precobruto;
    }

    public void setPrecobruto(BigDecimal precobruto) {
        this.precobruto = precobruto;
    }

    public BigDecimal getPrecoliquido() {
        return precoliquido;
    }

    public void setPrecoliquido(BigDecimal precoliquido) {
        this.precoliquido = precoliquido;
    }

    public int getCancelado() {
        return cancelado;
    }

    public void setCancelado(int cancelado) {
        this.cancelado = cancelado;
    }

    public String getUsuariodescontoitem() {
        return usuariodescontoitem;
    }

    public void setUsuariodescontoitem(String usuariodescontoitem) {
        this.usuariodescontoitem = usuariodescontoitem;
    }
}
