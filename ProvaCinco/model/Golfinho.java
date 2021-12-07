package model;

import java.util.ArrayList;

public class Golfinho extends Animal {
    private Jaula jaula;
    private ArrayList<Treinamento> treinamentos = new ArrayList<>();

    public Golfinho(int idAnimal, String nomeAnimal, Jaula jaula){
        super(idAnimal, nomeAnimal);
        this.jaula = jaula;
    }

    public void setJaula(Jaula jaula){
        this.jaula = jaula;
    }

    public Jaula getJaula(){
        return jaula;
    }

    public void adicionarTreinamento(Treinamento treinamento) {
        this.treinamentos.add(treinamento);
    }

    public void setAlimentacao(Treinamento treinamento) {
        this.treinamentos.add(treinamento);
    }

    public ArrayList<Treinamento> getTreinamento() {
        return this.treinamentos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((jaula == null) ? 0 : jaula.hashCode());
        result = prime * result + ((treinamentos == null) ? 0 : treinamentos.hashCode());
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
        Golfinho other = (Golfinho) obj;
        if (jaula == null) {
            if (other.jaula != null)
                return false;
        } else if (!jaula.equals(other.jaula))
            return false;
        if (treinamentos == null) {
            if (other.treinamentos != null)
                return false;
        } else if (!treinamentos.equals(other.treinamentos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n Id Animal: " + getIdAnimal() + 
               "\n Nome do Animal: " + getNomeAnimal() +
               "\n Id da Jaula: " + getJaula() +
               "\n Treinamentos: " + getTreinamento();
    }
}
