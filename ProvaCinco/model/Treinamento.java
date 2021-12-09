package model;

import java.sql.Date;

public class Treinamento {
    private int idTreinamento;
    private Date dataTreinamento;
    private String descricao;

    protected Treinamento(int idTreinamento, Date dataTreinamento, String descricao){
        this.idTreinamento = idTreinamento;
        this.dataTreinamento = dataTreinamento;
        this.descricao = descricao;
    }

    public int getIdTreinamento() {
        return idTreinamento;
    }

    public void setIdTreinamento(int idTreinamento) {
        this.idTreinamento = idTreinamento;
    }

    public Date getDataTreinamento() {
        return dataTreinamento;
    }

    public void setDataTreinamento(Date dataTreinamento) {
        this.dataTreinamento = dataTreinamento;
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
        result = prime * result + ((dataTreinamento == null) ? 0 : dataTreinamento.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + idTreinamento;
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
        Treinamento other = (Treinamento) obj;
        if (dataTreinamento == null) {
            if (other.dataTreinamento != null)
                return false;
        } else if (!dataTreinamento.equals(other.dataTreinamento))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (idTreinamento != other.idTreinamento)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n Id Treinamento: " + getIdTreinamento() + 
               "\n Data do Treino: " + getDataTreinamento() +
               "\n Descricao: " + getDescricao();
    }
}
