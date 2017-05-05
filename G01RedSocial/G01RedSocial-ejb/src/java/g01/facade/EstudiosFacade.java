/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g01.facade;

import g01.entity.Estudios;
import g01.entity.ExperienciaLaboral;
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
public class EstudiosFacade extends AbstractFacade<Estudios> {

    @PersistenceContext(unitName = "G01RedSocial-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiosFacade() {
        super(Estudios.class);
    }
    
        public List<Estudios> findEstudios(int id) {
        Query q; 
        
        q = em.createQuery("select est from Estudios est where est.usuarioidUsuario.idUsuario = :id");
        q.setParameter("id",  id);
        return q.getResultList();
    }
    
}
