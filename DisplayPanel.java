package numeronmode.player1;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class DisplayPanel extends JPanel{
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    private ArrayList<JLabel> displayLabelList = new ArrayList<>();

    public DisplayPanel()throws Exception{
        init();
    }

    private void init()throws Exception{
        setLayout(new GridLayout(8,1));

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
}