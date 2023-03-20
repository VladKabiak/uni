import java.io.*;

public class BinaryPrimeReader {
    private int numBytes = 1;
    private final FileInputStream inputStream;
    private int numPrimes;



    public BinaryPrimeReader(String url) throws IOException{
        this.inputStream = new FileInputStream(url);
        this.numPrimes = getIntFromBytes(8);
    }

    public int readNextInt() throws IOException {
        int result = getIntFromBytes(numBytes);
        --numPrimes;
        // if prime numbers has ended getting data for the next number of bytes
        if (numPrimes == 0) {
            // Skip the newline character
            inputStream.read();
            // Get the number of prime numbers consisting of numBytes++
            numPrimes = getIntFromBytes(8);
            numBytes++;
        }
        return result;
    }

    private int getIntFromBytes(int numBytes) {
        byte[] bytes = new byte[numBytes];

        for (int i = 0; i < numBytes; i++) {
            try {
                bytes[i] = (byte) inputStream.read();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        int result = 0;

        for (byte aByte : bytes) {
            result <<= 8;
            result |= (aByte & 0xff);
        }

        return result;
    }
}
