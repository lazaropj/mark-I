package br.com.markI.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OcorrenciaRepositoryImpl extends AbstractRepository implements
		OcorrenciaRepository {

	@Override
	public String getContextName() {
		return "ocorrencia";
	}

	public List<Long> obterAnosDeOcorrencia() {
		
		List listQuery = (List<Long>)this.listQuery("anosDeOcorrencia", null, null);
		return listQuery;
	}
	
	
	

}
