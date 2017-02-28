
public class Controller{

    Deck deck;
    Hand pHand, dHand;
    DealStage stage;
    int money, bet;

    public Controller() {
        System.out.println("Controller Created");
    }
    
    public void sendMsg(String msg){
        System.out.println("MSG :: " + msg);
        if(msg.equals("Bust")){
            stage.showButtons(false);
        }
        if(msg.equals("DealerBust")){
            stage.showButtons(false);
        }
        if(msg.equals("Compare")){
            stage.showButtons(false);
            if(pHand.count() > dHand.count()){
                System.out.println("Win");
            } else if (pHand.count() == dHand.count()) {
                System.out.println("Push");
            }else {
                System.out.println("Lose");
            }
        }
    }
    
    public void sendMsg(String msg, DealStage sender){
        System.out.println("MSG :: " + msg);
        if(msg.equals("Hit"))
        {
            pHand.addCard(deck.draw());
            stage.updatePHand(pHand.makeHand());
            if(pHand.count() >= 21)
                sendMsg("Bust");
            stage.show_Game();
        }
        
        if(msg.equals("Start"))
        {
            stage = sender;
            money = 250;
            bet = 25;
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
            bet += bet;
            pHand.addCard(deck.draw());
            stage.updatePHand(pHand.makeHand());
            stage.show_Game();
            if(pHand.count() <= 21)
                sendMsg("Stand", stage);
            else
                sendMsg("Bust");
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
            if(dHand.count() > 21)
                sendMsg("DealerBust");
            else
                sendMsg("Compare");
        }
        
    }
}
