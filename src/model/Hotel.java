package model;

public class Hotel {
	private Integer id;
	private String nomeFilial;
	private String rua;
	private Integer numero;
	private String cidade;
	private String estado;
	private Boolean e5estrelas;
	
	public Hotel(String nomeFilial, String rua, Integer numero, String cidade, String estado, Boolean e5estrelas) {
		this.nomeFilial = nomeFilial;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.e5estrelas = e5estrelas;
	}

	public Hotel(Integer id, String nomeFilial, String rua, Integer numero, String cidade, String estado,
			Boolean e5estrelas) {
		this.id = id;
		this.nomeFilial = nomeFilial;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.e5estrelas = e5estrelas;
	}
	
	public Hotel()
	{
		
	}
	
	@Override
	public String toString() {
		String aux = (e5estrelas ? " e com classificacao 5 estrelas" : " e sem classificacao 5 estrelas");
		return id + ": Hotel " + nomeFilial + " localizado no endereco: Rua " + rua + ", " + numero + ", " + cidade + " - " + estado + aux;
				
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getE5estrelas() {
		return e5estrelas;
	}

	public void setE5estrelas(Boolean e5estrelas) {
		this.e5estrelas = e5estrelas;
	}
}
