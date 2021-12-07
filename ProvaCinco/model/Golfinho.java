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
    public String toString() {
        return "\n Id Animal: " + getIdAnimal() + 
               "\n Nome do Animal: " + getNomeAnimal() +
               "\n Id da Jaula: " + getJaula() +
               "\n Treinamentos: " + getTreinamento();
    }
}
