import java.util.ArrayList;
import java.util.List;

public abstract class Pessoa {

    protected String nome;
    protected String cpf;
    protected Endereco endereco;
    protected List<String> telefone;
    protected String sexo;
    protected String estadoCivil;
    protected String profissao;
    protected String email;

    public Pessoa(String nome, Endereco endereco, String cpf, String sexo, String estadoCivil, String profissao, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.profissao = profissao;
        this.email = email;
        this.telefone =new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public List<String> getTelefone() {
        return telefone;
    }
    public void setTelefone(List<String> telefone) {
        this.telefone = telefone;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    void adicionarTelefone(String telefone){
        this.telefone.add(telefone);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco=" + endereco +
                ", telefone=" + telefone +
                ", sexo='" + sexo + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", profissao='" + profissao + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
