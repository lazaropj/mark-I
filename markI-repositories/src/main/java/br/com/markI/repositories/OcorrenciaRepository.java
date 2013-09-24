package br.com.markI.repositories;

import java.util.List;

import br.com.markI.dto.MunicipioDTO;
import br.com.markI.util.Estados;

public interface OcorrenciaRepository {

	
	public List<Long> obterAnosDeOcorrencia();

	public List<MunicipioDTO> obterMunicipiosPorSigla(Estados sigla,Integer[] anos);
}
