package imb.pr3.estetica.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_reserva")
    private Date fecha_reserva;
    @Column(name = "hora")
    private Date hora;
//    private Integer idEmpleados;
//    private Integer idCliente;
//

    public Turno() {
    }

    public Turno(Integer id, Date fecha_reserva, Date hora) {
        this.id = id;
        this.fecha_reserva = fecha_reserva;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public Date getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(Date fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
}
