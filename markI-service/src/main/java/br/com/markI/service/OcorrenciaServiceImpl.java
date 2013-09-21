package br.com.markI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.markI.repositories.OcorrenciaRepository;

@Service
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Transactional
	public List<Long> obterAnosDeOcorrencia() {
		
		return this.ocorrenciaRepository.obterAnosDeOcorrencia();
	}

}
