package br.com.squad.gefin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @Enumerated(EnumType.STRING)
    private NaturezaEvento naturezaEvento;

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

    public NaturezaEvento getNaturezaEvento() {
        return this.naturezaEvento;
    }

    public void setNaturezaEvento(NaturezaEvento naturezaEvento) {
        this.naturezaEvento = naturezaEvento;
    }

}
