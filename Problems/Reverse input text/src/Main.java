import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder line = new StringBuilder();
            int charNumber;

            while ((charNumber = reader.read()) != -1) {
                line.append((char) charNumber);
            }
            System.out.println(line.reverse());
        }
    }
}