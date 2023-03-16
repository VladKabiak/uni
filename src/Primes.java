import java.io.*;

public class Primes {

    public static void main(String[] args) throws IOException {

        int n = 4800;
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        FileOutputStream fos = new FileOutputStream("primes.bin");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                int bytesNeeded = bytesNeeded(i);
                dos.write(getBytes(i, bytesNeeded));
            }
        }

        dos.close();
        fos.close();
    }

    private static int bytesNeeded(int n) {
        if (n <= 255) {
            return 1;
        } else if (n <= 65535) {
            return 2;
        } else {
            return 3;
        }
    }

    private static byte[] getBytes(int n, int numBytes) {
        byte[] bytes = new byte[numBytes];

        for (int i = numBytes - 1; i >= 0; i--) {
            bytes[i] = (byte) (n & 0xff);
            n >>= 8;
        }

        return bytes;
    }

}