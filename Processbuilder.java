import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.lang.ProcessBuilder;
import java.lang.ProcessBuilder.Redirect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RegexMatches {
    public static void main( String args[] ) {
        String loadString = "10:56:55 up 1 min,  0 users,  load average: 0.32, 0.20, 0.08";
        List<String> uptimeList = new ArrayList<String>(splitString(loadString));
        Integer sizeOfUptimeList = uptimeList.size();
        List<Double> loadList = new ArrayList<Double>();
        loadList.add(Double.valueOf(uptimeList.get(sizeOfUptimeList-3)));
        loadList.add(Double.valueOf(uptimeList.get(sizeOfUptimeList-2)));
        loadList.add(Double.valueOf(uptimeList.get(sizeOfUptimeList-1)));
        
        for(Double item : loadList) {
            System.out.println("Match: " + item);
        }

        if (loadList.get(0) > 0.5) {
            //FAIL, send exit code not equal to zero
            System.exit(1);
        }

try{
        ProcessBuilder builder =
            new ProcessBuilder("ll");
        builder.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
        Process p = builder.start();

        long freeE1s = 1;
        try (BufferedReader buf =
                new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            System.out.println(buf.toString());
        }

        p.waitFor();
        System.out.println(freeE1s);
} catch (Exception e) {
    System.out.println("Error");
}
    }

    public static List<String> splitString (String toSplit) {
        Pattern s = Pattern.compile("\\s*(\\s|,)\\s*");
        List<String> splitString = new ArrayList<String>(Arrays.asList(s.split(toSplit)));
        for(String item : splitString) {
            System.out.println("Match: " + item);
        }
        return splitString;
     }
}