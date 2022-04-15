/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TesteAlterarPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Pet p = em.find(Pet.class, 2); //Encontra o Pet com determinado ID
        p.setNome("Pipoca");
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
