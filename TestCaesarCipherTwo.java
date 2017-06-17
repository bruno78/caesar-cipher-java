
/**
 * Write a description of class TestCaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo
{
    private String alphabet;
    private int[] countLetters(String message){
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
    
    private int maxIndex(int[] counts){
        
        int maxDex = 0;
        for(int i = 0; i < counts.length; i++){
            if(counts[maxDex] < counts[i]){
             maxDex = i;
            }
        }
        return maxDex;
    }
    
     private String halfOfString(String message, int start){
        StringBuilder newString = new StringBuilder("");
        
        
        for (int i = start; i < message.length(); i+= 2){
            newString.append(message.charAt(i));
        }
        return newString.toString();
    }
    
    public String breakCaesarCipher(String input){
        
        String halfString1 = halfOfString(input, 0);
        String halfString2 = halfOfString(input, 1);
        
        int maxDex1 = maxIndex(countLetters(halfString1));
        int maxDex2 = maxIndex(countLetters(halfString2));
        int key1 = maxDex1 - 4;
        int key2 = maxDex2 - 4;
        
        if (maxDex1 < 4) key1 = 26 - (4-maxDex1);
        if (maxDex2 < 4) key2 = 26 - (4-maxDex2);
        
        System.out.println("Key 1: " + key1);
        System.out.println("Key 2: " + key2);
        
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        return cc.decrypt(input);
        
    }
    
    public void simpleTests(){
        
        FileResource fr = new FileResource("../data/smallHamlet.txt");
        StringBuilder str = new StringBuilder("");
        for (String line : fr.lines()) {
            str.append(line);
        }
        String file = str.toString();
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        System.out.println("Encrypting: " + cc.encrypt(file)); 
        System.out.println("Decrypting: " + cc.decrypt(cc.encrypt(file)));
        
        System.out.println("Encryting: " + cc.encrypt(file));
        System.out.println("breakCeaserCipher: " + breakCaesarCipher(cc.encrypt(file)));
        
    
    }
    
    public void exerciseTest(){
        CaesarCipherTwo cc = new CaesarCipherTwo(21, 8);
        System.out.println("Encrypting: " + cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
        
        cc = new CaesarCipherTwo(14,24);
        System.out.println("Decrypting: " + cc.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        System.out.println("Breaking: " + breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));
        
        FileResource fr = new FileResource("../data/mysteryTwoKeysQuiz.txt");
        StringBuilder str = new StringBuilder("");
        for (String line : fr.lines()) {
            str.append(line);
        }
        String file = str.toString();
        System.out.println("Encrypting: " + breakCaesarCipher(file)); 
        
        CaesarCipherTwo pp = new CaesarCipherTwo(14,24);
        System.out.println("Decrypting: " + pp);
    }
}
