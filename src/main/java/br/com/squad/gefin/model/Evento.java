package br.com.squad.gefin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.squad.gefin.utility.TipoEvento;

@Entity
@Table(name = "tb_evento")
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(name = "DESCRICAO_EVENTO")
    private String descricao;

    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "NATUREZA_EVENTO")
    private TipoEvento naturezaEvento;

    @ManyToOne
    @JsonIgnoreProperties("evento")
    private Movimento movimento;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoEvento getNaturezaEvento() {
        return this.naturezaEvento;
    }

    public void setNaturezaEvento(TipoEvento naturezaEvento) {
        this.naturezaEvento = naturezaEvento;
    }

    public Movimento getMovimento() {
        return this.movimento;
    }

    public void setMovimento(Movimento movimento) {
        this.movimento = movimento;
    }

}
