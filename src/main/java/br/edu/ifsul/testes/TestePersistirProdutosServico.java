/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

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
public class TestePersistirProdutosServico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Servico s = em.find(Servico.class, 1);
        Produto p1 = em.find(Produto.class, 1);
        Produto p2 = em.find(Produto.class, 2);
        
        s.getProdutos().add(p1);
        s.getProdutos().add(p2);
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
