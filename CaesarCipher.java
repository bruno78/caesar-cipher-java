
/**
 * Write a description of class CaesarCipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipher
{
    private String alphabet; 
    private String shiftedAlphabet;
    private int mainKey;
    
    public CaesarCipher(int key){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        
        StringBuilder encrypted = new StringBuilder("");
        
        for (int i = 0; i < input.length(); i++){
            
            char currChar = input.charAt(i);
            int refIndex = alphabet.indexOf(Character.toLowerCase(currChar));
            
            if (refIndex == -1) {
                encrypted.append(currChar);
            }
            else  {              
                char newChar = shiftedAlphabet.charAt(refIndex);
                
                if (Character.isLowerCase(currChar)){
                    encrypted.append(Character.toLowerCase(newChar));
                }
                else {
                    encrypted.append(newChar);
                }
            }
        }
        
        return encrypted.toString();      
    }
    
    public String decrypt(String input){
        
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
        
    }
}
