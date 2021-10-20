package Provas.ProvaDoisss;

public class Endereco {
    int idEndereco;
    int cep;
    String rua;
    int numero;
    String bairro;
    String cidade;
    Padaria padaria;

    public Endereco(
        int idEndereco,
        int cep,
        String rua,
        int numero,
        String bairro,
        String cidade,
        Padaria padaria
    ) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.padaria = padaria;
    }
}
