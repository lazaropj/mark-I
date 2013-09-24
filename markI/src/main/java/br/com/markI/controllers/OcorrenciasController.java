package br.com.markI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.markI.dto.MunicipioDTO;
import br.com.markI.service.OcorrenciaService;
import br.com.markI.util.Estados;

@Resource
@Path("/ocorrencias/")
public class OcorrenciasController extends BaseController {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	@Post
	@Path("/municipios.json")
	public void loadMunicipios(Estados sigla,Integer[] anos){
		
		List<MunicipioDTO> municipiosList = this.ocorrenciaService.obterMunicipiosPorSigla(sigla,anos);
		this.setListResult(municipiosList);
		
	}
	
}
