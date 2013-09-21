package br.com.markI.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.markI.service.OcorrenciaService;

@Resource
@Path("/map/")
public class MapController extends BaseController {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	@Override
	@Get
	@Path("/")
	public void index() {
		super.index();
		
		this.result.include("anosOcorrencia",this.ocorrenciaService.obterAnosDeOcorrencia());
		
	}
	
}
