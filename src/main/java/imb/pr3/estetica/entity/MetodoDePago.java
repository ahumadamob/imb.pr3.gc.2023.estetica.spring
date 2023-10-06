package imb.pr3.estetica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "metodoDePago")
public class MetodoDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @Column(name = "habilitado")
    private Boolean habilitado;

    @ManyToOne
    private OrdenDePago ordenDePago;


    public MetodoDePago() {
    }

    public MetodoDePago(Integer id, String nombre, Boolean habilitado, OrdenDePago ordenDePago) {
        this.id = id;
        this.nombre = nombre;
        this.habilitado = habilitado;
        this.ordenDePago = ordenDePago;
    }

    public OrdenDePago getOrdenDePago() {
        return ordenDePago;
    }

    public void setOrdenDePago(OrdenDePago ordenDePago) {
        this.ordenDePago = ordenDePago;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public String toString() {
        return "MetodoDePago{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", habilitado=" + habilitado +
                '}';
    }
}
