/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.facade;

import g01.entity.ExperienciaLaboral;
import g01.entity.Login;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class ExperienciaLaboralFacade extends AbstractFacade<ExperienciaLaboral> {

    @PersistenceContext(unitName = "G01RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperienciaLaboralFacade() {
        super(ExperienciaLaboral.class);
    }
   
    
    public List<ExperienciaLaboral> findExperienciaLaboral(int id) {
        Query q; 
        
        q = em.createQuery("select exp from ExperienciaLaboral exp where exp.usuarioidUsuario.idUsuario = :id");
        q.setParameter("id",  id);
        return q.getResultList();
    }
    
}
