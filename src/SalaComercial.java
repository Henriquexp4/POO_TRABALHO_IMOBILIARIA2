import java.time.LocalDate;

public class SalaComercial extends Imovel{
    private Double area;
    private Integer qtdBanheiros;
  private Integer qtdComodos;

    public SalaComercial(LocalDate dataContrucao, Status status, Endereco endereco, Double valorSugerido,
                         Double area, Integer qtdBanheiros, Integer qtdComodos) {
        super(dataContrucao, status, endereco, valorSugerido);
        this.area = area;
        this.qtdBanheiros = qtdBanheiros;
        this.qtdComodos = qtdComodos;
    }

    @Override
    public String categoria(){
      return "Sala Comercial";
    }
    @Override
    public String detalhes(){
        return "Area: " + area +"m2 / Banheiros: " +qtdBanheiros +" / Comodos: " +qtdComodos;
    }

    public Double getArea() {
        return area;
    }
    public void setArea(Double area) {
        this.area = area;
    }
    public Integer getQtdBanheiros() {
        return qtdBanheiros;
    }
    public void setQtdBanheiros(Integer qtdBanheiros) {
        this.qtdBanheiros = qtdBanheiros;
    }
    public Integer getQtdComodos() {
        return qtdComodos;
    }
    public void setQtdComodos(Integer qtdComodos) {
        this.qtdComodos = qtdComodos;
    }
}
