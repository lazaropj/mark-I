package br.com.markI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {

	 	@Id
	    @Column(name="id")
	    private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
	 	
	 	
	 

}
