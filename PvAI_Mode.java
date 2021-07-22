package numeronmode.pvai;
import javax.swing.*;
import java.awt.*;
import numeronmode.pvai.*;
public class PvAI_Mode extends JFrame{
    private DisplayPanel_PvAI input_p, input_AI, result_p, result_AI;
    private ButtonPanel_PvAI buttons;
    private AIplayer ai;
    private int[] answer;

    public PvAI_Mode(int[] answer)throws Exception{
        this.answer = answer;
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
        input_p = new DisplayPanel_PvAI("Player1");
        result_p = new DisplayPanel_PvAI("EAT-BITE");
        input_AI = new DisplayPanel_PvAI("AI");
        result_AI = new DisplayPanel_PvAI("候補数:5040");
        ai = new AIplayer(answer, input_AI.getDisplayLabelList(), result_AI);
        buttons = new ButtonPanel_PvAI(input_p.getDisplayLabelList(), result_p.getDisplayLabelList(), this, ai);

        for(int i = 0; i < 8; i++){
            result_p.getDisplayLabelList().get(i).setHorizontalAlignment(JLabel.CENTER);
            result_AI.getDisplayLabelList().get(i).setHorizontalAlignment(JLabel.CENTER);
        }

        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1,2));
        playerPanel.add(input_p); playerPanel.add(result_p);
        JPanel enemyPanel = new JPanel();
        enemyPanel.setLayout(new GridLayout(1,2));
        enemyPanel.add(input_AI); enemyPanel.add(result_AI);

        add(playerPanel); add(buttons); add(enemyPanel);
    }
}