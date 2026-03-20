import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Funcionario extends Pessoa{

    private LocalDate dataIngresso;
    private String cargo;
    private Double salario;
    private String login;
    private String senha;
    private Double comissao;
    private List<Transacao> transacoes;

    public Funcionario(String nome, Endereco endereco, String cpf, String sexo, String estadoCivil, String profissao, String email, LocalDate dataIngresso, String cargo, Double salario, String login, String senha) {
        super(nome, endereco, cpf, sexo, estadoCivil, profissao, email);
        this.dataIngresso = dataIngresso;
        this.cargo = cargo;
        this.salario = salario;
        this.login = login;
        this.senha = senha;
        this.transacoes = new ArrayList<>();
        this.comissao = 30.0;
    }
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }
    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Double getComissao() {
        return comissao;
    }
    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    //@Override
    //public String toString() {
      ///  return "Funcionario{" + super.toString() +
       //        ", cargo='" + cargo + '\'' +
         //       ", salario=" + calculaSalario() + "}";
    //}

    public Double calculaSalario() {
        Double totalComissao = transacoes.stream().mapToDouble(  t -> t.getComissaoFuncionario()).sum();
        return salario+(totalComissao*comissao/100.0);
    }
    void adicionarTransacao(Transacao t) {
        this.transacoes.add(t);
    }

   // public boolean validarAcesso(String login, String senha){
    //    return this.login.equals(login) && this.senha.equals(senha);
  //  }
}
