package numeronmode.pvai;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DisplayPanel_PvAI extends JPanel{
    private JLabel playerName;
    private ArrayList<JLabel> displayLabelList = new ArrayList<>();

    public DisplayPanel_PvAI(String name)throws Exception{
        playerName = new JLabel(name);
        init();
    }

    private void init()throws Exception{
        setLayout(new GridLayout(9,1));

        playerName.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 25));
        playerName.setHorizontalAlignment(JLabel.CENTER);
        playerName.setBackground(new Color(255,170,0));
        playerName.setOpaque(true);
        add(playerName);

        for(int i = 0; i < 8; i++){  //ラベルの生成
            displayLabelList.add(new JLabel(""));
            JLabel l = displayLabelList.get(i);
            add(l);
            l.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 35));
            if( i % 2 == 0){
                l.setBackground(new Color(255,255,200));
            }else{
                l.setBackground(new Color(255,255,170));
            }
            l.setForeground(new Color(33,33,33));
            l.setOpaque(true);
        }
    }

    public ArrayList<JLabel> getDisplayLabelList(){return displayLabelList;}
    public JLabel getPlayerName(){return playerName;}
}