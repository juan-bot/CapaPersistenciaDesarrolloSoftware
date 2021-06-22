package cursoDAgil.bd.domain;

public class Cliente {

	private Direccion direccion;
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private String sexo;
	private Integer idDireccion;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}
	//agregar relacion con direccion
	public Cliente() {
		setDireccion(new Direccion());
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public boolean equals(Object object){
		if (!(object instanceof Cliente)){
			return false;
		}
		Cliente regCliente = (Cliente) object;
		return (this.id == regCliente.id);
	}
}