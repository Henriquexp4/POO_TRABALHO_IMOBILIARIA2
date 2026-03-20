import java.util.ArrayList;
import java.util.List;

public class ClienteUsuario extends Cliente{
    private List<String> fiador;
    private List<String> indicacao;

    public ClienteUsuario(String nome, Endereco endereco, String cpf, String sexo, String estadoCivil, String profissao, String email) {
        super(nome, endereco, cpf, sexo, estadoCivil, profissao, email);
        this.fiador = new ArrayList<>();
        this.indicacao = new ArrayList<>();
    }

    public List<String> getFiador() {
        return fiador;
    }
    public void setFiador(List<String> fiador) {
        this.fiador = fiador;
    }
    public List<String> getIndicacao() {
        return indicacao;
    }
    public void setIndicacao(List<String> indicacao) {
        this.indicacao = indicacao;
    }

    void adicionarFiador(String fiador){
        this.fiador.add(fiador);
    }
    void adicionarIndicacao(String indicacao){
        this.indicacao.add(indicacao);
    }
    public boolean aptoAlugar(){
        return fiador.size() >= 1 && indicacao.size() >= 2;
    }

    @Override
    public String toString(){
        return "Usuario " + super.toString();
    }

}
