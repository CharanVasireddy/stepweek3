class Client {
    String name;
    int riskScore;
    double accountBalance;

    Client(String name, int riskScore, double accountBalance) {
        this.name = name;
        this.riskScore = riskScore;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return name + "(" + riskScore + ", " + accountBalance + ")";
    }
}

public class ClientRiskRanking {

    public static void bubbleSort(Client[] clients) {
        int n = clients.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clients[j].riskScore > clients[j + 1].riskScore) {
                    // Swap
                    Client temp = clients[j];
                    clients[j] = clients[j + 1];
                    clients[j + 1] = temp;
                    swapCount++;
                }
            }
        }

        System.out.println("Bubble Sort (Ascending):");
        printArray(clients);
        System.out.println("Total Swaps: " + swapCount);
    }

  
    public static void insertionSort(Client[] clients) {
        int n = clients.length;

        for (int i = 1; i < n; i++) {
            Client key = clients[i];
            int j = i - 1;

            while (j >= 0 && (
                    clients[j].riskScore < key.riskScore ||
                    (clients[j].riskScore == key.riskScore &&
                     clients[j].accountBalance < key.accountBalance))) {

                clients[j + 1] = clients[j];
                j--;
            }

            clients[j + 1] = key;
        }

        System.out.println("\nInsertion Sort (Descending):");
        printArray(clients);
    }

    public static void printTopClients(Client[] clients, int topN) {
        System.out.println("\nTop " + topN + " Highest Risk Clients:");
        for (int i = 0; i < Math.min(topN, clients.length); i++) {
            System.out.println(clients[i]);
        }
    }

    public static void printArray(Client[] clients) {
        for (Client c : clients) {
            System.out.print(c + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Client[] clients = {
            new Client("clientC", 80, 2000),
            new Client("clientA", 20, 5000),
            new Client("clientB", 50, 3000)
        };


        bubbleSort(clients);

        insertionSort(clients);

        printTopClients(clients, 3);
    }
}