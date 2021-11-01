import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    Server(int port) {
        this.startServer(port);
    }

    public void startServer(int port) {
        try {
            // start the server
            this.serverSocket = new ServerSocket(port);
            System.out.println("\n[SERVER INFO] - The server is up!");

            // wait for client connection
            this.clientSocket = this.serverSocket.accept();
            System.out.println("\n[SERVER INFO] - Connection from client accepted!");

            // set the streams
            this.socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.socketOut = new PrintWriter(this.clientSocket.getOutputStream(), true);

            this.keepCheckingPalindrome();

            // close the streams
            this.socketIn.close();
            this.socketOut.close();
        }

        catch (IOException e) {
            System.out.println("\n[SERVER FAIL] - IOException occurred!");
            e.printStackTrace();
        }
    }

    private void keepCheckingPalindrome() {
        while (true) {
            String line = null;

            try {
                line = this.socketIn.readLine();

                if (line == null || line.equals("QUIT")) {
                    this.socketOut.println("\n[SERVER INFO] Good Bye!");
                    break;
                }

                if (this.checkPalindrome(line)) {
                    this.socketOut.println(line + " is a palindrome.");
                }

                else {
                    this.socketOut.println(line + " is not a palindrome.");
                }
            }

            catch (IOException e) {
                this.socketOut.println("\n[SERVER FAIL] - IOException at keepCheckingPalindrome");
                e.printStackTrace();
                return;
            }
        }
    }

    private boolean checkPalindrome(String x) {
        int n = x.length();

        for (int i = 0, j = n - 1; i < n / 2; i++, j--) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Server(8099);
    }
}
