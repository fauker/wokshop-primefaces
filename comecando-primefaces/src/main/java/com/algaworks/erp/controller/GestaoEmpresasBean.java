package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.service.CadastroEmpresaService;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	
	private List<Empresa> todasEmpresas;
	private Empresa empresa = new Empresa();
	
	public void prepararNovoCadastro() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		consultar();
	}
	
	public void consultar() {
		todasEmpresas = empresas.todas();
	}
	
	public TipoEmpresa[] getTiposEmpresas() {
		return TipoEmpresa.values();
	}
	
	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
}
