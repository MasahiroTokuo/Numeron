package numeronmode.pvai;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SetNumberDialog_PvAI extends JDialog{
    private JLabel message, number;
    private ArrayList<JButton> numberButtonList;
    private JButton reset, ok;

    public SetNumberDialog_PvAI(String name) throws Exception{
        setTitle(name);
        setVisible(true);
        Insets insets = getInsets();
        setVisible(false);
        setSize(400 + insets.right + insets.left, 500 + insets.top + insets.bottom);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        message = new JLabel("4桁の数字を設定してください");
        message.setBounds(100,20,200,20);
        message.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 14));
        message.setHorizontalAlignment(JLabel.CENTER);
        add(message);

        number = new JLabel("");
        number.setBounds(100,40,200,60);
        number.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 60));
        number.setHorizontalAlignment(JLabel.CENTER);
        add(number);

        ok = new JButton("OK!!");
        ok.setBounds(80,420,240,80);
        ok.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 40));
        ok.setHorizontalAlignment(JLabel.CENTER);
        ok.setEnabled(false);
        ok.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    dispose();
                    char[] charArray = number.getText().toCharArray();
                    int[] answer = new int[4];
                    for(int i = 0; i < answer.length; i++){
                        answer[i] = Character.getNumericValue(charArray[i]);
                    }
                    try{
                        PvAI_Mode game = new PvAI_Mode(answer);
                    }catch(Exception e){
                        System.out.println("想定外のエラーです");
                        e.getMessage();
                        e.printStackTrace();
                    }
                }
            }
        );
        add(ok);

        numberButtonList = new ArrayList<JButton>();
        for(int i = 0; i < 10; i++){  //数字ボタンの生成
            numberButtonList.add(new JButton(Integer.toString(i)));
            JButton b = numberButtonList.get(i);
            b.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 60));
        
            b.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evt){  //数字ボタンクリック時のアクション
                        JButton bn = (JButton)evt.getSource();
                        number.setText(number.getText() + bn.getText());
                        if(number.getText().length() == 4){
                            for(JButton b : numberButtonList){
                                b.setEnabled(false);
                            }
                            ok.setEnabled(true);
                        }else{
                            bn.setEnabled(false);
                        }
                    }
                }
            );
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                JButton b = numberButtonList.get( (i*3)+(j+1) );
                b.setBounds(80+(80*j), 100+(80*i), 80, 80);
                add(b);
            }
        }
        numberButtonList.get(0).setBounds(80,340,80,80);
        add(numberButtonList.get(0));

        reset = new JButton("RESET");
        reset.setBounds(160,340,160,80);
        reset.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 40));
        reset.setHorizontalAlignment(JLabel.CENTER);
        reset.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent evt){
                    number.setText("");
                    for(JButton b : numberButtonList){
                        b.setEnabled(true);
                    }
                    ok.setEnabled(false);
                }
            }
        );
        add(reset);

        setVisible(true);
    }
}