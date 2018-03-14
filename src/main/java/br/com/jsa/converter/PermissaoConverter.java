package br.com.jsa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.Permissao;
import br.com.jsa.model.TipoTelefone;
import br.com.jsa.service.PermissaoService;

@Named
public class PermissaoConverter implements Converter{

	@Inject
	private PermissaoService PermissaoConverter; 
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null) {
			try{
				return PermissaoConverter.getPermisao(Long.valueOf(value));
			}catch (NumberFormatException e) {
				return null;
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		Permissao permissao = null;
		if(value != null) {
			permissao = (Permissao) value;
			return permissao.getIdPermissao().toString();
		}
		
		return null;
	}

}
