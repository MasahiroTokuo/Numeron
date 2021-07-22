package numeronmode.pvp;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class RulesPanel_PvP extends JPanel{
    private JLabel l1, l2, l3, l4, l5;
    private ArrayList<JLabel> ruleLabelList;

    public RulesPanel_PvP()throws Exception{
        ruleLabelList = new ArrayList<JLabel>();
        init();
    }

    private void init()throws Exception{
        setLayout(new GridLayout(5,1));
        setBackground(Color.lightGray);

        l1 = new JLabel("---ルール説明---");
        l2 = new JLabel("EAT = 数字と位置が合っている");
        l3 = new JLabel("BITE = 数字のみ合っている(位置は違う)");
	    l4 = new JLabel("各桁に同じ数字は含まれません");
        l5 = new JLabel("先に4桁の数字を当てたほうが勝利です");

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