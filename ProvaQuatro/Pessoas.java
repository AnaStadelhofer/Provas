
import java.sql.Date;
import java.util.Objects;
public abstract class Pessoas {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;

    protected Pessoas(int id, String nome, String cpf, Date dataNascimento){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Pessoas)) {
            return false;
        }
        Pessoas pessoas = (Pessoas) obj;
        return Objects.equals(cpf, pessoas.cpf);
    }
 
    public int hashCode() {
        return Objects.hash(nome, cpf, dataNascimento);
    }

    public abstract String toString();

}
