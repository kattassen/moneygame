
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class moneyGame {
    
    public static boolean m_verbose = true;

    private static int m_noOfPlayers;
    private static int m_noOfRounds;
    private static int m_noOfCoins;

    public static void main(String[] args) {
        moneyGamePlayer player;
        System.out.println("$$$$ Money Game $$$$"); 

        parseArgs(args);

        ArrayList playerList = new ArrayList();

        for (int i = 0; i < m_noOfPlayers; i++) {
            player = new moneyGamePlayer(m_noOfCoins, i , m_noOfRounds ,"Player" + (i + 1));
            playerList.add(player);
        }

        for (int i = 0; i < m_noOfRounds; i++) {
            int leadingCoins = -1;
            int leadingPlayerIndex;
            int coins;

            System.out.println("----------------------------------\n Round " + (i+1));

            for(int j = 0; j < m_noOfPlayers; j++) {
                player = (moneyGamePlayer)playerList.get(j);

                coins = player.putCoins();
            }

            Collections.sort(playerList, new Comparator(){
                // Sort the list in descending order by how many coins put 
                public int compare(Object o1, Object o2) {
                   moneyGamePlayer p1 = (moneyGamePlayer) o1;
                   moneyGamePlayer p2 = (moneyGamePlayer) o2;
                   return p2.getCoinsThisRound() - p1.getCoinsThisRound();
                }
 
            });

            for (int j = 0; j < m_noOfPlayers; j++) {
                player = (moneyGamePlayer)playerList.get(j);
                player.addPoints(m_noOfPlayers - j);
            }
        }

        Collections.sort(playerList, new Comparator(){
            // Sort the list in descending order by how many coins put 
            public int compare(Object o1, Object o2) {
               moneyGamePlayer p1 = (moneyGamePlayer) o1;
               moneyGamePlayer p2 = (moneyGamePlayer) o2;
               return p2.getCoinsThisRound() - p1.getCoinsThisRound();
            }
        }

        player = (moneyGamePlayer)playerList.get(0);
        System.out.println("----------------------------------\nWinner is: " + player.getName());
    }

    private static boolean parseArgs(String[] args) {
        for(int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
        }

            m_noOfPlayers = Integer.parseInt(args[0]);
            m_noOfRounds  = Integer.parseInt(args[1]);
            m_noOfCoins   = Integer.parseInt(args[2]);
        return true;
    }
}
