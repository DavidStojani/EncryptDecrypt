package encryptdecrypt;

public class Encrypt {

    private EncryptMethod algorithm;

    public void setAlgorithm(EncryptMethod algorithm) {
        this.algorithm = algorithm;
    }

    public String encrypt (String text, int key){
        return this.algorithm.encrypt(text,key);
    }
}
