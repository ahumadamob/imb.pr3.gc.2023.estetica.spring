package imb.pr3.estetica.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "metodoDePago")
public class MetodoDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "habilitado")
    private Boolean habilitado;

    public MetodoDePago() {
    }

    public MetodoDePago(Long id, String nombre, Boolean habilitado) {
        this.id = id;
        this.nombre = nombre;
        this.habilitado = habilitado;
    }

    public Long getId() {
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
