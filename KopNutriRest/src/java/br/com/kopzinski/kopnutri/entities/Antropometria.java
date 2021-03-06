package br.com.kopzinski.kopnutri.entities;
// Generated Oct 16, 2015 8:03:10 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;


public class Antropometria  implements java.io.Serializable {


     private int id;
     private Atleta atleta;
     private Integer idade;
     private BigDecimal peso;
     private Date data;
     private BigDecimal musculo;
     private BigDecimal gordura;
     private BigDecimal agua;
     private BigDecimal osso;

    public Antropometria() {
        atleta = new Atleta();
    }

	
    public Antropometria(int id, BigDecimal peso, Date data) {
        this.id = id;
        this.peso = peso;
        this.data = data;
    }
    public Antropometria(int id, Atleta atleta, Integer idade, BigDecimal peso, Date data, BigDecimal musculo, BigDecimal gordura, BigDecimal agua, BigDecimal osso) {
       this.id = id;
       this.atleta = atleta;
       this.idade = idade;
       this.peso = peso;
       this.data = data;
       this.musculo = musculo;
       this.gordura = gordura;
       this.agua = agua;
       this.osso = osso;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Atleta getAtleta() {
        return this.atleta;
    }
    
    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
    public Integer getIdade() {
        return this.idade;
    }
    
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public BigDecimal getPeso() {
        return this.peso;
    }
    
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public BigDecimal getMusculo() {
        return this.musculo;
    }
    
    public void setMusculo(BigDecimal musculo) {
        this.musculo = musculo;
    }
    public BigDecimal getGordura() {
        return this.gordura;
    }
    
    public void setGordura(BigDecimal gordura) {
        this.gordura = gordura;
    }
    public BigDecimal getAgua() {
        return this.agua;
    }
    
    public void setAgua(BigDecimal agua) {
        this.agua = agua;
    }
    public BigDecimal getOsso() {
        return this.osso;
    }
    
    public void setOsso(BigDecimal osso) {
        this.osso = osso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Antropometria other = (Antropometria) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Antropometria{" + "id=" + id + ", atleta=" + atleta + ", idade=" + idade + ", peso=" + peso + ", data=" + data + ", musculo=" + musculo + ", gordura=" + gordura + ", agua=" + agua + ", osso=" + osso + '}';
    }




}


