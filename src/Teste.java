void main() {

    Endereco e1 = new Endereco();
    Terreno t1 = new Terreno(LocalDate.now(), Status.DISPONIVEL_LOCACAO, e1, 1500.0, 2000.0);

   ClienteUsuario c1 = new ClienteUsuario("Henrique", e1, "050595", "M",
           "Solteiro", "Empresario", "@unifesspa.edu.br");

    Funcionario f1 = new Funcionario("Roberto",
            e1, "08080808", "M",
            "Solteiro", "Vendedor", "@unifesspa.edu.br",LocalDate.now(),
            "Vendedor", 1800.0, "roberto.edu", "0505");

    Venda v1 = new Venda(30.0, 40.0, LocalDate.now(), TipoTransacao.PIX, f1, c1, t1);
    f1.adicionarTransacao(v1);

    IO.println(f1.calculaSalario());
}
