import java.util.ArrayList;
import java.util.Arrays;

public class Reverse {
    private String strings;

    public  Reverse(String strings){
        this.strings=strings;
    }
    public void ReverseOutput(){
        //ArrayList<String> s=new ArrayList<>();
        String[] s=strings.split("");
        System.out.println(Arrays.toString(s));
        StringBuilder stringBuilder=new StringBuilder();

        for (int i =(strings.length()-1); i>=0; i--){
            stringBuilder.append(s[i]);
        }
        System.out.println(stringBuilder);
    }

}
