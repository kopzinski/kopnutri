package br.com.kopzinski.kopnutri.controller;

import br.com.kopzinski.kopnutri.entities.Antropometria;
import br.com.kopzinski.kopnutri.service.AntropometriaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AntropometriaController {
    private boolean novo ;
    private List<Antropometria> objetos;
    private Antropometria objetoSelecionado;
    private static AntropometriaService objetoService;

    public AntropometriaController() {
        objetoService = new AntropometriaService();
        objetos = objetoService.findAll();
        objetos = objetoService.findAllByIdAtleta(3);
        objetoSelecionado = new Antropometria();
    }
    
//    public String listarPorAtleta(int idAtleta) {
//        
//    }

    public String novo() {
        novo = true;
        setObjetoSelecionado(new Antropometria());
        return("/formAntropometria?faces-redirect=true");
    }
    
    public String editar(Antropometria a) {
        setObjetoSelecionado(a);
        novo = false;
        return("/formAntropometria?faces-redirect=true");
    }    
    
    public String salvar() {
        if(novo) {
            getObjetos().add(getObjetoSelecionado());
            objetoService.persist(getObjetoSelecionado());
        } else {
            objetoService.update(getObjetoSelecionado());
        }
        setObjetoSelecionado(new Antropometria());
        novo = true;
        return("/listAntropometrias?faces-redirect=true");    
    }    
    
    public void remover (Antropometria a) {
        getObjetos().remove(a);
        objetoService.delete(a);
    }
    
    
    
    public boolean isNovo() {
        return novo;
    }
    public void setNovo(boolean novo) {
        this.novo = novo;
    }    

    public List<Antropometria> getObjetos() {
        return objetos;
    }

    public void setObjetos(List<Antropometria> objetos) {
        this.objetos = objetos;
    }

    public Antropometria getObjetoSelecionado() {
        return objetoSelecionado;
    }

    public void setObjetoSelecionado(Antropometria objetoSelecionado) {
        this.objetoSelecionado = objetoSelecionado;
    }
    
    
}
