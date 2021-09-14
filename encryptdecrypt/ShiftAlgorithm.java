package encryptdecrypt;

public class ShiftAlgorithm implements EncryptMethod,DecryptMethod {

    @Override

    public String encrypt (String text, int key){
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int key) {
        return encrypt(text,26 -(key % 26));
    }

}
