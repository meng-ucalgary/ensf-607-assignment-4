import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private BufferedReader stdin;
    private BufferedReader socketIn;
    private PrintWriter socketOut;

    public Client(String serverName, int portNumber) {
        try {
            this.stdin = new BufferedReader(new InputStreamReader(System.in));
            this.clientSocket = new Socket(serverName, portNumber);
            this.socketIn = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            this.socketOut = new PrintWriter((this.clientSocket.getOutputStream()), true);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void communicate() {
        while (true) {
            String line = null;

            try {
                System.out.printf("\nPlease select an option (DATE/TIME): ");
                line = this.stdin.readLine();

                if (line.equals("QUIT")) {
                    break;
                }

                else {
                    this.socketOut.println(line);
                    System.out.printf("%s", this.socketIn.readLine());
                }
            }

            catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            this.stdin.close();
            this.socketIn.close();
            this.socketOut.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 9090);
        client.communicate();
    }
}
