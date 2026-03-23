import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Imobiliaria {

    static Scanner sc = new Scanner(System.in);
    static Sistema sistema = new Sistema();
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        IO.println("SISTEMA DE IMOBILIÁRIA");

        int opcao = -1;
        while (opcao != 0) {
            IO.println(" MENU PRINCIPAl");
            IO.println("1. Gerenciar Imóveis");
            IO.println("2. Gerenciar Proprietários");
            IO.println("3. Gerenciar Clientes Usuários");
            IO.println("4. Gerenciar Funcionários");
            IO.println("5. Realizar Venda");
            IO.println("6. Realizar Aluguel");
            IO.println("7. Consultas");
            IO.println("0. Sair");
            IO.print("Escolha: ");
            opcao = lerInt();
            switch (opcao) {
                case 1 -> menuImoveis();
                case 2 -> menuProprietarios();
                case 3 -> menuUsuarios();
                case 4 -> menuFuncionarios();
                case 5 -> realizarVenda();
                case 6 -> realizarAluguel();
                case 7 -> menuConsultas();
                case 0 -> IO.println("Até logo!");
                default -> IO.println("Opção inválida.");
            }
        }
    }

    static void menuImoveis() {
        int op = -1;
        while (op != 0) {
            IO.println("\n── IMÓVEIS ──");
            IO.println("1. Cadastrar  2. Listar  3. Associar proprietário  0. Voltar");
            IO.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1 -> cadastrarImovel();
                case 2 -> listarImoveis(sistema.getImoveis());
                case 3 -> associarProprietario();
            }
        }
    }

    static void cadastrarImovel() {
        IO.println("\n1.Casa  2.Apartamento  3.Terreno  4.Sala Comercial");
        IO.print("Tipo: "); int tipo = lerInt();
        IO.println("1.Disponível Venda  2.Disponível Locação");
        IO.print("Status: "); int st = lerInt();
        Status status = (st == 1) ? Status.DISPONIVEL_VENDA : Status.DISPONIVEL_LOCACAO;
        IO.print("Data de construção (dd/MM/yyyy): "); LocalDate dataCons = lerData();
        Endereco end = lerEndereco();
        IO.print("Valor sugerido (R$): "); double valor = lerDouble();

        Imovel imovel = null;
        if (tipo == 1) {
            IO.print("Quartos: "); int q = lerInt();
            IO.print("Suítes: "); int su = lerInt();
            IO.print("Salas estar: "); int se = lerInt();
            IO.print("Salas jantar: "); int sj = lerInt();
            IO.print("Vagas garagem: "); int g = lerInt();
            IO.print("Área (m²): "); double area = lerDouble();
            IO.print("Mobiliado? (s/n): "); boolean mob = lerSN();
            IO.print("Descrição: "); String desc = lerLinha();
            imovel = new Casa(dataCons, status, end, valor, q, su, se, sj, g, area, mob, desc);
        } else if (tipo == 2) {
            IO.print("Quartos: "); int q = lerInt();
            IO.print("Suítes: "); int su = lerInt();
            IO.print("Salas estar: "); int se = lerInt();
            IO.print("Salas jantar: "); int sj = lerInt();
            IO.print("Vagas garagem: "); int g = lerInt();
            IO.print("Área (m²): "); double area = lerDouble();
            IO.print("Mobiliado? (s/n): "); boolean mob = lerSN();
            IO.print("Andar: "); int andar = lerInt();
            IO.print("Condomínio (R$): "); double cond = lerDouble();
            IO.print("Portaria 24h? (s/n): "); boolean port = lerSN();
            IO.print("Descrição: "); String desc = lerLinha();
            imovel = new Apartamento(dataCons, status, end, valor, q, su, se, sj, g, area, mob, andar, cond, port, desc);
        } else if (tipo == 3) {
            IO.print("Área (m²): "); double area = lerDouble();
            IO.print("Largura (m): "); double larg = lerDouble();
            IO.print("Comprimento (m): "); double comp = lerDouble();
            IO.print("Aclive/declive? (s/n): "); boolean acl = lerSN();
            imovel = new Terreno(dataCons, status, end, valor, valor, area, larg, comp, acl);
        } else if (tipo == 4) {
            IO.print("Área (m²): "); double area = lerDouble();
            IO.print("Banheiros: "); int ban = lerInt();
            IO.print("Cômodos: "); int com = lerInt();
            imovel = new SalaComercial(dataCons, status, end, valor, area, ban, com);
        } else { IO.println("Tipo inválido."); return; }
        sistema.cadastroImovel(imovel);
    }

    static void listarImoveis(List<Imovel> lista) {
        if (lista.isEmpty()) { IO.println("Nenhum imóvel encontrado."); return; }
        lista.forEach(i -> {
            IO.println(i);
            IO.println(i.detalhes());
            IO.println("Endereço: " + i.getEndereco());
        });
    }

    static void associarProprietario() {
        if (sistema.getImoveis().isEmpty()) { IO.println("Nenhum imóvel cadastrado."); return; }
        if (sistema.getPropietarios().isEmpty()) { IO.println("Nenhum proprietário cadastrado."); return; }
        sistema.getImoveis().forEach(i -> IO.println("  [" + i.getId() + "] " + i.categoria() + " - " + i.getEndereco()));
        IO.print("ID do imóvel: "); int idImo = lerInt();
        for (int i = 0; i < sistema.getPropietarios().size(); i++)
            IO.println("  [" + i + "] " + sistema.getPropietarios().get(i).getNome());
        IO.print("Índice do proprietário: "); int idxP = lerInt();
        Imovel imo = sistema.getImoveis().stream().filter(x -> x.getId() == idImo).findFirst().orElse(null);
        if (imo == null || idxP < 0 || idxP >= sistema.getPropietarios().size()) { IO.println("Dados inválidos."); return; }
        sistema.imovelDoPropietario(sistema.getPropietarios().get(idxP), imo);
    }

    static void menuProprietarios() {
        int op = -1;
        while (op != 0) {
            IO.println("PROPRIETÁRIOS");
            IO.println("1. Cadastrar  2. Listar  0. Voltar");
            IO.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1 -> { ClientePropietario p = lerDadosProprietario(); sistema.cadastroProprietario(p); }
                case 2 -> { if (sistema.getPropietarios().isEmpty()) { IO.println("Nenhum cadastrado."); break; }
                    sistema.getPropietarios().forEach(IO::println); }
            }
        }
    }

    static ClientePropietario lerDadosProprietario() {
        IO.println("Dados do Proprietário");
        IO.print("Nome: "); String nome = lerLinha();
        IO.print("CPF: "); String cpf = lerLinha();
        IO.print("Email: "); String email = lerLinha();
        IO.print("Sexo (M/F): "); String sexo = lerLinha();
        IO.print("Estado Civil: "); String ec = lerLinha();
        IO.print("Profissão: "); String prof = lerLinha();
        Endereco end = lerEndereco();
        return new ClientePropietario(nome, end, cpf, sexo, ec, prof, email, null);
    }
    static void menuUsuarios() {
        int op = -1;
        while (op != 0) {
            IO.println("\n── CLIENTES USUÁRIOS ──");
            IO.println("1. Cadastrar  2. Listar  3. Adicionar fiador/indicação  0. Voltar");
            IO.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1 -> { ClienteUsuario u = lerDadosUsuario(); sistema.cadastroUsuario(u); }
                case 2 -> {
                    if (sistema.getUsuarios().isEmpty()) { IO.println("Nenhum cadastrado."); break; }
                    sistema.getUsuarios().forEach(u -> {
                        IO.println(u);
                        IO.println("   └─ Fiadores: " + u.getFiador() + " | Indicações: " + u.getIndicacao());
                    });
                }
                case 3 -> adicionarFiadorIndicacao();
            }
        }
    }

    static ClienteUsuario lerDadosUsuario() {
        IO.println("Dados do Usuário");
        IO.print("Nome: "); String nome = lerLinha();
        IO.print("CPF: "); String cpf = lerLinha();
        IO.print("Email: "); String email = lerLinha();
        IO.print("Sexo (M/F): "); String sexo = lerLinha();
        IO.print("Estado Civil: "); String ec = lerLinha();
        IO.print("Profissão: "); String prof = lerLinha();
        Endereco end = lerEndereco();
        return new ClienteUsuario(nome, end, cpf, sexo, ec, prof, email);
    }

    static void adicionarFiadorIndicacao() {
        if (sistema.getUsuarios().isEmpty()) { IO.println("Nenhum usuário cadastrado."); return; }
        for (int i = 0; i < sistema.getUsuarios().size(); i++)
            IO.println("  [" + i + "] " + sistema.getUsuarios().get(i).getNome());
        IO.print("Índice do usuário: "); int idx = lerInt();
        if (idx < 0 || idx >= sistema.getUsuarios().size()) { IO.println("Inválido."); return; }
        ClienteUsuario u = sistema.getUsuarios().get(idx);
        IO.println("1. Adicionar fiador  2. Adicionar indicação");
        IO.print("Escolha: "); int op = lerInt();
        if (op == 1) { IO.print("Nome do fiador: "); u.adicionarFiador(lerLinha()); IO.println("Fiador adicionado!"); }
        else if (op == 2) { IO.print("Nome da indicação: "); u.adicionarIndicacao(lerLinha()); IO.println("Indicação adicionada!"); }
    }
    static void menuFuncionarios() {
        int op = -1;
        while (op != 0) {
            IO.println("\n── FUNCIONÁRIOS ──");
            IO.println("1. Cadastrar  2. Listar  0. Voltar");
            IO.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1 -> cadastrarFuncionario();
                case 2 -> { if (sistema.getFuncionarios().isEmpty()) { IO.println("Nenhum cadastrado."); break; }
                    sistema.getFuncionarios().forEach(f -> IO.println(f.getNome() + " | Cargo: " + f.getCargo() + " | Salário: R$ " + String.format("%.2f", f.calculaSalario()))); }
            }
        }
    }

    static void cadastrarFuncionario() {
        IO.println("\n── Cadastrar Funcionário ──");
        IO.print("Nome: "); String nome = lerLinha();
        IO.print("CPF: "); String cpf = lerLinha();
        IO.print("Email: "); String email = lerLinha();
        IO.print("Sexo (M/F): "); String sexo = lerLinha();
        IO.print("Estado Civil: "); String ec = lerLinha();
        IO.print("Profissão: "); String prof = lerLinha();
        IO.print("Data de ingresso (dd/MM/yyyy): "); LocalDate dataIng = lerData();
        IO.print("Cargo: "); String cargo = lerLinha();
        IO.print("Salário base (R$): "); double sal = lerDouble();
        IO.print("Login: "); String login = lerLinha();
        IO.print("Senha: "); String senha = lerLinha();
        Endereco end = lerEndereco();
        sistema.cadastrarFuncionario(new Funcionario(nome, end, cpf, sexo, ec, prof, email, dataIng, cargo, sal, login, senha));
    }
    static void realizarVenda() {
        IO.println("\n── Realizar Venda ──");
        List<Imovel> disp = sistema.imoveisDIsponiveisVenda();
        if (disp.isEmpty()) { IO.println("Nenhum imóvel disponível para venda."); return; }
        if (sistema.getUsuarios().isEmpty()) { IO.println("Nenhum cliente usuário cadastrado."); return; }
        if (sistema.getFuncionarios().isEmpty()) { IO.println("Nenhum funcionário cadastrado."); return; }

        disp.forEach(i -> IO.println("  [" + i.getId() + "] " + i.categoria() + " - R$ " + i.getValorSugerido()));
        IO.print("ID do imóvel: "); int idImo = lerInt();
        for (int i = 0; i < sistema.getUsuarios().size(); i++) IO.println("  [" + i + "] " + sistema.getUsuarios().get(i).getNome());
        IO.print("Índice do comprador: "); int idxU = lerInt();
        for (int i = 0; i < sistema.getFuncionarios().size(); i++) IO.println("  [" + i + "] " + sistema.getFuncionarios().get(i).getNome());
        IO.print("Índice do funcionário: "); int idxF = lerInt();
        IO.println("1.PIX  2.Cartão  3.Boleto  4.Dinheiro  5.Cheque");
        IO.print("Forma de pagamento: "); TipoTransacao fp = lerFormaPagamento();
        IO.print("Valor de venda (R$): "); double val = lerDouble();
        IO.print("% comissão imobiliária: "); double pctI = lerDouble();
        IO.print("% comissão funcionário: "); double pctF = lerDouble();

        Imovel imo = disp.stream().filter(x -> x.getId() == idImo).findFirst().orElse(null);
        if (imo == null || idxU < 0 || idxU >= sistema.getUsuarios().size() || idxF < 0 || idxF >= sistema.getFuncionarios().size()) { IO.println("Dados inválidos."); return; }
        try { Venda v = sistema.fazerVenda(pctF, pctI, LocalDate.now(), fp, sistema.getFuncionarios().get(idxF), sistema.getUsuarios().get(idxU), imo, val);
            IO.println("Venda realizada! Contrato nº " + v.getNumeroContrato()); }
        catch (Exception e) { IO.println("Erro: " + e.getMessage()); }
    }

    static void realizarAluguel() {
        IO.println("Realizar Aluguel");
        List<Imovel> disp = sistema.imoveisDisponiveisAluguel();
        if (disp.isEmpty()) { IO.println("Nenhum imóvel disponível para locação."); return; }
        if (sistema.getUsuarios().isEmpty()) { IO.println("Nenhum cliente usuário cadastrado."); return; }
        if (sistema.getFuncionarios().isEmpty()) { IO.println("Nenhum funcionário cadastrado."); return; }

        disp.forEach(i -> IO.println("  [" + i.getId() + "] " + i.categoria() + " - R$ " + i.getValorSugerido() + "/mês"));
        IO.print("ID do imóvel: "); int idImo = lerInt();
        for (int i = 0; i < sistema.getUsuarios().size(); i++) {
            ClienteUsuario u = sistema.getUsuarios().get(i);
            IO.println("  [" + i + "] " + u.getNome() + (u.aptoAlugar() ? " ✓" : " ✗ sem fiador/indicação suficientes"));
        }
        IO.print("Índice do inquilino: "); int idxU = lerInt();
        for (int i = 0; i < sistema.getFuncionarios().size(); i++) IO.println("  [" + i + "] " + sistema.getFuncionarios().get(i).getNome());
        IO.print("Índice do funcionário: "); int idxF = lerInt();
        IO.println("1.PIX  2.Cartão  3.Boleto  4.Dinheiro  5.Cheque");
        IO.print("Forma de pagamento: "); TipoTransacao fp = lerFormaPagamento();
        IO.print("Valor do aluguel (R$): "); double val = lerDouble();
        IO.print("Duração (meses): "); int meses = lerInt();
        IO.print("% comissão imobiliária: "); double pctI = lerDouble();
        IO.print("% comissão funcionário: "); double pctF = lerDouble();

        Imovel imo = disp.stream().filter(x -> x.getId() == idImo).findFirst().orElse(null);
        if (imo == null || idxU < 0 || idxU >= sistema.getUsuarios().size() || idxF < 0 || idxF >= sistema.getFuncionarios().size()) { IO.println("Dados inválidos."); return; }
        try { Aluguel a = sistema.fazerAluguel(pctF, pctI, fp, sistema.getFuncionarios().get(idxF), sistema.getUsuarios().get(idxU), imo, val, meses);
            IO.println("Aluguel realizado! Contrato nº " + a.getNumeroContrato() + " | Vencimento: " + a.getDataVencimento().format(fmt)); }
        catch (Exception e) { IO.println("Erro: " + e.getMessage()); }
    }
    static void menuConsultas() {
        int op = -1;
        while (op != 0) {
            IO.println("CONSULTAS");
            IO.println("1.Disponíveis venda  2.Disponíveis locação  3.Por categoria");
            IO.println("4.Todas transações   5.Transações funcionário  6.Todos imóveis  0.Voltar");
            IO.print("Escolha: ");
            op = lerInt();
            switch (op) {
                case 1 -> listarImoveis(sistema.imoveisDIsponiveisVenda());
                case 2 -> listarImoveis(sistema.imoveisDisponiveisAluguel());
                case 3 -> {
                    IO.println("1.Casa  2.Apartamento  3.Terreno  4.Sala Comercial");
                    IO.print("Tipo: "); int t = lerInt();
                    String[] cats = {"Casa","Apartamento","Terreno","Sala Comercial"};
                    if (t >= 1 && t <= 4) listarImoveis(sistema.imoveisCategoria(cats[t-1]));
                }
                case 4 -> sistema.todasTransacoes();
                case 5 -> {
                    if (sistema.getFuncionarios().isEmpty()) { IO.println("Nenhum funcionário."); break; }
                    for (int i = 0; i < sistema.getFuncionarios().size(); i++) IO.println("  [" + i + "] " + sistema.getFuncionarios().get(i).getNome());
                    IO.print("Índice: "); int idx = lerInt();
                    if (idx >= 0 && idx < sistema.getFuncionarios().size())
                        sistema.transacoesFuncionario(sistema.getFuncionarios().get(idx)).forEach(IO::println);
                }
                case 6 -> listarImoveis(sistema.getImoveis());
            }
        }
    }
    static Endereco lerEndereco() {
        IO.println("── Endereço ──");
        IO.print("Rua: "); String rua = lerLinha();
        IO.print("Número: "); String num = lerLinha();
        IO.print("Complemento: "); String comp = lerLinha();
        IO.print("Bairro: "); String bairro = lerLinha();
        IO.print("Cidade: "); String cidade = lerLinha();
        IO.print("Estado (ex: CE): "); String estado = lerLinha();
        return new Endereco(rua, comp, estado, cidade, bairro, num);
    }

    static TipoTransacao lerFormaPagamento() {
        return switch (lerInt()) {
            case 1 -> TipoTransacao.PIX;
            case 2 -> TipoTransacao.CARTADECREDITO;
            case 3 -> TipoTransacao.BOLETO;
            case 4 -> TipoTransacao.DINHEIRO;
            default -> TipoTransacao.CHEQUE;
        };
    }

    static int lerInt() {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (NumberFormatException e) { IO.print("Digite um número inteiro: "); }
        }
    }

    static double lerDouble() {
        while (true) {
            try { return Double.parseDouble(sc.nextLine().trim().replace(",", ".")); }
            catch (NumberFormatException e) { IO.print("Digite um valor numérico: "); }
        }
    }

    static LocalDate lerData() {
        while (true) {
            try { return LocalDate.parse(sc.nextLine().trim(), fmt); }
            catch (Exception e) { IO.print("Use dd/MM/yyyy: "); }
        }
    }

    static boolean lerSN() { return sc.nextLine().trim().equalsIgnoreCase("s"); }
    static String lerLinha() { return sc.nextLine().trim(); }
}