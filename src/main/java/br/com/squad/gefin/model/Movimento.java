package br.com.squad.gefin.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_movimento")
public class Movimento {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MOV")
    private Long id;

    @NotBlank
    @Column(name = "ORIGEM_MOV")
    private String origem;

    @ManyToOne
    @JsonIgnoreProperties("movimento")
    private Controle controle;

    @ManyToOne
    @JsonIgnoreProperties("movimento")
    private Usuario usuario;

    @OneToMany(mappedBy = "movimento", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("movimento")
    private List<Evento> evento;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGravacao = new java.sql.Date(System.currentTimeMillis());
    
    @NotBlank
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataMovimentacao;
    
    @NotBlank
    @JsonFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEfetiva;

    private String descricao;

    @NotBlank
    private BigDecimal valor;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return this.origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public Controle getControle() {
        return this.controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Evento> getEvento() {
        return this.evento;
    }

    public void setEvento(List<Evento> evento) {
        this.evento = evento;
    }

    public Date getDataGravacao() {
        return this.dataGravacao;
    }

    public void setDataGravacao(Date dataGravacao) {
        this.dataGravacao = dataGravacao;
    } 

    public Date getDataMovimentacao() {
        return this.dataMovimentacao;
    }

    public void setDataMovimentacao(Date dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }


    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataEfetiva() {
        return this.dataEfetiva;
    }

    public void setDataEfetiva(Date dataEfetiva) {
        this.dataEfetiva = dataEfetiva;
    }



}