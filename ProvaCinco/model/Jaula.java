package model;

public class Jaula {
    private int idJaula;
    private String descricao;

    protected Jaula(int idJaula, String descricao){
        this.idJaula = idJaula;
        this.descricao = descricao;
    }

    public int getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(int idJaula) {
        this.idJaula = idJaula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return "\n Id Jaula: " + getIdJaula() + 
               "\n Descrição Jaula: " + getDescricao();
    }
}
