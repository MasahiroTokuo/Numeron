package numeronmode.pvp;
import javax.swing.*;
import java.awt.*;
import numeronmode.pvp.*;
public class PvP_Mode extends JFrame{
    private DisplayPanel_PvP input_p1, input_p2, result_p1, result_p2;
    private ButtonPanel_PvP buttons_p1, buttons_p2;
    private JPanel buttonsPanel;
    private CardLayout cl;
    private int[] answer_p1, answer_p2;

    public PvP_Mode(int[] answer_p1, int[] answer_p2)throws Exception{
        this.answer_p1 = answer_p1;
        this.answer_p2 = answer_p2;
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
        input_p1 = new DisplayPanel_PvP("Player1");
        result_p1 = new DisplayPanel_PvP("EAT-BITE");
        input_p2 = new DisplayPanel_PvP("Player2");
        result_p2 = new DisplayPanel_PvP("EAT-BITE");
        buttons_p1 = new ButtonPanel_PvP(input_p1.getDisplayLabelList(), result_p1.getDisplayLabelList(), this, answer_p2, 1);
        buttons_p2 = new ButtonPanel_PvP(input_p2.getDisplayLabelList(), result_p2.getDisplayLabelList(), this, answer_p1, 2);

        for(int i = 0; i < 8; i++){
            result_p1.getDisplayLabelList().get(i).setHorizontalAlignment(JLabel.CENTER);
            result_p2.getDisplayLabelList().get(i).setHorizontalAlignment(JLabel.CENTER);
        }

        JPanel player1Panel = new JPanel();
        player1Panel.setLayout(new GridLayout(1,2));
        player1Panel.add(input_p1); player1Panel.add(result_p1);
        JPanel player2Panel = new JPanel();
        player2Panel.setLayout(new GridLayout(1,2));
        player2Panel.add(input_p2); player2Panel.add(result_p2);

        buttonsPanel = new JPanel();
        cl = new CardLayout();
        buttonsPanel.setLayout(cl);
        buttonsPanel.add(buttons_p1, "p1");
        buttonsPanel.add(buttons_p2, "p2");

        add(player1Panel); add(buttonsPanel); add(player2Panel);
    }

    public void changeButtons(){cl.next(buttonsPanel);}
}