package br.com.markI.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/map/")
public class MapController extends BaseController {

	
	@Override
	@Get
	@Path("/")
	public void index() {
		super.index();
		
		//this.result.include("anosOcorrencia",this.ocorrenciaService.obterAnosDeOcorrencia());
		
	}
	
	
}
