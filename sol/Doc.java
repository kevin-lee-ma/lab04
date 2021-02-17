package sol;
import java.io.*;

public class Doc {
    public static void toDocument(BufferedWriter bw) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            while (line != null && !line.equals("Ctrl-d")) {
                bw.write(line + " ");
                line = br.readLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            System.out.println("Encountered an error: " + e.getMessage());
        }

    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments");
            System.exit(0);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(args[0]))) {
            toDocument(bw);
        }
        catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
        catch (IOException e) {
            System.out.println("Encountered an error: " + e.getMessage());
        }

    }
}
