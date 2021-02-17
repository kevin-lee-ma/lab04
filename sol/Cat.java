package sol;
import java.io.*;

public class Cat {
    public static void cat(BufferedReader br, BufferedWriter bw) {
        try {
            String line = br.readLine();
            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            br.close();
            bw.flush();
            bw.close();
        }
        catch (IOException e) {
            System.out.println("Encountered an error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Incorrect number of arguments");
            System.exit(0);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]));
             BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]))) {
            cat(br, bw);
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        catch (IOException e) {
            System.out.println("Encountered an error: " + e.getMessage());
        }
    }
}
