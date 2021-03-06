package br.com.markI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.markI.dto.MunicipioDTO;
import br.com.markI.repositories.OcorrenciaRepository;
import br.com.markI.util.Estados;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Transactional
	public List<Long> obterAnosDeOcorrencia() {
		
		return this.ocorrenciaRepository.obterAnosDeOcorrencia();
	}

	@Transactional
	public List<MunicipioDTO> obterMunicipiosPorSigla(Estados sigla,Integer[] anos) {
		
		return this.ocorrenciaRepository.obterMunicipiosPorSigla(sigla,anos);
	}

}
