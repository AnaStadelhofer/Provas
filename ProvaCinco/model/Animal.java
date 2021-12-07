package model;

public abstract class Animal {
    private int idAnimal;
    private String nomeAnimal;

    protected Animal(int idAnimal, String nomeAnimal){
        this.idAnimal = idAnimal;
        this.nomeAnimal = nomeAnimal;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idAnimal;
        result = prime * result + ((nomeAnimal == null) ? 0 : nomeAnimal.hashCode());
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
        Animal other = (Animal) obj;
        if (idAnimal != other.idAnimal)
            return false;
        if (nomeAnimal == null) {
            if (other.nomeAnimal != null)
                return false;
        } else if (!nomeAnimal.equals(other.nomeAnimal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n Id Animal: " + getIdAnimal() + 
               "\n Nome do Animal: " + getNomeAnimal();
    }

}
