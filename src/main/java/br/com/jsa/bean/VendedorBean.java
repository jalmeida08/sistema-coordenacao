package br.com.jsa.bean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Vendedor;
import br.com.jsa.service.VendedorService;

@RequestScoped
@Named("vendedorBean")
public class VendedorBean {

	@Inject
	private VendedorService vendedorService;
	@Inject
	private Vendedor vendedor;
	private List<Vendedor> vendedores = new ArrayList<>();
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public String salvar() {
		vendedorService.salvar(vendedor);
		vendedor = new Vendedor();
		return "form?faces-redirect=true";
	}
	
	public List<Vendedor>getVendedores() {
		vendedores = vendedorService.buscarTodosVendedores();
		return vendedores;
	}
	
}
