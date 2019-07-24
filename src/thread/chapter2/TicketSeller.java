package thread.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王通
 */
public class TicketSeller {

    private static List<String> tickets = new ArrayList<>();

    static{
        for(int i=0;i<1000;i++){
            tickets.add("票" + i);
        }
    }

    public static void main(String[] args) {
        TicketSeller ticketSeller = new TicketSeller();
        for(int i =0;i<10;i++){
            new Thread(()->{
                synchronized(tickets){
                    while (true){
                        if(tickets.size()<=0)
                            break;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了+"+tickets.remove(0));

                    }
                }
            }).start();
        }
    }
}
