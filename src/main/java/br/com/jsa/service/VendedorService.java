package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.model.Vendedor;
import br.com.jsa.repository.VendedorRepository;

@Stateless
public class VendedorService {

	@Inject
	private VendedorRepository vendedorRepository;
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Vendedor getVendedor(Long idVendedor) {
		return vendedorRepository.getVendedor(idVendedor);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void salvar(Vendedor vendedor) {
		vendedorRepository.salvar(vendedor);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Vendedor> buscarTodosVendedores(){
		return vendedorRepository.buscarTodosVendedores();
	}
}
