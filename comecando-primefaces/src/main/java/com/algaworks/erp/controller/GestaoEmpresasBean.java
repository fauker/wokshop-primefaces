package com.algaworks.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;
import com.algaworks.erp.repository.Empresas;
import com.algaworks.erp.service.CadastroEmpresaService;
import com.algaworks.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEmpresasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;
	
	@Inject
	private CadastroEmpresaService cadastroEmpresaService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Empresa> todasEmpresas;
	private Empresa empresa = new Empresa();
	private Empresa empresaSelecionada;
	
	public void prepararNovoCadastro() {
		empresa = new Empresa();
	}
	
	public void salvar() {
		cadastroEmpresaService.salvar(empresa);
		consultar();
		
		messages.info("Empresa cadastrada com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		cadastroEmpresaService.excluir(empresaSelecionada);
		empresaSelecionada = null;
		consultar();
		
		messages.info("Empresa exluida com sucesso!");
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

	public Empresa getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Empresa empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	
	
}
