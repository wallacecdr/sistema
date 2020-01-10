package com.sistema.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Wallace Caldeira
 */
@Entity
@Table(name = "Operacao")
public class Operacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "operacao_id_sequence")
    private Long id;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    @Column(columnDefinition = "smallint", nullable = false)
    private int pdv;
    @ManyToOne
    private Usuario usuario;
    @Column(length = 14)
    private String cliente;
    @Column
    private int coo;
    @Column
    private Timestamp horainicial;
    @Column
    private Timestamp horafinal;
    @Column
    private int tipo;
    @Column(columnDefinition = "smallint")
    private int cancelado;
    @Column(length = 10)
    private String canceladousuario;
    @Column
    private Timestamp canceladohora;
    @Column(precision = 12, scale = 2)
    private BigDecimal valorbruto;
    @Column(precision = 12, scale = 2)
    private BigDecimal descontosubtotal;
    @Column(precision = 12, scale = 2)
    private BigDecimal valorliquido;
    @Column(length = 10)
    private String usuariodescontosubtotal;
    @Column(columnDefinition = "smallint")
    private int replicacao;
    @Column(length = 18)
    private String consumidorcpfcnpj;
    @Column(length = 60)
    private String consumidornome;
    @Column(length = 20)
    private String localhost;
    @Column(columnDefinition = "smallint")
    private int fechamentocaixa;
    @Column(columnDefinition = "smallint")
    private int nfce;
    @Column(length = 4)
    private String modelonfce;
    @Column(length = 4)
    private String serienfce;
    @Column(length = 11)
    private String numeronfce;
    @Column
    private int numerochaveacessonfce;
    @Column(length = 44)
    private String chaveacessonfce;
    @Column(columnDefinition = "smallint")
    private int statusnfce;
    @Column(columnDefinition = "smallint")
    private int formaemissaonfce;
    @Column(columnDefinition = "smallint")
    private int tipoambientenfce;
    @Column
    private Byte[] xmlnfceautorizado;
    @Column(columnDefinition = "smallint")
    private int statusretornonfce;
    @Column(length = 200)
    private String mensagemretornonfce;
    @Column(columnDefinition = "smallint")
    private int statusprotocolonfce;
    @Column(length = 200)
    private String mensagemprotocolonfce;
    @Column(length = 18)
    private String recibotransmissaonfce;
    @Column(length = 30)
    private String datahoratransmissaonfce;
    @Column
    private Byte[] xmlnfcecancelamento;
    @Column(columnDefinition = "smallint")
    private int formaemissaodocumento;
    @Column(columnDefinition = "smallint")
    private int tipoambiente;
    @Column(length = 44)
    private String chaveacesso;
    @Column(length = 44)
    private String codigochaveacesso;
    @Column(length = 30)
    private String datahoracancelamentonfce;
    @Column(length = 60)
    private String consumidorendereco;
    @Column(length = 6)
    private String consumidornumero;
    @Column(length = 60)
    private String consumidorcomplemento;
    @Column(length = 50)
    private String consumidorbairro;
    @Column(length = 9)
    private String consumidorcep;
    @Column(columnDefinition = "bigint")
    private int consumidoridcidade;
    @Column(columnDefinition = "bigint")
    private int consumidoridestado;
    @Column(length = 15)
    private String consumidortelefone;
    @Column(length = 200)
    private String consumidoremail;
    @Column(columnDefinition = "smallint")
    private int versaonfce;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPdv() {
        return pdv;
    }

    public void setPdv(int pdv) {
        this.pdv = pdv;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getCoo() {
        return coo;
    }

    public void setCoo(int coo) {
        this.coo = coo;
    }

    public Timestamp getHorainicial() {
        return horainicial;
    }

    public void setHorainicial(Timestamp horainicial) {
        this.horainicial = horainicial;
    }

    public Timestamp getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Timestamp horafinal) {
        this.horafinal = horafinal;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCancelado() {
        return cancelado;
    }

    public void setCancelado(int cancelado) {
        this.cancelado = cancelado;
    }

    public String getCanceladousuario() {
        return canceladousuario;
    }

    public void setCanceladousuario(String canceladousuario) {
        this.canceladousuario = canceladousuario;
    }

    public Timestamp getCanceladohora() {
        return canceladohora;
    }

    public void setCanceladohora(Timestamp canceladohora) {
        this.canceladohora = canceladohora;
    }

    public BigDecimal getValorbruto() {
        return valorbruto;
    }

    public void setValorbruto(BigDecimal valorbruto) {
        this.valorbruto = valorbruto;
    }

    public BigDecimal getDescontosubtotal() {
        return descontosubtotal;
    }

    public void setDescontosubtotal(BigDecimal descontosubtotal) {
        this.descontosubtotal = descontosubtotal;
    }

    public BigDecimal getValorliquido() {
        return valorliquido;
    }

    public void setValorliquido(BigDecimal valorliquido) {
        this.valorliquido = valorliquido;
    }

    public String getUsuariodescontosubtotal() {
        return usuariodescontosubtotal;
    }

    public void setUsuariodescontosubtotal(String usuariodescontosubtotal) {
        this.usuariodescontosubtotal = usuariodescontosubtotal;
    }

    public int getReplicacao() {
        return replicacao;
    }

    public void setReplicacao(int replicacao) {
        this.replicacao = replicacao;
    }

    public String getConsumidorcpfcnpj() {
        return consumidorcpfcnpj;
    }

    public void setConsumidorcpfcnpj(String consumidorcpfcnpj) {
        this.consumidorcpfcnpj = consumidorcpfcnpj;
    }

    public String getConsumidornome() {
        return consumidornome;
    }

    public void setConsumidornome(String consumidornome) {
        this.consumidornome = consumidornome;
    }

    public String getLocalhost() {
        return localhost;
    }

    public void setLocalhost(String localhost) {
        this.localhost = localhost;
    }

    public int getFechamentocaixa() {
        return fechamentocaixa;
    }

    public void setFechamentocaixa(int fechamentocaixa) {
        this.fechamentocaixa = fechamentocaixa;
    }

    public int getNfce() {
        return nfce;
    }

    public void setNfce(int nfce) {
        this.nfce = nfce;
    }

    public String getModelonfce() {
        return modelonfce;
    }

    public void setModelonfce(String modelonfce) {
        this.modelonfce = modelonfce;
    }

    public String getSerienfce() {
        return serienfce;
    }

    public void setSerienfce(String serienfce) {
        this.serienfce = serienfce;
    }

    public String getNumeronfce() {
        return numeronfce;
    }

    public void setNumeronfce(String numeronfce) {
        this.numeronfce = numeronfce;
    }

    public int getNumerochaveacessonfce() {
        return numerochaveacessonfce;
    }

    public void setNumerochaveacessonfce(int numerochaveacessonfce) {
        this.numerochaveacessonfce = numerochaveacessonfce;
    }

    public String getChaveacessonfce() {
        return chaveacessonfce;
    }

    public void setChaveacessonfce(String chaveacessonfce) {
        this.chaveacessonfce = chaveacessonfce;
    }

    public int getStatusnfce() {
        return statusnfce;
    }

    public void setStatusnfce(int statusnfce) {
        this.statusnfce = statusnfce;
    }

    public int getFormaemissaonfce() {
        return formaemissaonfce;
    }

    public void setFormaemissaonfce(int formaemissaonfce) {
        this.formaemissaonfce = formaemissaonfce;
    }

    public int getTipoambientenfce() {
        return tipoambientenfce;
    }

    public void setTipoambientenfce(int tipoambientenfce) {
        this.tipoambientenfce = tipoambientenfce;
    }

    public Byte[] getXmlnfceautorizado() {
        return xmlnfceautorizado;
    }

    public void setXmlnfceautorizado(Byte[] xmlnfceautorizado) {
        this.xmlnfceautorizado = xmlnfceautorizado;
    }

    public int getStatusretornonfce() {
        return statusretornonfce;
    }

    public void setStatusretornonfce(int statusretornonfce) {
        this.statusretornonfce = statusretornonfce;
    }

    public String getMensagemretornonfce() {
        return mensagemretornonfce;
    }

    public void setMensagemretornonfce(String mensagemretornonfce) {
        this.mensagemretornonfce = mensagemretornonfce;
    }

    public int getStatusprotocolonfce() {
        return statusprotocolonfce;
    }

    public void setStatusprotocolonfce(int statusprotocolonfce) {
        this.statusprotocolonfce = statusprotocolonfce;
    }

    public String getMensagemprotocolonfce() {
        return mensagemprotocolonfce;
    }

    public void setMensagemprotocolonfce(String mensagemprotocolonfce) {
        this.mensagemprotocolonfce = mensagemprotocolonfce;
    }

    public String getRecibotransmissaonfce() {
        return recibotransmissaonfce;
    }

    public void setRecibotransmissaonfce(String recibotransmissaonfce) {
        this.recibotransmissaonfce = recibotransmissaonfce;
    }

    public String getDatahoratransmissaonfce() {
        return datahoratransmissaonfce;
    }

    public void setDatahoratransmissaonfce(String datahoratransmissaonfce) {
        this.datahoratransmissaonfce = datahoratransmissaonfce;
    }

    public Byte[] getXmlnfcecancelamento() {
        return xmlnfcecancelamento;
    }

    public void setXmlnfcecancelamento(Byte[] xmlnfcecancelamento) {
        this.xmlnfcecancelamento = xmlnfcecancelamento;
    }

    public int getFormaemissaodocumento() {
        return formaemissaodocumento;
    }

    public void setFormaemissaodocumento(int formaemissaodocumento) {
        this.formaemissaodocumento = formaemissaodocumento;
    }

    public int getTipoambiente() {
        return tipoambiente;
    }

    public void setTipoambiente(int tipoambiente) {
        this.tipoambiente = tipoambiente;
    }

    public String getChaveacesso() {
        return chaveacesso;
    }

    public void setChaveacesso(String chaveacesso) {
        this.chaveacesso = chaveacesso;
    }

    public String getCodigochaveacesso() {
        return codigochaveacesso;
    }

    public void setCodigochaveacesso(String codigochaveacesso) {
        this.codigochaveacesso = codigochaveacesso;
    }

    public String getDatahoracancelamentonfce() {
        return datahoracancelamentonfce;
    }

    public void setDatahoracancelamentonfce(String datahoracancelamentonfce) {
        this.datahoracancelamentonfce = datahoracancelamentonfce;
    }

    public String getConsumidorendereco() {
        return consumidorendereco;
    }

    public void setConsumidorendereco(String consumidorendereco) {
        this.consumidorendereco = consumidorendereco;
    }

    public String getConsumidornumero() {
        return consumidornumero;
    }

    public void setConsumidornumero(String consumidornumero) {
        this.consumidornumero = consumidornumero;
    }

    public String getConsumidorcomplemento() {
        return consumidorcomplemento;
    }

    public void setConsumidorcomplemento(String consumidorcomplemento) {
        this.consumidorcomplemento = consumidorcomplemento;
    }

    public String getConsumidorbairro() {
        return consumidorbairro;
    }

    public void setConsumidorbairro(String consumidorbairro) {
        this.consumidorbairro = consumidorbairro;
    }

    public String getConsumidorcep() {
        return consumidorcep;
    }

    public void setConsumidorcep(String consumidorcep) {
        this.consumidorcep = consumidorcep;
    }

    public int getConsumidoridcidade() {
        return consumidoridcidade;
    }

    public void setConsumidoridcidade(int consumidoridcidade) {
        this.consumidoridcidade = consumidoridcidade;
    }

    public int getConsumidoridestado() {
        return consumidoridestado;
    }

    public void setConsumidoridestado(int consumidoridestado) {
        this.consumidoridestado = consumidoridestado;
    }

    public String getConsumidortelefone() {
        return consumidortelefone;
    }

    public void setConsumidortelefone(String consumidortelefone) {
        this.consumidortelefone = consumidortelefone;
    }

    public String getConsumidoremail() {
        return consumidoremail;
    }

    public void setConsumidoremail(String consumidoremail) {
        this.consumidoremail = consumidoremail;
    }

    public int getVersaonfce() {
        return versaonfce;
    }

    public void setVersaonfce(int versaonfce) {
        this.versaonfce = versaonfce;
    }
}
