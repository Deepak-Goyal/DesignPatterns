package CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	private String name = "ABC";
	   private int quantity = 10;

	   public void buy(){
	      System.out.println("Stock [ Name: "+name+
	    		  ", Quantity: " + quantity +" ] bought");
	   }
	   public void sell(){
	      System.out.println("Stock [ Name: "+name+
	    		  ", Quantity: " + quantity +" ] sold");
	   }
}

interface Order {
	void execute();
}

class BuyStock implements Order {
	   private Stock abcStock;

	   public BuyStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.buy();
	   }
}

class SellStock implements Order {
	   private Stock abcStock;

	   public SellStock(Stock abcStock){
	      this.abcStock = abcStock;
	   }

	   public void execute() {
	      abcStock.sell();
	   }
}

class Broker {
	   private List<Order> orderList = new ArrayList<Order>(); 

	   public void takeOrder(Order order){
	      orderList.add(order);		
	   }

	   public void placeOrders(){
	   
	      for (Order order : orderList) {
	         order.execute();
	      }
	      orderList.clear();
	   }
}