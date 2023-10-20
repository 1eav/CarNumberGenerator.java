import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Loader {
    public static void loader(String location) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        PrintWriter writer = new PrintWriter(location);
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        for (int number = 1; number < 1000; number++) {
            StringBuilder builder = new StringBuilder();
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append("\n");
                    }
                    writer.write(builder.toString());
                }
            }
        }
        writer.flush();
        writer.close();
        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    //TIME: 1-34245 ms, 2-34289 ms; SIZE: 1-1,39 gb, 2-1,39 gb "Строковые данные"
    private static String padNumber(int number, int numberLength) {
        String s = "";
        int padSize = numberLength - s.length();

        for (int i = 0; i < padSize; i++) {
            s += "0";
        }
        return s;
    }
}