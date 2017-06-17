
/**
 * Write a description of class TestCaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher
{
    private String alphabet;
    
    public int[] countLetters(String message){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for (int i = 0; i < message.length(); i++){
            
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alphabet.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        
        return counts;
    }
    
    public int maxIndex(int[] counts){
        
        int maxDex = 0;
        for(int i = 0; i < counts.length; i++){
            if(counts[maxDex] < counts[i]){
             maxDex = i;
            }
        }
        return maxDex;
    }
    
    public String breakCaesarCipher(String input){

        int maxDex = maxIndex(countLetters(input));
        int key = maxDex - 4;
        
        if (maxDex < 4) key = 26 - (4-maxDex);

        System.out.println("Key : " + key);
        
        CaesarCipher cc = new CaesarCipher(key);
        return cc.decrypt(input);
        
    }
    
    public void simpleTests(){
        
        FileResource fr = new FileResource("../data/smallHamlet.txt");
        StringBuilder str = new StringBuilder("");
        for (String line : fr.lines()) {
            str.append(line);
        }
        String file = str.toString();
        CaesarCipher cc = new CaesarCipher(18);
        System.out.println("Encrypting: " + cc.encrypt(file)); 
        System.out.println("Decrypting: " + cc.decrypt(cc.encrypt(file)));
        
        System.out.println("Encryting: " + cc.encrypt(file));
        System.out.println("breakCeaserCipher: " + breakCaesarCipher(cc.encrypt(file)));
     
    }
    
    public void exerciseTest(){
        CaesarCipher cc = new CaesarCipher(15);
        System.out.println("Encrypting: " + cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }
}
