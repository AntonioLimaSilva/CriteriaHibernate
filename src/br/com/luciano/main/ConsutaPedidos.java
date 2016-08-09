package br.com.luciano.main;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;

import br.com.luciano.model.Pedido;
import br.com.luciano.util.JPAUtil;

public class ConsutaPedidos {
	
	public static void main(String[] args) {

		EntityManager manager = JPAUtil.createEntityManager();
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Pedido.class);
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = criteria.list();
		
		pedidos.forEach(pedido -> System.out.println(pedido.getDescricao() + " - " + pedido.getFuncionario().getNome()));
		
	}
	
}