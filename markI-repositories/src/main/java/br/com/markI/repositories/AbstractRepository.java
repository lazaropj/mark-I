package br.com.markI.repositories;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public abstract class AbstractRepository {

	@Autowired
	protected SessionFactory sessionFactory;
		
	//@Autowired
	//private SessionFactory sessionFactoryIcd;
		
//	private CouchDbProperties couchDbProperties;

	public AbstractRepository() {
		
	}

	protected Session getSession() {		
		return sessionFactory.getCurrentSession();
	}
	
	public abstract String getContextName();
	
	protected String getTemplateQuery(String qname,Map datamodel){
		
		String templateName=getContextName()+"-"+qname+".sql";
		
		ClassTemplateLoader ctl= new ClassTemplateLoader(getClass(),"");
		
		Configuration cfg = new Configuration();
		cfg.setTemplateUpdateDelay(0);
		cfg.setTemplateLoader(ctl);
		
		Template tpl = null;
		StringWriter sw = new StringWriter();
		
		try {
			tpl = cfg.getTemplate(templateName);
			tpl.process(datamodel,sw );
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
//		OutputStreamWriter output = new OutputStreamWriter(System.out);
		return sw.toString();
		
	}


	public List listQuery(String nameTpl,Map<String,Object> param,Class clazz) {
		
		if(param!=null)
		param.remove("isCount");
		
		/*if(filter.getFilter()!=null){
			
			String wherestatementValue = DTOParserUtil.getWherestatementValue(filter.getFilter());
			if(StringUtils.isNotEmpty(wherestatementValue))
				param.put("whereStatement", wherestatementValue);
			
		}*/
		
//		map.put("isCount", Boolean.TRUE);
		String sql = getTemplateQuery(nameTpl, param);
		
		Query q = null;
		if(sql.toLowerCase().contains("--sql")){
			q = getSession().createSQLQuery(sql.toLowerCase().replaceAll("--sql", ""));
		}else {
			q = getSession().createQuery(sql);
		}

		/*if(filter.getFilter()!=null){
			Map<String,Object> paramDTO = DTOParserUtil.getParametersValue(filter.getFilter());
			
			if(paramDTO.isEmpty()==false){
				for(String key : paramDTO.keySet()){
					q.setParameter(key, paramDTO.get(key));
				}
			}
		}
		
		if(filter.getPager()!=null){
			q.setMaxResults(filter.getPager().getRowsPerPage());
			q.setFirstResult(filter.getPager().getPageRows());
		}*/

		if(param!=null){
			/*for(String key : param.keySet()){
				q.setParameter(key, param.get(key));
			}*/
			q.setProperties(param);
		}
		
		if(clazz!=null){
			q.setResultTransformer(new AliasToBeanResultTransformer((Class)clazz));
		}
		List uniqueResult = q.list();
		
		return uniqueResult;
	}
	
}