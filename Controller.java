
public class Controller{

    Deck deck;
    Hand pHand, dHand;

    public Controller() {
        System.out.println("Controller Created");
    }
    
    public void sendMsg(String msg){
        System.out.println("MSG :: " + msg);
    }
    
    public void sendMsg(String msg, DealStage sender){
        System.out.println("MSG :: " + msg);
        if(msg.equals("Hit"))
        {
            pHand.addCard(deck.draw());
            sender.updatePHand(pHand.makeHand());
            sender.show_Game();
        }
        
        if(msg.equals("Start"))
        {
            deck = new Deck();
            pHand = new Hand();
            dHand = new Hand();
            pHand.addCard(deck.draw());
            pHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.setCover(true);
            sender.updatePHand(pHand.makeHand());
            sender.updateDHand(dHand.makeHand());
            sender.show_Game();
        }
    }
}
