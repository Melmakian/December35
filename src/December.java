import java.io.*;

public class December {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileOne = new FileInputStream(reader.readLine());
        FileOutputStream fileTwo = new FileOutputStream(reader.readLine());
        FileOutputStream fileThree = new FileOutputStream(reader.readLine());

        while (fileOne.available() > 0) {
            if (fileOne.available() % 2 == 0) {
                byte[] nach = new byte[fileOne.available() / 2];
                byte[] kon = new byte[fileOne.available() / 2];
                int countOne = fileOne.read(nach);
                int countTwo = fileOne.read(kon);
                fileTwo.write(nach, 0, countOne);
                fileThree.write(nach, 0, countTwo);
            } else {
                byte[] nach = new byte[fileOne.available() / 2 + 1];
                byte[] kon = new byte[fileOne.available() / 2];
                int countOne = fileOne.read(nach);
                int countTwo = fileOne.read(kon);
                fileTwo.write(nach, 0, countOne);
                fileThree.write(kon, 0, countTwo);
            }
        }
        fileOne.close();
        fileTwo.close();
        fileThree.close();
        reader.close();
    }
}
