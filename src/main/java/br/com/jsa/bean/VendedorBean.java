package br.com.jsa.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Vendedor;
import br.com.jsa.service.VendedorService;

@Named("vendedorBean")
@SessionScoped
public class VendedorBean implements Serializable{
	
	private static final long serialVersionUID = -5460821205129034444L;
	
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
