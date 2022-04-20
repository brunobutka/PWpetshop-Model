/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
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
public class TestePersistirOrdemServico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse("21/01/2002");*/
        
        OrdemServico o = new OrdemServico();
        o.setDescricao("Banho para cachorro");
        o.setData(Calendar.getInstance());
        o.setValorTotal(85.0);
        o.setFuncionario(em.find(Funcionario.class, 3));
        o.setPessoa(em.find(Pessoa.class, 1));
        o.setPet(em.find(Pet.class, 1));
        
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
