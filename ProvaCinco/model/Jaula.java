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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + idJaula;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jaula other = (Jaula) obj;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (idJaula != other.idJaula)
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "\n Id Jaula: " + getIdJaula() + 
               "\n Descrição Jaula: " + getDescricao();
    }
}
