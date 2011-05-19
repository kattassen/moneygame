class moneyGame {
    public static void main(String[] args) {
        System.out.println("Money Game"); 

        parseArgs(args);
    }


    private static boolean parseArgs(String[] args) {
        for(int i = 0; i < args.length; i++)
        {
            System.out.println(args[i]);
        }

        return true;
    }
}
