package forsoftware.clases;

import java.util.Objects;

public class Trabajador {
	private int ID;
	private String nombre;
	private String apellido;
	public enum Sexo {
		hombre,mujer,otros;
	}
	public enum Puesto {
		programador, modelador, gameDesigner, artista, escritor, video, sonido;
	}
	private enum Provincia {
		Álava, Albacete, Alicante, Almería, Asturias, Ávila, Badajoz, Barcelona, Burgos, Cáceres, Cádiz, Cantabria, Castellón, Ciudad_Real, 
		Córdoba, Cuenca, Gerona, Granada, Guadalajara, Guipúzcoa, Huelva, Huesca, Islas_Baleares, Jaén, La_Coruña, La_Rioja, Las_Palmas, 
		León, Lérida, Lugo, Madrid, Málaga, Murcia, Navarra, Orense, Palencia, Pontevedra, Salamanca, Tenerife, 
		Segovia, Sevilla, Soria, Tarragona, Teruel, Toledo, Valencia, Valladolid, Vizcaya, Zamora, Zaragoza;
	};
	private int telefono;
	private String correoEmpresa;
	private double sueldo;
	
	public Trabajador(int iD, String nombre, String apellido, String provincia, int telefono, String correoEmpresa, double sueldo, int ID) {
		this.ID = ID;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correoEmpresa = correoEmpresa;
		this.sueldo = sueldo;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreoEmpresa() {
		return correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Trabajador [ID=" + ID + ", nombre=" + nombre + ", apellido=" + apellido + 
				", telefono=" + telefono + ", correoEmpresa=" + correoEmpresa + ", sueldo=" + sueldo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID, apellido, correoEmpresa, nombre, sueldo, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabajador other = (Trabajador) obj;
		return ID == other.ID && Objects.equals(apellido, other.apellido)
				&& Objects.equals(correoEmpresa, other.correoEmpresa) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo)
				&& telefono == other.telefono;
	}


	
}
	
	
	