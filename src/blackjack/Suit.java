package blackjack;

public enum Suit {
    HEART(" _ _ \n( V ) \n \\ / \n  V \n", 'H'),
    DIAM(" /\\ \n/  \\ \n\\  / \n \\/ \n", 'D'),
    CLUB("  _ \n ( ) \n(_'_) \n  | \n", 'C'),
    SPADE("  . \n /.\\ \n(_._)\n  |", 'S');
    
    private String suitImage;
    private char suitChar;
    
    private Suit(String s, char c) {
        suitImage = s;
        suitChar = c;
    }
    
    public String getImage() {
        return suitImage;
    }
    
    public char getChar() {
        return suitChar;
    }
}
