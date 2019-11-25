/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comgmail.claudianallely.cantante;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author nalle
 */
@Entity 
@Table(name = "cantante")

public class Cantante implements Serializable {
 private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CANT_ID")
  private Integer id;
     
  // Las siguientes anotaciones se explican en el la página sobre Bean Validation.
  @NotNull(message="Falta el valor.")
  @Size(min = 1, max = 255)
  @Column(name = "CANT_NOMBRE")
  private String cantant;
  
   @NotNull(message="Falta el valor.")
  @Size(min = 1, max = 255)
  @Column(name = "NACIONALIDAD")
  private String nacionalidad;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getCantant() {
    return cantant;
  }
  public void setCantant(String cantant) {
    this.cantant = cantant;
  }

  public String getNacionalidad() {
      return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
      this.nacionalidad = nacionalidad;
  }
  
  
  
  
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }
  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Cantante)) {
      return false;
    }
    Cantante other = (Cantante) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.
        equals(other.id))) {
      return false;
    }
    return true;
  }
  @Override
  public String toString() {
    return "comgmail.claudianallely.cantante.Cantante[ id=" + id + " ]";
  }
}


    