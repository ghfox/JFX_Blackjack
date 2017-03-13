package blackjack;

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
            stage.setCon("Bust");
            stage.showButtons(false);
        }
        if(msg.equals("DealerBust")){
            money += (bet * 2);
            stage.setCon("Dealer Busts, Win");
            stage.showButtons(false);
        }
        if(msg.equals("Compare")){
            stage.showButtons(false);
            if(pHand.count() > dHand.count()){
                System.out.println("Win");
                stage.setCon("Win");
                money += (bet * 2);
            } else if (pHand.count() == dHand.count()) {
                System.out.println("Push");
                stage.setCon("Push");
                money += bet;
            }else {
                System.out.println("Lose");
                stage.setCon("Loss");
            }
        }
        if(msg.equals("Natural")){
            money += ((bet * 2) + (bet/2)) ;
            stage.setCon("Blackjack, Win");
            stage.showButtons(false);
        }
        
        dHand.setCover(false);
        stage.updateDHand(dHand.makeHand());
        stage.updateMoney(money);
        stage.updateChart(money);
        stage.show_Game();
    }
    
    public void sendMsg(String msg, DealStage sender){
        System.out.println("MSG :: " + msg);
        if(msg.equals("Hit"))
        {
            pHand.addCard(deck.draw());
            stage.updatePHand(pHand.makeHand());
            if(pHand.count() > 21)
                sendMsg("Bust");
            if(pHand.count() == 21)
                sendMsg("Stand",sender);
            stage.show_Game();
        }
        
        if(msg.equals("Deal")){
            bet = stage.getBet();
            money -= bet;
            System.out.println("Betting $" + bet + ", $" + money + " remaining");
            deck = new Deck();
            pHand = new Hand();
            dHand = new Hand();
            pHand.addCard(deck.draw());
            pHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.addCard(deck.draw());
            dHand.setCover(true);
            stage.showButtons(true);
            stage.updatePHand(pHand.makeHand());
            stage.updateDHand(dHand.makeHand());
            stage.updateMoney(money);
            stage.show_Game();
            
            if(dHand.count() == 21)
                sendMsg("Compare");
            if(pHand.count() == 21)
                sendMsg("Natural");
        }
        
        if(msg.equals("Start"))
        {
            stage = sender;
            money = 250;
            bet = 25;
            stage.showButtons(false);
            stage.show_Game();
        }
        
        if(msg.equals("DblD")){
            money -= bet;
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
