package numeronmode.player1;
import javax.swing.*;
import java.awt.*;
public class Player1_Mode extends JFrame{
    private DisplayPanel input, result;
    private ButtonPanel buttons;

    public Player1_Mode()throws Exception{
        setTitle("NumeronGame");
        setSize(900,600);
        setMinimumSize(new Dimension(900,600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));
        
        setPanels();
        setVisible(true);
    }

    private void setPanels()throws Exception{
        input = new DisplayPanel();
        for(int i = 0; i < 8; i++){
            input.getDisplayLabelList().get(i).setText("【" + Integer.toString(i+1) + "回目】  ");
        }
        result = new DisplayPanel();
        buttons = new ButtonPanel(input.getDisplayLabelList(), result.getDisplayLabelList(), this);

        add(input); add(result); add(buttons);
    }
}