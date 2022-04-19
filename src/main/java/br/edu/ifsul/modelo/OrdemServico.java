/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "ordemServico")
public class OrdemServico implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_ordemServico", sequenceName = "seq_ordemServico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_ordemServico", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "A descrição deve ser informadoa")
    @Length(max = 30, message = "A descrição não pode ter mais que {max} caracteres")
    @Column(name = "descricao", length = 30, nullable = false)   
    private String descricao;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @Min(value = 0, message = "O valor total não pode ser negativo")
    @NotNull(message = "O valor total deve ser informado")
    @Column(name = "valor_total", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valorTotal;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pet", referencedColumnName = "id", nullable = false)
    private Pet pet;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false) 
    private Pessoa pessoa;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "funcionario", referencedColumnName = "id", nullable = false) 
    private Funcionario funcionario;
    
    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ItemServico> itensServicos = new ArrayList<>();
    
    public OrdemServico() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public List<ItemServico> getItensServicos() {
        return itensServicos;
    }

    public void setItensServicos(List<ItemServico> itensServicos) {
        this.itensServicos = itensServicos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final OrdemServico other = (OrdemServico) obj;
        return Objects.equals(this.id, other.id);
    }
    
   
}
