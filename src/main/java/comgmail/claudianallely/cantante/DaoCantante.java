/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;

import javax.enterprise.context.Dependent;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author nalle
 */

@Dependent
@Stateless

public class DaoCantante {
@Inject
  private EntityManager em;
  public List<Cantante> consulta() {
    /* Con el resultado de la consulta se llena una lista con objetos de la
     * clase "Pasatiempo". */
    return em.createQuery("SELECT c FROM Cantante c ORDER BY c.cantant",
        Cantante.class).getResultList();
  }
  public Cantante busca(Integer id) {
    return em.find(Cantante.class, id);
  }
  public void agrega(Cantante modelo) {
    em.persist(modelo); // Agrega el modelo a la base de datos.
  }
  public void modifica(Cantante modelo) {
    em.merge(modelo);// Guarda los cambios al modelo.
  }
  public void elimina(Cantante modelo) {
    // Busca el modelo en base a su id.
    final Cantante anterior = em.find(Cantante.class, modelo.getId());
    // Si el resultado es null, el chismoso ya no está registrado.
    if (anterior != null) {
      // Pero si la referencia es diferente de null, hay que eliminar el objeto.
      em.remove(anterior);
    }
  }
}

