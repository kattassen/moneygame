
class moneyGamePlayer {
    private int m_coinsStart, m_coinsLeft, m_coinsThisRound;
    private String m_name;

    public moneyGamePlayer(int coins, String name) {
        m_coinsStart = m_coinsLeft = coins;
        m_name = name;

        if (moneyGame.m_verbose)
            System.out.println(m_name + " added");
    }

    public moneyGamePlayer() {
    }

    public int putCoins() {
        m_coinsThisRound = 4;
        m_coinsLeft = m_coinsLeft - m_coinsThisRound;
        if (moneyGame.m_verbose)
            System.out.println(m_name + " put " +  m_coinsThisRound);
        return m_coinsThisRound;
    }

    public int getCoinsRound() {
        return m_coinsThisRound;
    }
}
