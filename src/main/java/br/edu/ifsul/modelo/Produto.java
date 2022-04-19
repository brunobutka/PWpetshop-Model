/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "produto")
public class Produto implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valor;
    
    @ManyToMany
    @JoinTable(name = "produtos",
            // se refere a classe Produto
            joinColumns = 
                    @JoinColumn(name = "produto", referencedColumnName = "id", 
                            nullable = false),
            // se refere ao tipo da lista <Servico>
            inverseJoinColumns = 
                    @JoinColumn(name = "servico", referencedColumnName = "id", 
                            nullable = false)
            )     
    private Set<Servico> servicos = new HashSet<>();

    public Produto() {
        
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Set<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(Set<Servico> servicos) {
        this.servicos = servicos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
