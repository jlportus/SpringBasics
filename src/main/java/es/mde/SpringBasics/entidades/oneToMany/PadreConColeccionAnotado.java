package es.mde.SpringBasics.entidades.oneToMany;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Ejemplo equivalente a {@link PadreConColeccion} pero usando anotaciones
 * JPA en lugar de ficheros orm.xml.
 */
@Entity
public class PadreConColeccionAnotado {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "padre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ElementoAnotado> elementos = new ArrayList<>();

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

    public List<ElementoAnotado> getElementos() {
        return elementos;
    }

    public void setElementos(List<ElementoAnotado> elementos) {
        this.elementos = elementos;
    }

    // Método sincronizador
    public void addElemento(ElementoAnotado elemento) {
        elementos.add(elemento);
        elemento.setPadre(this);
    }
}
