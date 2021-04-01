import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){

        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){

        return hamletData;
    }

    public int findHamlet() {
        Pattern pattern = Pattern.compile("[Hh][Aa][Mm][Ll][Ee][Tt]");
        Matcher matcher = pattern.matcher(this.getHamletData());

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public int findHoratio() {
        Pattern pattern = Pattern.compile("[Hh][Oo][Rr][Aa][Tt][Ii][Oo]");
        Matcher matcher = pattern.matcher(this.getHamletData());

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public String changeHamletToLeon(String input) {
        Pattern pattern = Pattern.compile("[Hh][Aa][Mm][Ll][Ee][Tt]");
        Matcher matcher = pattern.matcher(input);
        if (this.findHamlet() >= 1) {
             return matcher.replaceAll("Leon");
        }

        return this.getHamletData();
    }

    public String changeHoratrioToTariq(String input) {
        Pattern pattern = Pattern.compile("[Hh][Oo][Rr][Aa][Tt][Ii][Oo]");
        Matcher matcher = pattern.matcher(input);
        if (this.findHamlet() >= 1) {
            return matcher.replaceAll("Tariq");
        }

        return this.getHamletData();
    }
}
