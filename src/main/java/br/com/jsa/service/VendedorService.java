package br.com.jsa.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.jsa.EnviarEmail;
import br.com.jsa.GerarSenhas;
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

		String senha = GerarSenhas.getRandomPassword();
		vendedor.getUsuario().setSenha(senha);
		vendedor.getUsuario().setSenhaAleatoria(true);

		EnviarEmail enviarEmail = new EnviarEmail(vendedor.getUsuario().getEmail(),
				senha);

		if (enviarEmail.enviarEmailDePrimeiroAcesso() == false) {
			throw new RuntimeException("Erro ai enviar o e-mail");
		}
		vendedorRepository.salvar(vendedor);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Vendedor> buscarTodosVendedores() {
		return vendedorRepository.buscarTodosVendedores();
	}

	public void remover(Vendedor vendedor) {
		vendedorRepository.remover(vendedor);
		
	}

	public Vendedor detalheVendedor(Long idPessoa) {
		return vendedorRepository.detalheVendedor(idPessoa);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void atualizar(Vendedor vendedor) {
		vendedorRepository.atualizar(vendedor);
	}

}
