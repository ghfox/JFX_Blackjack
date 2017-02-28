
public class Controller{

    Deck deck;
    Hand pHand, dHand;
    DealStage stage;
    int money;

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
            stage.updatePHand(pHand.makeHand());
            if(pHand.count() >= 21)
                stage.showButtons(false);
            stage.show_Game();
        }
        
        if(msg.equals("Start"))
        {
            stage = sender;
            money = 250;
            deck = new Deck();
            pHand = new Hand();
            dHand = new Hand();
            pHand.addCard(deck.draw());
            pHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.setCover(true);
            stage.updatePHand(pHand.makeHand());
            stage.updateDHand(dHand.makeHand());
            stage.show_Game();
        }
        
        if(msg.equals("DblD")){
            
            
        }
        
        if(msg.equals("Stand"))
        {
            stage.showButtons(false);
            dHand.setCover(false);
            stage.updateDHand(dHand.makeHand());
        
            while(dHand.count() < 17)
            {
                dHand.addCard(deck.draw());
                stage.updateDHand(dHand.makeHand());    
            }
            stage.show_Game();
        }
        
    }
}
