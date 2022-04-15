/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TesteListarPet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList(); //select e from Pet e...
        for(Pet p : lista){
           System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Peso: " + p.getPeso() + 
                              " | Nascimento: " + sdf.format(p.getNascimento().getTime()) + " | Espécie: " + p.getEspecie() + 
                              " | Raça: " + p.getRaca().getNome());
        }
        
        em.close();
        emf.close();
    }
    
}
