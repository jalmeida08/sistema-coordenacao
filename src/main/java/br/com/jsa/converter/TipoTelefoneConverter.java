package br.com.jsa.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jsa.model.TipoTelefone;
import br.com.jsa.service.TipoTelefoneService;

@Named
public class TipoTelefoneConverter implements Converter{

	@Inject
	private TipoTelefoneService tipoTelefoneService;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value != null) {
			return tipoTelefoneService.getTipoTelefone(Integer.valueOf(value));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		TipoTelefone tipoTelefone = null;
		if(value != null) {
			tipoTelefone = (TipoTelefone) value;
			return tipoTelefone.getIdTipoTelefone().toString();
		}
		
		return null;
	}

}
