
import java.util.ArrayList;

class moneyGame {
    
    public static boolean m_verbose = true;

    private static int m_noOfPlayers;
    private static int m_noOfRounds;

    public static void main(String[] args) {
        System.out.println("$$$$ Money Game $$$$"); 

        parseArgs(args);

        ArrayList playerList = new ArrayList();

        for (int i = 0; i < m_noOfPlayers; i++) {
            moneyGamePlayer player = new moneyGamePlayer(50, "Player" + (i + 1));
            playerList.add(player);
        }
            System.out.println("Size of list is " + playerList.size());

        for (int i = 0; i < m_noOfRounds; i++) {
            int leadingCoins = -1;
            int leadingPlayerIndex;
            int coins;

            for(int j = 0; j < m_noOfPlayers; j++) {
                moneyGamePlayer player = (moneyGamePlayer)playerList.get(j);

                coins = player.putCoins();
/*                if (coins > leadingCoins) {
                    leadingCoins = coins;
                    leadingPlayerIndex
                }*/
            }

        }

//        for(int i = 1; i < m_noOfPlayers; i++) {
//            player.getCoinsRound();
//        }
    }


    private static boolean parseArgs(String[] args) {
        for(int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
        }

            m_noOfPlayers = Integer.parseInt(args[0]);
            m_noOfRounds  = Integer.parseInt(args[1]);
        return true;
    }
}
