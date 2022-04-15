/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Raca r = em.find(Raca.class, 2);
        Pet p = new Pet();
        
        p.setNome("Todinho");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(15.7);
        p.setRaca(r);
        p.setEspecie("Cachorro");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        r = em.find(Raca.class, 1);
        p = new Pet();
        
        p.setNome("Nuvem");
        p.setNascimento(Calendar.getInstance());
        p.setPeso(10.0);
        p.setRaca(r);
        p.setEspecie("Cachorro");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
