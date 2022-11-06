package clases;

public class Contratacion {
	
	private String codigo;
	private String entidad;
	private String tipo;
	private String objeto;
	private String  fecha;
	private String estado;
	
	
	public Contratacion(String codigo, String entidad, String tipo, String objeto, String fecha, String estado) {
		this.codigo = codigo;
		this.entidad = entidad;
		this.tipo = tipo;
		this.objeto = objeto;
		this.fecha = fecha;
		this.estado = estado;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getentidad() {
		return entidad;
	}


	public void setentidad(String entidad) {
		this.entidad = entidad;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getObjeto() {
		return objeto;
	}


	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
