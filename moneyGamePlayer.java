/* Strategys: 0 - Even 
*             1 - Total Random
*             2 - Weighted Random x
*             3 - Weighted Random x/2
*
*/

import java.util.Random;

class moneyGamePlayer {
    private int m_coinsStart     = 0; 
    private int m_coinsLeft      = 0;
    private int m_coinsThisRound = 0;
    private int m_points         = 0;
    private int m_strategy       = 0;
    private int m_roundsLeft     = 0;

    private String m_name;

    private Random rand;

    public moneyGamePlayer(int coins, int strategy, int rounds, String name) {
        m_coinsStart = m_coinsLeft = coins;
        m_name = name;
        m_roundsLeft = rounds;
        m_strategy = strategy;

        rand = new Random();

        if (moneyGame.m_verbose)
            System.out.println(m_name + " added");
    }

    public moneyGamePlayer() {
    }

    public int putCoins() {
        m_coinsThisRound = selectAmount();
        m_coinsLeft = m_coinsLeft - m_coinsThisRound;
        m_roundsLeft--;
        if (moneyGame.m_verbose)
            System.out.println(m_name + " put " +  m_coinsThisRound);
        return m_coinsThisRound;
    }

    public int getCoinsThisRound() {
        return m_coinsThisRound;
    }

    public String getName() {
        return m_name;
    }

    public int getPoints() {
        return m_points;
    }

    public void addPoints(int points) {
        m_points = m_points + points;
        if (moneyGame.m_verbose)
            System.out.println(m_name + " got " +  points + " points this round. Total: " + m_points);
    }

    private int selectAmount() {
        int value;
        if (m_roundsLeft == 0)
            return m_coinsLeft; 
        switch (m_strategy) {
            case 0:
                // Even distribution over rounds
                return m_coinsLeft/m_roundsLeft;
            case 1:
                // Total randomness
                return rand.nextInt(m_coinsLeft);
            case 2:
                // "Even" randomness x
                if (1 == rand.nextInt(2))
                    return m_coinsLeft/m_roundsLeft + rand.nextInt(m_coinsLeft/m_roundsLeft);
                else
                    return m_coinsLeft/m_roundsLeft - rand.nextInt(m_coinsLeft/m_roundsLeft);
            default:
                // "Even" randomness x/2
                if (1 == rand.nextInt(2))
                    return m_coinsLeft/m_roundsLeft + (rand.nextInt(m_coinsLeft/m_roundsLeft)/2);
                else
                    return m_coinsLeft/m_roundsLeft - (rand.nextInt(m_coinsLeft/m_roundsLeft)/2);
                
        }
    }
}
