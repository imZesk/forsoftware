package forsoftware.clases;

import java.sql.Date;
import java.util.Objects;

public class Proyectos {
	private int ID;
	private String nombre;
	private int numeroDeParticipante;
	private Date fechaInicio;
	private Date fehcaAcabadoEstimado;
	private double gastos;
	public enum TipoDeProyecto {
		software, multimedia               //software: programador, modelador, gameDesigner
	}                                      //multimedia: artista, escritor, video, sonido
	public enum EstadoProyecto {
		pendiente, finalizado
	}
	
	public Proyectos(int ID, String nombre, int numeroDeParticipante, Date fechaInicio, Date fehcaAcabadoEstimado, double gastos) {
		this.ID = ID;
		this.nombre = nombre;
		this.numeroDeParticipante = numeroDeParticipante;
		this.fechaInicio = fechaInicio;
		this.fehcaAcabadoEstimado = fehcaAcabadoEstimado;
		this.gastos = gastos;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroDeParticipante() {
		return numeroDeParticipante;
	}
	public void setNumeroDeParticipante(int numeroDeParticipante) {
		this.numeroDeParticipante = numeroDeParticipante;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFehcaAcabadoEstimado() {
		return fehcaAcabadoEstimado;
	}
	public void setFehcaAcabadoEstimado(Date fehcaAcabadoEstimado) {
		this.fehcaAcabadoEstimado = fehcaAcabadoEstimado;
	}
	public double getGastos() {
		return gastos;
	}
	public void setGastos(double gastos) {
		this.gastos = gastos;
	}
	@Override
	public String toString() {
		return "Proyectos [ID=" + ID + ", nombre=" + nombre + ", numeroDeParticipante=" + numeroDeParticipante
				+ ", fechaInicio=" + fechaInicio + ", fehcaAcabadoEstimado=" + fehcaAcabadoEstimado + ", gastos="
				+ gastos + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ID, fechaInicio, fehcaAcabadoEstimado, gastos, nombre, numeroDeParticipante);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyectos other = (Proyectos) obj;
		return ID == other.ID && Objects.equals(fechaInicio, other.fechaInicio)
				&& Objects.equals(fehcaAcabadoEstimado, other.fehcaAcabadoEstimado)
				&& Double.doubleToLongBits(gastos) == Double.doubleToLongBits(other.gastos)
				&& Objects.equals(nombre, other.nombre) && numeroDeParticipante == other.numeroDeParticipante;
	}

	
	
}
