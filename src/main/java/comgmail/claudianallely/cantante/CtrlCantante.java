/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;

import javax.inject.Named;

import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import comgmail.claudianallely.web.Mensajes;
import javax.faces.view.ViewScoped;

/**
 *
 * @author nalle
 */
@Named
@ViewScoped

public class CtrlCantante implements Serializable {
private static final long serialVersionUID = 1L;
  @Inject
  private Mensajes mensajes;
  @Inject
  private ExternalContext externalContext;
  @Inject
  private DaoCantante dao;
  private Integer id;
  private Cantante modelo;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Cantante getModelo() {
    return modelo;
  }
  public void init() {
    try {
      leeLlavePrimaria();
      this.modelo = dao.busca(id);
    } catch (NumberFormatException e) {
      mensajes.error(null, "Id no encontrado.");
    } catch (Exception e) {
      mensajes.procesa(e);
    }
  }
  private void leeLlavePrimaria() throws NumberFormatException {
    final String parámetroId =
        externalContext.getRequestParameterMap().get("id");
    id = new Integer(parámetroId);
  }
  
  public String guarda() {
    try {
      dao.modifica(modelo);
      return "index?faces-redirect=true";
    } catch (Exception ex) {
      mensajes.procesa(ex);
      return null;
    }
  }
  public String elimina() {
    try {
      if (modelo != null) {
        dao.elimina(modelo);
        return "index?faces-redirect=true";
      }
    } catch (Exception ex) {
      mensajes.procesa(ex);
    }
    return null;
  }
}

