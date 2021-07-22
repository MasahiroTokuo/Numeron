package numeronmode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import numeronmode.player1.Player1_Mode;
import numeronmode.pvai.SetNumberDialog_PvAI;
import numeronmode.pvp.SetNumberDialog_PvP;
public class SelectModeDialog extends JDialog implements ActionListener{
    JFrame f;
    JDialog d;
    JButton b1, b2, b3;
    public SelectModeDialog()throws Exception{
        setTitle("SelectGameMode");
        setVisible(true);
        Insets insets = getInsets();
        setVisible(false);
        setSize(300 + insets.right + insets.left, 300 + insets.top + insets.bottom);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        b1 = new JButton("1 Player");
        b1.setBounds(50, 10, 200, 80);
        b1.addActionListener(this);
        b1.setActionCommand("P1");

        b2 = new JButton("2 Player(Player vs AI)");
        b2.setBounds(50, 110, 200, 80);
        b2.addActionListener(this);
        b2.setActionCommand("P2");

        b3 = new JButton("2 Player(Player vs Player)");
        b3.setBounds(50, 210, 200, 80);
        b3.addActionListener(this);
        b3.setActionCommand("P3");

        add(b1); add(b2); add(b3);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        String cmd = evt.getActionCommand();
        try{
            if(cmd.equals("P1")){
                f = new Player1_Mode();
            }else if(cmd.equals("P2")){
                d = new SetNumberDialog_PvAI("player1");
            }else if(cmd.equals("P3")){
                d = new SetNumberDialog_PvP("player1");
            }
            dispose();
        }catch(Exception e){
            System.out.println("想定外のエラーです");
            e.getMessage();
            e.printStackTrace();
        }
    }
}