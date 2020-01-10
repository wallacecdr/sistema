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
@Table(name = "Produto")
public class Produto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "produto_id_sequence")
    @Column(columnDefinition = "bigserial")
    private int id;
    @ManyToOne
    private Unidademedida unidademedida;
    @ManyToOne
    private Entidade fornecedor;
    @Column(length = 20, nullable = false)
    private String codigo;
    @Column(length = 20)
    private String ean;
    @Column(columnDefinition = "smallint default 0", insertable = true, updatable = true)
    private short inativo;
    @Column(length = 120)
    private String nome;
    @Column(length = 120)
    private String nomeecf;
    @Column(length = 10)
    private String preco;
    @Column(length = 10)
    private String custo;
    @Column(length = 2)
    private String tipoproduto;
    @Column(length = 1)
    private String ippt;
    @Column
    private short origem;
    @Column(length = 10)
    private String ncm;
    @Column
    private String observacao;
    @Column(length = 7)
    private String tributacao;
    @Column(precision = 5, scale = 2)
    private BigDecimal aliquotaicmsinterna;
    @Column(precision = 5, scale = 2)
    private BigDecimal aliquotafcp;
    @Column(length = 3)
    private String situacaotributaria;
    @Column(length = 3)
    private String situacaotributariaentrada;
    @Column(length = 2)
    private String cstpis;
    @Column(length = 2)
    private String cstcofins;
    @Column(length = 2)
    private String cstpisentrada;
    @Column(length = 2)
    private String cstcofinsentrada;
    @Column(precision = 12, scale = 4)
    private BigDecimal aliquotapis;
    @Column(precision = 12, scale = 4)
    private BigDecimal aliquotacofins;
    @Column(precision = 12, scale = 4)
    private BigDecimal aliquotapisentrada;
    @Column(precision = 12, scale = 4)
    private BigDecimal aliquotacofinsentrada;
    @Column(precision = 5, scale = 2)
    private BigDecimal percredbasepiscofinssaida;
    @Column(precision = 5, scale = 2)
    private BigDecimal percredbasepiscofinsentrada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public short getInativo() {
        return inativo;
    }

    public void setInativo(short inativo) {
        this.inativo = inativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeecf() {
        return nomeecf;
    }

    public void setNomeecf(String nomeecf) {
        this.nomeecf = nomeecf;
    }

    public Unidademedida getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(Unidademedida idunidademedida) {
        this.unidademedida = idunidademedida;
    }

    public Entidade getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Entidade idfornecedor) {
        this.fornecedor = idfornecedor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCusto() {
        return custo;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public String getTipoproduto() {
        return tipoproduto;
    }

    public void setTipoproduto(String tipoproduto) {
        this.tipoproduto = tipoproduto;
    }

    public String getIppt() {
        return ippt;
    }

    public void setIppt(String ippt) {
        this.ippt = ippt;
    }

    public short getOrigem() {
        return origem;
    }

    public void setOrigem(short origem) {
        this.origem = origem;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTributacao() {
        return tributacao;
    }

    public void setTributacao(String tributacao) {
        this.tributacao = tributacao;
    }

    public BigDecimal getAliquotaicmsinterna() {
        return aliquotaicmsinterna;
    }

    public void setAliquotaicmsinterna(BigDecimal aliquotaicmsinterna) {
        this.aliquotaicmsinterna = aliquotaicmsinterna;
    }

    public BigDecimal getAliquotafcp() {
        return aliquotafcp;
    }

    public void setAliquotafcp(BigDecimal aliquotafcp) {
        this.aliquotafcp = aliquotafcp;
    }

    public String getSituacaotributaria() {
        return situacaotributaria;
    }

    public void setSituacaotributaria(String situacaotributaria) {
        this.situacaotributaria = situacaotributaria;
    }

    public String getSituacaotributariaentrada() {
        return situacaotributariaentrada;
    }

    public void setSituacaotributariaentrada(String situacaotributariaentrada) {
        this.situacaotributariaentrada = situacaotributariaentrada;
    }

    public String getCstpis() {
        return cstpis;
    }

    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    public String getCstcofins() {
        return cstcofins;
    }

    public void setCstcofins(String cstcofins) {
        this.cstcofins = cstcofins;
    }

    public String getCstpisentrada() {
        return cstpisentrada;
    }

    public void setCstpisentrada(String cstpisentrada) {
        this.cstpisentrada = cstpisentrada;
    }

    public String getCstcofinsentrada() {
        return cstcofinsentrada;
    }

    public void setCstcofinsentrada(String cstcofinsentrada) {
        this.cstcofinsentrada = cstcofinsentrada;
    }

    public BigDecimal getAliquotapis() {
        return aliquotapis;
    }

    public void setAliquotapis(BigDecimal aliquotapis) {
        this.aliquotapis = aliquotapis;
    }

    public BigDecimal getAliquotacofins() {
        return aliquotacofins;
    }

    public void setAliquotacofins(BigDecimal aliquotacofins) {
        this.aliquotacofins = aliquotacofins;
    }

    public BigDecimal getAliquotapisentrada() {
        return aliquotapisentrada;
    }

    public void setAliquotapisentrada(BigDecimal aliquotapisentrada) {
        this.aliquotapisentrada = aliquotapisentrada;
    }

    public BigDecimal getAliquotacofinsentrada() {
        return aliquotacofinsentrada;
    }

    public void setAliquotacofinsentrada(BigDecimal aliquotacofinsentrada) {
        this.aliquotacofinsentrada = aliquotacofinsentrada;
    }

    public BigDecimal getPercredbasepiscofinssaida() {
        return percredbasepiscofinssaida;
    }

    public void setPercredbasepiscofinssaida(BigDecimal percredbasepiscofinssaida) {
        this.percredbasepiscofinssaida = percredbasepiscofinssaida;
    }

    public BigDecimal getPercredbasepiscofinsentrada() {
        return percredbasepiscofinsentrada;
    }

    public void setPercredbasepiscofinsentrada(BigDecimal percredbasepiscofinsentrada) {
        this.percredbasepiscofinsentrada = percredbasepiscofinsentrada;
    }
}
