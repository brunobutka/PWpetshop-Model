/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Raca;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirFuncionario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Funcionario f1 = new Funcionario();
        f1.setAtivo(true);
        f1.setNome("Carlos Augusto");
        f1.setNomeUsuario("carlosaugusto");
        f1.setSenha("12345");
        
        
        em.getTransaction().begin();
        em.persist(f1);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
