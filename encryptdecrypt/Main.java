package encryptdecrypt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.io.*;


public class Main {
    public static void main(String[] args) throws  IOException {
        String message = "";
        HashMap command = new HashMap<>();



        //Add command in a hashmap
        for(int i = 0; i < args.length - 1; i++) {
            command.put(args[i],args[i+1]);
        }

        //extract command from hashmap
        int key = Integer.parseInt((command.getOrDefault("-key",0)).toString());
        String mode = (String) command.getOrDefault("-mode","enc");
        String data = (String)command.getOrDefault("-data","");
        String in = (String)command.getOrDefault("-in",null);
        String out = (String)command.getOrDefault("-out",null);
        String alg = (String)command.getOrDefault("-alg", "shift");

        if (data.equals("") && in !=null) {
            data = Files.readString(Path.of(in));
        }

        switch (mode) {
            case "enc":
                Encrypt encryptor = new Encrypt();
                if (alg.equals("unicode")){
                    encryptor.setAlgorithm(new UnicodeAlgorithm());
                }else {
                    encryptor.setAlgorithm(new ShiftAlgorithm());
                }
                message = encryptor.encrypt(data, key);
                break;
            case "dec":
                Decrypt decryptor = new Decrypt();
                if (alg.equals("unicode")){
                    decryptor.setAlgorithm(new UnicodeAlgorithm());
                }else {
                    decryptor.setAlgorithm(new ShiftAlgorithm());
                }
                message = decryptor.decrypt(data, key);
        }


        if (out != null) {
            PrintStream printStream = new PrintStream(out);
            printStream.print( message );
        } else System.out.println(message);

    }


}
