package br.com.markI.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;


public class BaseController {

	
	@Get
	@Path("/")
	public void index(){
	}
	
	@Autowired
	protected Result result;
	
	@Autowired
	protected HttpSession session;
	
	@Autowired
	protected HttpServletResponse httpResponse;
	
	/*protected void  setGridListResult(List list){
		
		this.result.use(Results.json()).withoutRoot().from(new GridListResult(list)).recursive().serialize();
		
	}
	
	protected void  setListResult(List list){
		
		this.result.use(Results.json()).withoutRoot().from(list).recursive().serialize();
		
	}
	
	protected void  setGridListResult(GridListResult glr){
		
		this.result.use(Results.json()).withoutRoot().from(glr).recursive().serialize();
		
	}
	
	protected void  gridListResult(List list,Integer total,Integer page){
		
		this.result.use(Results.json()).withoutRoot().from(new GridListResult(list,total,page)).recursive().serialize();
		
	}*/
	
}
