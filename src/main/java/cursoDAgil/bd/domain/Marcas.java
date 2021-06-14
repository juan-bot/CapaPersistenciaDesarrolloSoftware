package cursoDAgil.bd.domain;

public class Marcas {
	private Integer idMarca;
	private String nombreMarca;
	
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}	
	public boolean equals(Object object){
		if(!(object instanceof Marcas)){
			return false;
		}
		Marcas regMarcas = (Marcas) object;
		return (this.idMarca == regMarcas.idMarca);
	}
}
