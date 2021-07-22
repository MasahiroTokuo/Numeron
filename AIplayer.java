package numeronmode.pvai;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class AIplayer {
    private int[] answer, attackNumber, eatBite;
    private ArrayList<int[]> candidate;
    private ArrayList<JLabel> inputLabelList, resultLabelList;
    private JLabel playerName;

    public AIplayer (int[] answer, ArrayList<JLabel> input, DisplayPanel_PvAI result)throws Exception{
        this.answer = answer;
        attackNumber = new int[4];
        candidate = new ArrayList<int[]>();
        eatBite = new int[2];
        this.inputLabelList = input;
        this.resultLabelList = result.getDisplayLabelList();
        this.playerName = result.getPlayerName();

        //  0~9999の数字のうち、各桁に被りがない5040個をcandidateにセット
        for(int i = 0; i < 10000; i++){
            String str = String.format("%04d", i);
            String[] strArray = str.split("");
            int[] intArray = new int[4];
            for(int j = 0; j < intArray.length; j++){
                intArray[j] = Integer.parseInt(strArray[j]);
            }
            boolean overlap = false;
            for(int j = 0; j < intArray.length; j++){
                for(int k = j+1; k < intArray.length; k++){
                    if(intArray[j] == intArray[k]){
                        overlap = true;
                        break;
                    }
                }
                if(overlap == true){break;}
            }
            if(overlap == false){
                candidate.add(intArray);
            }
        }
    }

    public int attack(int count)throws Exception{
        int random = new Random().nextInt(candidate.size());
        attackNumber = candidate.get(random);
        for(int i : attackNumber){
            inputLabelList.get(count).setText(inputLabelList.get(count).getText() + Integer.toString(i));
        }
        inputLabelList.get(count).setText(inputLabelList.get(count).getText() + " →");
        eatBite = discrimination(answer, attackNumber);
        resultLabelList.get(count).setText(eatBite[0] + "-" + eatBite[1]);
        remove();  //remove inappropriate numbers from candidates
        playerName.setText("候補数:" + candidate.size());
        return eatBite[0];
    }

    private int[] discrimination(int[] ans, int[] numbers) throws Exception {
        //  count EAT & BITE
	    int eat = 0;
	    int bite = 0;
	    for(int i = 0; i < 4; i++){
	        for(int j = 0; j < 4; j++){
	            if(numbers[i] == ans[j]){
	                bite++;
	            }
	        }
	    }
	    for(int i = 0; i < 4; i++){
	        if(numbers[i] == ans[i]){
	            eat++;
	        }
	    }
        int[] eatBite = {eat, (bite - eat)};
	    return eatBite;
	}

    private void remove()throws Exception{
        Iterator<int[]> it = candidate.iterator();
        while(it.hasNext()){
            int[] array = it.next();
            //  コールした数字に対するEAT,BITE数が一致しない候補を取り除く
            int[] check = discrimination(array, attackNumber);
            if(check[0] != eatBite[0] || check[1] != eatBite[1]){it.remove();}
        }
    }

    public ArrayList<int[]> getCandidate(){return this.candidate;}
}