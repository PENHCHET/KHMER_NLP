import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by PENHCHET on 11/21/2017.
 */
public class SplitKhmerCharacter {
    public static void main(String[] args) {
        String input = "សូមស្វាគមន៍មកកាន់នៅស្វែករកNLPរបស់ជនជាតិខ្មែរ"; // string matching
        new Split(input).start();
    }
}

class Split {
    private String[] dictionary = {"សូមស្វាគមន៍","សូម","ស្វាគមន៍","មក","Saturday","កាន់", "របស់", "ជនជាតិ", "ខ្មែរ", "នៅ"}; // dictionary
    private String input = null;
    private String oldInput = null;
    private List<String> results = new ArrayList<String>();

    public Split(String input) {
        this.input = input;
        this.oldInput = input;
    }
    public void start() {
        String temp = null;
        for(int i=0;i<this.input.length();i++) {
            temp = this.input.substring(i); // Every time the string first interception of a word, the coexistence of the temp
            //System.out.println("*****" + temp + "*********" + this.input);
            // If the word in the dictionary, you delete the word and in the original string intercepts the word
            if(this.isInDictionary(temp)) {
                //System.out.println(temp);
                results.add(temp);
                this.input = this.input.replace(temp, "");
                i = -1; // I=-1 is due to the re search, and the first execution loop in i++
                //System.out.println(this.input);
            }
        }

        // The current cycle is completed, the end of a word to a word, to continue the cycle, until the words become empty
        if(null != this.input && !"".equals(this.input)) {
            this.input = this.input.substring(0,this.input.length()-1);
            this.start();
        }else{
        	Collections.reverse(results);
        	//String found = String.join("", results);
        	System.out.println("ពាក្យដែលបានស្វែងរកឃើញនៅក្នុង Dictionary ==> ");
        	System.out.println(results);
        	for(String str: results){
        		//System.out.println(str);
        		this.oldInput = this.oldInput.replaceAll(str, str+ "​");
        	}
        	System.out.println("ពាក្យដែលមិនអាចស្វែងរកបាននៅក្នុង Dictionary ==> " + this.oldInput);    
        	String [] split = this.oldInput.split("​");
        	for(String str: split){
        		System.out.println(str);
        	}
        }
        
    }

    //To determine whether the word in the dictionary
    public boolean isInDictionary(String temp) {
        for(int i=0;i<this.dictionary.length;i++) {
            if(temp.equals(this.dictionary[i])) {
                return true;
            }
        }
        return false;
    }
    
}


