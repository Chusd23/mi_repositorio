package sena.codejava.minimercado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;      // Efectivo, tarjeta, transferencia...
    private double monto;
    private String referencia; // Código de comprobante o número de transacción

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta; // Relación con la venta correspondiente

    public Pago() {}

    public Pago(String tipo, double monto, String referencia, Venta venta) {
        this.tipo = tipo;
        this.monto = monto;
        this.referencia = referencia;
        this.venta = venta;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }

    public Venta getVenta() { return venta; }
    public void setVenta(Venta venta) { this.venta = venta; }
}
