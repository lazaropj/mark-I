package br.com.markI.util;

public enum Estados {
      
	AC("Acre"),
	AL("Alagoas"),
	AM("Amazonas"),
	AP("Amapa"),
	BA("Bahia"),
	CE("Cear�"),
	DF("Distrito Federal"),
	ES("Esp�rito Santo"),
	GO("Goi�s"),
	MA("Maranh�o"),
	MG("Minas Gerais"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	PA("Par�"),
	PB("Para�ba"),
	PE("Pernambuco"),
	PI("Piau�"),
	PR("Paran�"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RO("Rond�nia"),
	RR("Roraima"),
	RS("Rio Grande do Sul"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	SP("S�o Paulo"),
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
