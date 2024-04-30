import java.util.List;

public class Banco {
   private String nome;
   public List<Conta> contas;

   public String getNome(){
    return nome;
   }
   public void setNome(String nome){
    this.nome=nome;
   }
   
}
