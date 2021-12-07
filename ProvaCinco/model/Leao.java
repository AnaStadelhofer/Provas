package model;
import java.sql.Date;
import java.util.ArrayList;

public class Leao extends Animal {
    private int visitante;
    private Jaula jaula;

    private ArrayList<Alimentacao> alimentacaos = new ArrayList<>();

    public Leao (int visitante, int idAnimal, String nomeAnimal, Jaula jaula){
       super(idAnimal, nomeAnimal);
       this.visitante = visitante;
       this.jaula = jaula;
    }

    public int getVisitante() {
        return visitante;
    }

    public void setVisitante(int visitante) {
        this.visitante = visitante;
    }

    public void setJaula(Jaula jaula){
        this.jaula = jaula;
    }

    public Jaula getJaula(){
        return jaula;
    }

    public void adicionarAlimentacao(Alimentacao alimentacao) {
        this.alimentacaos.add(alimentacao);
    }

    public void setAlimentacao(Alimentacao alimentacao) {
        this.alimentacaos.add(alimentacao);
    }

    public ArrayList<Alimentacao> getAlimentacao() {
        return this.alimentacaos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + visitante;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Leao other = (Leao) obj;
        if (visitante != other.visitante)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n Id Animal: " + getIdAnimal() + 
               "\n Nome do Animal: " + getNomeAnimal() +
               "\n Nº visitante: " + getVisitante() +
               "\n\n --> Id da Jaula: " + getJaula() +
               "\n\n --> Alimentações: " + getAlimentacao();
    }
    
}
