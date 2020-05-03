import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder line = new StringBuilder();
            int byteNum;
            int count = 0;

            while ((byteNum = reader.read()) != -1) {
                line.append((char) byteNum);
            }

            for (String word : line.toString().split(" ")) {
                if (!word.isEmpty()) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}