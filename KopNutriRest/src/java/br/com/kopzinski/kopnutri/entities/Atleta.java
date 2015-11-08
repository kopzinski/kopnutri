package br.com.kopzinski.kopnutri.entities;
// Generated Oct 16, 2015 8:03:10 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Atleta  implements java.io.Serializable {
    
    private int id;
    
    private String nome;
    private Date nascimento;
    private Set<Antropometria> antropometrias = new HashSet<Antropometria>(0);

    public Atleta() {
    }

	
    public Atleta(int id, String nome, Date nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
    }
    public Atleta(int id, String nome, Date nascimento, Set<Antropometria> antropometrias) {
       this.id = id;
       this.nome = nome;
       this.nascimento = nascimento;
       this.antropometrias = antropometrias;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getNascimento() {
        return this.nascimento;
    }
    
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    public Set<Antropometria> getAntropometrias() {
        return this.antropometrias;
    }
    
    public void setAntropometrias(Set<Antropometria> antropometrias) {
        this.antropometrias = antropometrias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
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
        final Atleta other = (Atleta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atleta{" + "id=" + id + ", nome=" + nome + ", nascimento=" + nascimento + ", antropometrias=" + antropometrias + '}';
    }




}

