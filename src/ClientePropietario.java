import java.util.ArrayList;
import java.util.List;

public class ClientePropietario extends Pessoa{
    private List<Imovel> imoveis;

    public ClientePropietario(String nome, Endereco endereco, String cpf, String sexo, String estadoCivil, String profissao, String email, Imovel imoveis) {
        super(nome, endereco, cpf, sexo, estadoCivil, profissao, email);
        this.imoveis = new ArrayList<>();
    }

    public List<Imovel> getImoveis() {
        return imoveis;
    }
    public void setImoveis(List<Imovel> imoveis) {
        this.imoveis = imoveis;
    }

    void adicionarImovel(Imovel imovel) {
        this.imoveis.add(imovel);
    }
    void removerImovel(Imovel imovel) {
        this.imoveis.remove(imovel);
    }
    @Override
    public String toString() {
        return "Propietário "+super.toString()+" Imoveis: "+imoveis.size();
    }
}
