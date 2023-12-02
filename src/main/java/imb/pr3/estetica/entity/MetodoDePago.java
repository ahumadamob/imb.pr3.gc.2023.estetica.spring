package imb.pr3.estetica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


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
    @NotBlank(message = "el campo no puede estar en blanco")
    @NotEmpty(message = "el campo no puede estar vacio")
    @NotEmpty(message = "el campo no puede estar nulo")
    private String codigo;

    public MetodoDePago() {
    }

    public MetodoDePago(Integer id, String nombre, Boolean habilitado, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.habilitado = habilitado;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
