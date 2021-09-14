package encryptdecrypt;

public class Decrypt {

    private DecryptMethod algorithm;

    public void setAlgorithm(DecryptMethod algorithm) {
        this.algorithm = algorithm;
    }

    public String decrypt (String text, int key){
        return algorithm.decrypt(text, key);
    }
}
