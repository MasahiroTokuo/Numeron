import numeronmode.SelectModeDialog;
public class NumeronGame{
    public static void main(String[] args){
        SelectModeDialog smd = null;
        try{
            smd = new SelectModeDialog();
        }catch(Exception e){
            System.out.println("想定外のエラーです");
            e.getMessage();
            e.printStackTrace();
        }
    }
}