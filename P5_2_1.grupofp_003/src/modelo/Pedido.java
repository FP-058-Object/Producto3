package modelo;

/**
 *
 * @author elbob
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Pedido {
    private int idPedido;
    private int numeroPedido;
    private int idCliente;
    private String idClaseArticulo;
    private int cantidad;
    private Date fechaHoraPedido;
    private boolean enviado;
    

    public Pedido(int numeroPedido, int idCliente, String idClaseArticulo, int cantidad, Date fechaHoraPedido) {
        this.numeroPedido = numeroPedido;
        this.idCliente = idCliente;
        this.idClaseArticulo = idClaseArticulo;
        this.cantidad = cantidad;
        this.fechaHoraPedido = fechaHoraPedido;
    }

    // Otros atributos y constructor
    public int getidPedido() {
        return idPedido;
    }
    public void setidPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    
    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public int getidCliente() {
        return idCliente;
    }
  

    public void setidCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getidClaseArticulo() {
        return idClaseArticulo;
    }

    public void setidClaseArticulo(String idClaseArticulo) {
        this.idClaseArticulo = idClaseArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaHoraPedido() {
        return fechaHoraPedido;
    }

    public void setFechaHoraPedido(Date fechaHoraPedido) {
        this.fechaHoraPedido = fechaHoraPedido;
    }

    /*public boolean isEnviado() {
        long tiempoTranscurrido = calcularTiempoTranscurrido(getFechaHoraPedido());
        return tiempoTranscurrido > idClaseArticulo.getTiempoPreparacionMinutos();
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public boolean pedidoEnviado() {
        long tiempoTranscurrido = calcularTiempoTranscurrido(getFechaHoraPedido());
        return tiempoTranscurrido > idClaseArticulo.getTiempoPreparacionMinutos();
    }*/





















    

    
    private long calcularTiempoTranscurrido(Date fechaPedido) {
        // Obtiene la fecha y hora actual
        Date fechaActual = new Date();

        // Convierte las fechas a objetos Calendar
        Calendar calendarPedido = Calendar.getInstance();
        calendarPedido.setTime(fechaPedido);
        Calendar calendarActual = Calendar.getInstance();
        calendarActual.setTime(fechaActual);

        // Calcula la diferencia en milisegundos
        long diferenciaEnMilisegundos = calendarActual.getTimeInMillis() - calendarPedido.getTimeInMillis();

        // Convierte la diferencia a minutos
        long minutosTranscurridos = diferenciaEnMilisegundos / (60 * 1000);
        
        return minutosTranscurridos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.numeroPedido);
        hash = 61 * hash + Objects.hashCode(this.idCliente);
        hash = 61 * hash + Objects.hashCode(this.idClaseArticulo);
        hash = 61 * hash + this.cantidad;
        hash = 61 * hash + Objects.hashCode(this.fechaHoraPedido);
        hash = 61 * hash + (this.enviado ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.numeroPedido != other.numeroPedido) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.enviado != other.enviado) {
            return false;
        }
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        if (!Objects.equals(this.idClaseArticulo, other.idClaseArticulo)) {
            return false;
        }
        return Objects.equals(this.fechaHoraPedido, other.fechaHoraPedido);
    }

}