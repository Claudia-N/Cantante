/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;


import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.faces.annotation.FacesConfig;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author nalle
 */
@Dependent
@FacesConfig
public class Config {
  
  @Produces
  @PersistenceContext
  EntityManager em;
}


