package br.com.jsa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.jsa.model.Telefone;
import br.com.jsa.model.Usuario;
import br.com.jsa.model.Vendedor;

public class VendedorRepository {

	@Inject
	private EntityManager manager;

	public void salvar(Vendedor vendedor) {
		Usuario user = vendedor.getUsuario();
		user.setPessoa(vendedor);
		List<Telefone> list = vendedor.getTelefone();
		if (list != null) {
			for (Telefone telefone : list) {
				telefone.setPessoa(vendedor);
			}
		}
		vendedor.setUsuario(user);
		vendedor.setTelefone(list);
		manager.persist(vendedor);
	}

	public Vendedor getVendedor(Long idVendedor) {
		return manager.find(Vendedor.class, idVendedor);
	}

	public List<Vendedor> buscarTodosVendedores() {
		return manager.createQuery("select v from Vendedor v order by v.nome asc", Vendedor.class).getResultList();
	}

	public void atualizar(Vendedor vendedor) {
		Vendedor v = getVendedor(vendedor.getIdPessoa());
		List<Telefone> list = vendedor.getTelefone();
		
		v.getTelefone().clear();
		
		manager.flush();
		if(list.size() >= 1) {
			for (Telefone t : list) {
				t.setPessoa(v);
			}
		}
		
		
		v.setNome(vendedor.getNome());
		v.setDataNascimento(vendedor.getDataNascimento());
		v.setUsuario(vendedor.getUsuario());
		v.setTelefone(list);
		
		manager.merge(v);
	}

	public void remover(Vendedor vendedor) {
		manager.remove(vendedor);
	}

	public Vendedor detalheVendedor(Long idPessoa) {
		try {
			return manager.createQuery("select v from Vendedor v join br.com.jsa.model.Usuario u on u.idPessoa = v.idPessoa where v.idPessoa = :idPessoa", Vendedor.class)
			.setParameter("idPessoa", idPessoa)
			.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}

}