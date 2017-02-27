
public class Controller{

    Deck deck;
    Hand pHand;

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
        }
        
        if(msg.equals("Start"))
        {
            deck = new Deck();
            pHand = new Hand();
            pHand.addCard(deck.draw());
            pHand.addCard(deck.draw());
            sender.updatePHand(pHand.makeHand());
        }
    }
}
