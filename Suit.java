public enum Suit {
    HEART(" _ _ \n( V ) \n \\ / \n  V \n"),
    DIAM(" /\\ \n/  \\ \n\\  / \n \\/ \n"),
    CLUB("  _ \n ( ) \n(_'_) \n  | \n"),
    SPADE("  . \n /.\\ \n(_._)\n  |");
    
    private String suitImage;
    
    private Suit(String s) {
        suitImage = s;
    }
    
    public String getImage() {
        return suitImage;
    }
}
