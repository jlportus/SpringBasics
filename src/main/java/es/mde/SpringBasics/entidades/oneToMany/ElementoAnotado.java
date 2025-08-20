package es.mde.SpringBasics.entidades.oneToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Variante anotada de {@link Elemento} que no requiere definiciones XML.
 */
@Entity
public class ElementoAnotado {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;

    @ManyToOne
    private PadreConColeccionAnotado padre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PadreConColeccionAnotado getPadre() {
        return padre;
    }

    public void setPadre(PadreConColeccionAnotado padre) {
        this.padre = padre;
    }
}
