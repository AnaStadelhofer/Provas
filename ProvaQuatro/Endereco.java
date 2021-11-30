
import java.util.Objects;
public class Endereco {
    private int idEndereco;
    private int cep;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private Estabelecimentos estabelecimentos;

    public Endereco(int idEndereco, int cep, String rua, int numero, String bairro, String cidade, Estabelecimentos estabelecimentos) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estabelecimentos = estabelecimentos;
    }

    public void setIdEndereco(int idEndereco){
        this.idEndereco = idEndereco;
    }

    public int getIdEndereco(){
        return idEndereco;
    }

    public void setCep(int cep){
        this.cep = cep;
    }

    public int getCep(){
        return cep;
    }
    
    public void setRua(String rua){
        this.rua = rua;
    }

    public String getRua(){
        return rua;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getBairro(){
        return bairro;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public String getCidade(){
        return cidade;
    }

    public void setEstabelecimentos(Estabelecimentos estabelecimentos){
        this.estabelecimentos = estabelecimentos;
    }

    public Estabelecimentos getEstabelecimentos(){
        return estabelecimentos;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) obj;
        return Objects.equals(this.getIdEndereco(), endereco.getIdEndereco());
    }

    @Override
    public String toString(){
		return " O id: " + getIdEndereco() +
               ". Cep: " + getCep() +
               ". Rua: " + getRua() +
               ", nº " + getNumero() + 
               ", bairro: " + getBairro() +
               ", cidade: " + getCidade();
    }
}
