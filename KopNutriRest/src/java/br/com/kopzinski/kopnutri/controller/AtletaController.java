package br.com.kopzinski.kopnutri.controller;

import br.com.kopzinski.kopnutri.entities.Atleta;
import br.com.kopzinski.kopnutri.service.AtletaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AtletaController {
    private boolean novo ;
    private List<Atleta> objetos;
    private Atleta objetoSelecionado;
    private AtletaService objetoService;

    public AtletaController() {
        objetoService = new AtletaService();
        objetos = objetoService.findAll();
        objetoSelecionado = new Atleta();
    }

    public String novo() {
        novo = true;
        setObjetoSelecionado(new Atleta());
        return("/formAtleta?faces-redirect=true");
    }
    
    public String editar(Atleta a) {
        setObjetoSelecionado(a);
        novo = false;
        return("/formAtleta?faces-redirect=true");
    }    
    
    public String salvar() {
        if(novo) {
            getObjetos().add(getObjetoSelecionado());
            getObjetoService().persist(getObjetoSelecionado());
        } else {
            getObjetoService().update(getObjetoSelecionado());
        }
        setObjetoSelecionado(new Atleta());
        novo = true;
        return("/listAtletas?faces-redirect=true");    
    }    
    
    public void remover (Atleta a) {
        getObjetos().remove(a);
        getObjetoService().delete(a);
    }
    
    
    
    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }    

    public List<Atleta> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Atleta> objetos) {
        this.objetos = objetos;
    }

    public Atleta getObjetoSelecionado() {
        return objetoSelecionado;
    }

    public void setObjetoSelecionado(Atleta objetoSelecionado) {
        this.objetoSelecionado = objetoSelecionado;
    }

    public AtletaService getObjetoService() {
        return objetoService;
    }

    public void setObjetoService(AtletaService objetoService) {
        this.objetoService = objetoService;
    }
    
    
}
