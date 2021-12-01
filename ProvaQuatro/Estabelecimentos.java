
import java.util.Objects;
public abstract class Estabelecimentos {
    private int idEsta;
    private String nome;
    private String dataDeAbertura;
    private Endereco endereco;

    protected Estabelecimentos(int idEsta, String nome, String dataDeAbertura, int idEndereco, int cep, String rua, int numero, String bairro, String cidade) {
        this.idEsta = idEsta;
        this.nome = nome;
        this.dataDeAbertura = dataDeAbertura;
        this.endereco = new Endereco(
            idEndereco,
            cep,
            rua,
            numero,
            bairro,
            cidade,
            this
            );
    }

    public void setIdEstta(int idEsta) {
        this.idEsta = idEsta;
    }

    public int getIdEsta() {
        return idEsta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDataDeAbertura(String dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public String getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Estabelecimentos)) {
            return false;
        }
        Estabelecimentos estabelecimentos = (Estabelecimentos) obj;
        return Objects.equals(idEsta, estabelecimentos.idEsta);
    }

    @Override
    public String toString(){
		return "\n O id da padaria é: " + getIdEsta() +
               "\n O nome da padaria é: " + getNome() +
               "\n Data de inauguração: " + getDataDeAbertura()  + "\n\n";
    }
}
