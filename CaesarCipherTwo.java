
/**
 * Write a description of class CaesarCipherTwo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTwo
{
   private String alphabet;
   private String shiftedAlphabet1;
   private String shiftedAlphabet2;
   private int mainKey1;
   private int mainKey2;
   
   public CaesarCipherTwo(int key1, int key2){
       alphabet = "abcdefghijklmnopqrstuvwxyz";
       shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
       shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2); 
       mainKey1 = key1;
       mainKey2 = key2;
   }
   
   public String encrypt(String input){
       
       StringBuilder encrypted = new StringBuilder("");
       for (int i = 0; i < input.length(); i++){
            
            String ch = Character.toString(input.charAt(i));
            if (i % 2 == 0){
                CaesarCipher cc1 = new CaesarCipher(mainKey1);
                encrypted.append(cc1.encrypt(ch));
            }
            else {
                CaesarCipher cc2 = new CaesarCipher(mainKey2);
                encrypted.append(cc2.encrypt(ch));
            }
            
        }
       return encrypted.toString();
   }
   
   public String decrypt(String input){
       
       StringBuilder decrypted = new StringBuilder("");
       for (int i = 0; i < input.length(); i++){
            
            String ch = Character.toString(input.charAt(i));
            if (i % 2 == 0){
                CaesarCipher cc1 = new CaesarCipher(26-mainKey1);
                decrypted.append(cc1.encrypt(ch));
            }
            else {
                CaesarCipher cc2 = new CaesarCipher(26-mainKey2);
                decrypted.append(cc2.encrypt(ch));
            }
            
        }
       return decrypted.toString();
   }
   
   
   
   
}
