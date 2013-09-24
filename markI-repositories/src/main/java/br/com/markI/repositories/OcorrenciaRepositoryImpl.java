package br.com.markI.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.markI.dto.MunicipioDTO;
import br.com.markI.util.Estados;

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

	//Retorna os municipios que possuem ocorrencias em um deteremnado estado
	public List<MunicipioDTO> obterMunicipiosPorSigla(Estados sigla,Integer[] anos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("siglaUF", sigla.toString());
		if(anos!=null && anos.length >0)
			params.put("anos", anos);
		
		
		List<MunicipioDTO> listQuery = (List<MunicipioDTO>)this.listQuery("municipiosPorEstados", params, MunicipioDTO.class);
		return listQuery;
	}
	
	
	

}
