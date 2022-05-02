import java.util.*;
public class BreakingString {
    public static void main(String args []) {
        String str = "abc \"def geh\" vivek yadav \"umesh \"";
        String [] result = str.split(" ");
        //System.out.println(str);
        for(int i = 0; i < result.length; i++) {
           // System.out.print(result[i]+ ",");
        }
        List<String> ans = new ArrayList<>();

        boolean isFirstDoubleQuote = false;
        System.out.println("----------------");
        String temp = "";
        for(int i = 0; i < str.length(); i++) {
        
            if(str.charAt(i) == '"') {
                isFirstDoubleQuote = !isFirstDoubleQuote;
            }
                
            //System.out.print("char: "+str.charAt(i)+",");
            if(str.charAt(i) == ' ' && !isFirstDoubleQuote){
                ans.add(temp);
                temp = "";
            } else {
                temp += str.charAt(i);
            }
        }
        ans.add(temp);
        String [] strArray = new String[ans.size()];
        ans.toArray(strArray);
        System.out.println();
        System.out.print("[");
        for(String s : ans) {
            System.out.print(s+",");
        }
        System.out.print("]");
        for(String s: strArray) {
            System.out.print(s+" ");
        }
    }
}
