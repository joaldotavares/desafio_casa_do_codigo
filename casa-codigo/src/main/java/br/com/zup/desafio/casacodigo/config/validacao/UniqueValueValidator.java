package br.com.zup.desafio.casacodigo.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{
	
	private String domainAttribute;
	private Class<?> classes;
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void initialize(UniqueValue params) {
		domainAttribute = params.fieldName();
		classes = params.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " + classes.getName() + " where " + domainAttribute + "=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um " + classes + " com o atributo " + domainAttribute + " = " + value);
		return list.isEmpty();
	}

}
