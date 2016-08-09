package br.com.luciano.main;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import br.com.luciano.model.Pedido;
import br.com.luciano.util.JPAUtil;

public class ConsultaSomaGroupBy {

	public static void main(String[] args) {
		
		EntityManager manager = JPAUtil.createEntityManager();
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pedido.class);
		criteria.createAlias("funcionario", "f");
		criteria.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("f.nome"))
				.add(Projections.sum("valor")));

		
		@SuppressWarnings("unchecked")
		List<Object []> objs = criteria.list();
		
		objs.forEach(obj -> System.out.println(obj[0] + " = " + obj[1]));

	}

}
