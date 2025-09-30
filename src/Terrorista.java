public class Terrorista{
  public class Terrorista{
//Prova Fatec Bossini

//Pedido do cliente que todas as propriedades fossem privadas    
 private String NomeTerrorista;
 private String Armamento;
 private int QtdGranadas;
 private int Vida = 10;
 
 //Settering
 public void setNomeTerrorista(String NomeTerrorista){
     this.NomeTerrorista = NomeTerrorista;
 }
 public void setArmamento(String Armamento){
     this.Armamento = Armamento;
 }
 public void setQtdGranadas(int QtdGranadas){
     this.QtdGranadas = QtdGranadas;
 }
 public void setVida(int Vida){
     this.Vida = Vida;
 }
 
 //Gettering
 public String getNomeTerrorista(){
     return NomeTerrorista;
 }
 public String getArmamento(){
     return Armamento;
 }
 public int getQtdGranadas(){
     return QtdGranadas;
 }
 public int getVida(){
     return vida;
 }
 
 public void ReceberDano(int dano){
     if(Vida > 0){
         Vida -= dano;
     }
     if(vida <= 0){
         vida = 0;
         System.out.println(NomeTerrorista + "Faleceu");
     }
 }
 
 //método atacar 
 void Atacar(Personagem Policial, String Armamento){
    
    int dano = 0;
    
    switch(Armamento){
        case "faca":
            dano = 1;
            break;
        case "pistola":
            dano = 2;
            break;
        case "fuzil":
            dano = 3;
            break;
    }
    
     Policial.ReceberDano(dano);
     System.out.println(NomeTerrorista + "Atacou com " + Armamento);
     System.out.println(Policial.getNomePolicial() + "Ficou com vida = " + Policial.getVidaPolicial);
 }
 
 //método Plantar Bomba
 void PlantarBomba(){
     System.out.println("A bomba foi plantada por " + NomeTerrorista);
 }
 
 //método Lancar Granada
 void LancarGranada(Personagem Policial){
     int dano = 5;
     if(QtdGranadas>0){
         QtdGranadas -= 1;
         
         Policial.ReceberDano(dano);
         System.out.println("Granada lançada por " + NomeTerrorista);
         System.out.println("Granadas restantes " + QtdGranadas);
     }
     else{
         System.out.println("Sem Granadas Restantes");
     }
 }
 
 //método passar a vez
 void PassarVez(){
    System.out.println(NomeTerrorista + "Passou a vez"); 
 }
}
}