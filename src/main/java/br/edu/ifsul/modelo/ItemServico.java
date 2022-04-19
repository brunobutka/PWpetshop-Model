/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "itemServico")
public class ItemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_itemServico", sequenceName = "seq_itemServico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_itemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @NotNull(message = "A quantidade deve ser informada")
    @Column(name = "quantidade", nullable = false, columnDefinition = "decimal(10,2)")
    private Double quantidade;
    
    @Min(value = 0, message = "O valor unitário não pode ser negativo")
    @NotNull(message = "O valor unitário deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valorUnitario;
    
    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valorTotal;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "servico", referencedColumnName = "id", nullable = false)
    private Servico servico;
    
    @NotNull(message = "A ordem de serviço deve ser informada")
    @ManyToOne
    @JoinColumn(name = "ordemServico_id", referencedColumnName = "id", nullable = false)
    private OrdemServico ordemServico;

    public ItemServico() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
    
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemServico other = (ItemServico) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
