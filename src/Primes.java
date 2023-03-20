import java.io.*;

public class Primes {

    final int n;
    final String url;

    public Primes(int n, String url) {
        this.n = n;
        this.url = url;
    }

    public void createBinary() throws IOException {
        FileOutputStream fos = new FileOutputStream(url);
        boolean[] isPrime = new boolean[n + 1];
        int count = 0, firstByteNumsIndex = 0, numBytes = 1;
        int[] firstByteNums = {2, 256, 65536, 16777216};

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

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
            if (i == n-1 || i == 255 || i == 65535 || i == 16777215) {
                fos.write(getBytes(count, 8));
                for (int j = firstByteNums[firstByteNumsIndex]; j <= i; j++) {
                    if (isPrime[j]) {
                        fos.write(getBytes(j, numBytes));
                    }
                }
                fos.write('\n');
                count = 0;
                numBytes++;
                ++firstByteNumsIndex;
            }
        }
        fos.close();
    }

    private static byte[] getBytes(int n, int numBytes) {
        byte[] bytes = new byte[numBytes];

        // generate a byte array from the last index
        for (int i = numBytes - 1; i >= 0; i--) {
            bytes[i] = (byte) (n & 0xff);
            n >>= 8;
        }

        return bytes;
    }

}