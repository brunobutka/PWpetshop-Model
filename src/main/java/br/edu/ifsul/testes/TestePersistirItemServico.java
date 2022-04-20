/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Raca;
import br.edu.ifsul.modelo.Servico;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirItemServico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        OrdemServico o = em.find(OrdemServico.class, 2);
        ItemServico i = new ItemServico();
        
        i.setQuantidade(5.0);
        i.setValorUnitario(10.0);
        i.setValorTotal(30.0);
        i.setServico(em.find(Servico.class, 1));
        o.adicionarItemServico(i);
        
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
