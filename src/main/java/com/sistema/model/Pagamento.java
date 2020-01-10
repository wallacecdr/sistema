package com.sistema.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Wallace Caldeira
 */
@Entity
@Table(name = "Pagamento")
public class Pagamento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pagamento_id_sequence")
    private Long id;
    @OneToOne
    private Operacao operacao;
    @Column(columnDefinition = "smallint", nullable = false)
    private int contador;
    @Column(columnDefinition = "smallint")
    private int finalizador;
    @Column(precision = 12, scale = 2)
    private BigDecimal valortotal;
    @Column(precision = 12, scale = 2)
    private BigDecimal valorparcela;
    @Column(precision = 12, scale = 2)
    private BigDecimal troco;
    @Column(columnDefinition = "smallint")
    private int totalparcelas;
    @Column(columnDefinition = "smallint")
    private int numeroparcela;
    @Column(length = 60)
    private String documento;
    @Column(length = 60)
    private String nomeFinalizador;
    @Column(columnDefinition = "smallint")
    private int eTroco;
    
    
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

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getFinalizador() {
        return finalizador;
    }

    public void setFinalizador(int finalizador) {
        this.finalizador = finalizador;
    }

    public BigDecimal getValortotal() {
        return valortotal;
    }

    public void setValortotal(BigDecimal valortotal) {
        this.valortotal = valortotal;
    }

    public BigDecimal getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(BigDecimal valorparcela) {
        this.valorparcela = valorparcela;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public int getTotalparcelas() {
        return totalparcelas;
    }

    public void setTotalparcelas(int totalparcelas) {
        this.totalparcelas = totalparcelas;
    }

    public int getNumeroparcela() {
        return numeroparcela;
    }

    public void setNumeroparcela(int numeroparcela) {
        this.numeroparcela = numeroparcela;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNomeFinalizador() {
        return nomeFinalizador;
    }

    public void setNomeFinalizador(String nomeFinalizador) {
        this.nomeFinalizador = nomeFinalizador;
    }

    public int geteTroco() {
        return eTroco;
    }

    public void seteTroco(int eTroco) {
        this.eTroco = eTroco;
    }
}
