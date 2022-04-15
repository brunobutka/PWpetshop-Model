/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirRaca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = new Raca();
        r.setNome("Poodle");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Boxer");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Pug");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        r = new Raca();
        r.setNome("Dobermann");
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
