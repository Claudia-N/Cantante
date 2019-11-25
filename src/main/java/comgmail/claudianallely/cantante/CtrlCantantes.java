/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;

import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import comgmail.claudianallely.web.Mensajes;

/**
 *
 * @author nalle
 */
@Named
@RequestScoped
public class CtrlCantantes {

  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoCantante dao;
  private List<Cantante> instancias;

  @PostConstruct
  void init() {
    try {
      instancias = dao.consulta();
    } catch (Exception ex) {
      mensajes.procesa(ex);
    }
  }
  public List<Cantante> getInstancias() {
    return instancias;
  }
}
