package numeronmode.player1;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class RulesPanel extends JPanel{
    private JLabel l1, l2, l3, l4, l5;
    private ArrayList<JLabel> ruleLabelList;

    public RulesPanel()throws Exception{
        ruleLabelList = new ArrayList<JLabel>();
        init();
    }

    private void init()throws Exception{
        setLayout(new GridLayout(5,1));
        setBackground(Color.lightGray);

        l1 = new JLabel("---ルール説明---");
        l2 = new JLabel("EAT = 数字と位置が合っている");
        l3 = new JLabel("BITE = 数字のみ合っている(位置は違う)");
	    l4 = new JLabel("8回以内に4桁の数字を当ててください");
        l5 = new JLabel("ただし同じ数字は含まれません");

        ruleLabelList.add(l1);
        ruleLabelList.add(l2);
        ruleLabelList.add(l3);
        ruleLabelList.add(l4);
        ruleLabelList.add(l5);

        for(JLabel l : ruleLabelList){
            l.setHorizontalAlignment(JLabel.CENTER);
            l.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
            add(l);
        }
    }
}