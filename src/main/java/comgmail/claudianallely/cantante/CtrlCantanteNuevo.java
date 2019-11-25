/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.faces.view.ViewScoped;
import comgmail.claudianallely.web.Mensajes;



/**
 *
 * @author nalle
 */
@Named
@ViewScoped

public class CtrlCantanteNuevo implements Serializable {
private static final long serialVersionUID = 1L;
  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoCantante dao;
  private Cantante modelo;
  @PostConstruct
  void init() {
    modelo = new Cantante();
  }
  public Cantante getModelo() {
    return modelo;
  }

  public String guarda() {
    try {
      dao.agrega(modelo);
      return "index?faces-redirect=true";
    } catch (Exception ex) {
      mensajes.procesa(ex);
      return null;
    }
  }
}
