package br.com.markI.util;

public enum Estados {
      
	AC("Acre"),
	AL("Alagoas"),
	AM("Amazonas"),
	AP("Amapa"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MG("Minas Gerais"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	PA("Pará"),
	PB("Paraíba"),
	PE("Pernambuco"),
	PI("Piauí"),
	PR("Paraná"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RO("Rondônia"),
	RR("Roraima"),
	RS("Rio Grande do Sul"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	SP("São Paulo"),
	TO("Tocantins");
	
      
	private String nome;
	
	private Estados(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	
	
		
}
