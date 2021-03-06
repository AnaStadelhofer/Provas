package model;

import java.sql.Date;

public class Alimentacao {
    private int idAlimentacao;
    private Date dataAlimentacao;
    private String detalhes;
    private Leao leao;
    
    public Alimentacao(int idAlimentacao, Date dataAlimentacao, String detalhes, Leao leao){
        this.idAlimentacao = idAlimentacao;
        this.dataAlimentacao = dataAlimentacao;
        this.detalhes = detalhes;
        this.leao = leao;

        leao.adicionarAlimentacao(this);
    }

    public int getIdAlimentacao() {
        return idAlimentacao;
    }

    public void setIdAlimentacao(int idAlimentacao) {
        this.idAlimentacao = idAlimentacao;
    }

    public Date getDataAlimentacao() {
        return dataAlimentacao;
    }

    public void setDataAlimentacao(Date dataAlimentacao) {
        this.dataAlimentacao = dataAlimentacao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Leao getLeao() {
        return leao;
    }

    public void setLeao(Leao leao) {
        this.leao = leao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dataAlimentacao == null) ? 0 : dataAlimentacao.hashCode());
        result = prime * result + ((detalhes == null) ? 0 : detalhes.hashCode());
        result = prime * result + idAlimentacao;
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
        Alimentacao other = (Alimentacao) obj;
        if (dataAlimentacao == null) {
            if (other.dataAlimentacao != null)
                return false;
        } else if (!dataAlimentacao.equals(other.dataAlimentacao))
            return false;
        if (detalhes == null) {
            if (other.detalhes != null)
                return false;
        } else if (!detalhes.equals(other.detalhes))
            return false;
        if (idAlimentacao != other.idAlimentacao)
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "\n Id Alimenta????o: " + getIdAlimentacao() + 
               "\n Data da alimenta????o: " + getDataAlimentacao() +
               "\n Detalhes: " + getDetalhes();
    }
}
