package encryptdecrypt;

public class UnicodeAlgorithm implements EncryptMethod,DecryptMethod{
    @Override
    public String encrypt(String text, int key) {
        StringBuilder newMessage = new StringBuilder();

        for(int i =0; i < text.length();i++){
            char ch = text.charAt(i);

            ch = (char)((int)ch + key);
            newMessage.append(ch);

        }

        return newMessage.toString();
    }

    @Override
    public String decrypt(String text, int key) {
        StringBuilder newMessage = new StringBuilder();

        for(int i =0; i < text.length();i++){
            char ch = text.charAt(i);

            ch = (char)((int)ch - key);
            newMessage.append(ch);

        }

        return newMessage.toString();
    }
}
