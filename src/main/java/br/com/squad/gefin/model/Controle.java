package br.com.squad.gefin.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.squad.gefin.utility.TipoControle;

@Entity
@Table(name = "tb_controle")
public class Controle {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CONTROLE")
    private Long id;

    @NotBlank
    @Column(name = "DTCRIACAO_CONTROLE")
    private Date dataCriacao = new java.sql.Date(System.currentTimeMillis());

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "NOME_CONTROLE")
    private String nome;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_CONTROLE")
    private TipoControle tipoControle;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "DESCRI_CONTROLE")
    private String descricao;

    @NotBlank
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DTSALDOANT_CONTROLE")
    private Date dataSaldoAnterior;

    @NotBlank
    @Column(name = "SALDOANT_CONTROLE")
    private BigDecimal saldoAnterior;

    @ManyToOne
    @JsonIgnoreProperties("controle")
    private Usuario usuario;

    @OneToMany(mappedBy = "controle", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("controle")
    private List<Movimento> movimento;


    public TipoControle getTipoControle() {
        return this.tipoControle;
    }

    public void setTipoControle(TipoControle tipoControle) {
        this.tipoControle = tipoControle;
    }

    public Date getDataSaldoAnterior() {
        return this.dataSaldoAnterior;
    }

    public void setDataSaldoAnterior(Date dataSaldoAnterior) {
        this.dataSaldoAnterior = dataSaldoAnterior;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public BigDecimal getSaldoAnterior() {
        return this.saldoAnterior;
    }

    public void setSaldoAnterior(BigDecimal saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public List<Movimento> getMovimento() {
        return this.movimento;
    }

    public void setMovimento(List<Movimento> movimento) {
        this.movimento = movimento;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
