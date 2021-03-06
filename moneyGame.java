
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class moneyGame {
    
    public static boolean m_verbose = false;

    private static int m_noOfPlayers;
    private static int m_noOfRounds;
    private static int m_noOfCoins;

    public static void main(String[] args) {
        moneyGamePlayer player;
        if (m_verbose)
            System.out.println("$$$$ Money Game $$$$"); 

        parseArgs(args);

        ArrayList playerList = new ArrayList();

        for (int i = 0; i < m_noOfPlayers; i++) {
            player = new moneyGamePlayer(m_noOfCoins, i , m_noOfRounds ,"Player" + (i + 1));
            playerList.add(player);
        }

        for (int i = 0; i < m_noOfRounds; i++) {
            int old_coins = 0;
            int last_point = m_noOfPlayers + 1;
            int leadingCoins = -1;
            int leadingPlayerIndex;
            int coins;

            if (m_verbose) 
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

            for (int j = 0 ; j < m_noOfPlayers ; j++) {
                player = (moneyGamePlayer)playerList.get(j);
                if (j == 0)
                {
                    player.addPoints(m_noOfPlayers + 1);
                    last_point = m_noOfPlayers + 1;
                }
                else
                {
                    if (old_coins != player.getCoinsThisRound())
                    {
                        player.addPoints(m_noOfPlayers - j);
                        last_point = m_noOfPlayers - j;
                    }
                    else
                    {
                        player.addPoints(last_point);
                    }
                }
                old_coins = player.getCoinsThisRound();
            }

            if (m_verbose) {
                player = (moneyGamePlayer)playerList.get(0);
                System.out.println("Roundwinner is: " + player.getName());
            }
        }

        Collections.sort(playerList, new Comparator(){
            // Sort the list in descending order by how many coins put 
            public int compare(Object o1, Object o2) {
               moneyGamePlayer p1 = (moneyGamePlayer) o1;
               moneyGamePlayer p2 = (moneyGamePlayer) o2;
               return p2.getPoints() - p1.getPoints();
            }
        });

        player = (moneyGamePlayer)playerList.get(0);
        System.out.println("----------------------------------\nWinner is: " + player.getName());
    }

    private static boolean parseArgs(String[] args) {
        for(int i = 0; i < args.length; i++)
        {
            if (m_verbose)
                System.out.println(args[i]);
        }

            m_noOfPlayers = Integer.parseInt(args[0]);
            m_noOfRounds  = Integer.parseInt(args[1]);
            m_noOfCoins   = Integer.parseInt(args[2]);
        return true;
    }
}
