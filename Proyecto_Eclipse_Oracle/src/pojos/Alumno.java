package pojos;

import java.time.LocalDate;
import java.util.ArrayList;

import pojos.requeridos.Direccion;
import pojos.requeridos.Notas;
import utiles.validadores;

/**
 * Clase basica Alummno.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class Alumno {
//	PROPIEDADES-ATRIBUTOS
	private String dni;
	private String nombre;
	private Direccion direccion;
	private String[] telefonos;
	private LocalDate fecha_nac;
	private Curso curso;
	private ArrayList<Notas> notas;

//	CONSTRUCTORES
	/**
	 * Constructor que inicializa todos los atributos de la clase menos notas.
	 * 
	 * @param dni
	 * @param nombre
	 * @param direccion
	 * @param telefonos
	 * @param fecha_nac
	 * @param curso
	 */
	public Alumno(String dni, String nombre, Direccion direccion, String[] telefonos, LocalDate fecha_nac,
			Curso curso) {
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.fecha_nac = fecha_nac;
		this.curso = curso;
		this.notas = new ArrayList<Notas>();
	}

//	METODOS
	/**
	 * Muestra los datos del alumno por consola.
	 */
	public void mostrarDatos() {
		System.out.println("DNI: " + dni);
		System.out.println("Nombre: " + nombre);
		direccion.mostrarDatos();
		System.out.println("Telefono 1: " + telefonos[0]);
		System.out.println("Telefono 2: " + telefonos[1]);
		System.out.println("Fecha de Nacimiento: " + fecha_nac.getDayOfMonth() + "-" + fecha_nac.getMonth() + "-"
				+ fecha_nac.getYear());
		curso.mostrarDatos();
		System.out.println("Motrando todas las notas registradas:");
		notas.stream().forEach(notas -> notas.mostrarDatos());
	}

	/**
	 * Valida si el DNI cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarDni() {
		return validadores.validarLongitud(dni, 10);
	}

	/**
	 * Valida si el nombre cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNombre() {
		return validadores.validarLongitud(nombre, 50);
	}

	/**
	 * Valida si la direccion cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarDireccion() {
		return direccion != null;
	}

	/**
	 * Valida si los telefonos cumplen con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarTelefonos() {
		return telefonos != null && telefonos.length == 2;
	}

	/**
	 * Valida si el telefono 1 cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarTelefono1() {
		return validadores.validarLongitud(telefonos[0], 15);
	}

	/**
	 * Valida si el telefono 2 cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarTelefono2() {
		return validadores.validarLongitud(telefonos[1], 15);
	}

	/**
	 * Valida si la fecha de nacimiento cumple con las condiciones de la base de
	 * datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarFechaNac() {
		return fecha_nac != null;
	}

	/**
	 * Valida si el curso cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarCurso() {
		return curso != null;
	}

	/**
	 * Valida si el curso cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNotas() {
		return !notas.isEmpty();
	}

//	GETTERS & SETTERS
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ArrayList<Notas> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Notas> notas) {
		this.notas = notas;
	}

}
