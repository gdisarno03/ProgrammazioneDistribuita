//a volte è necessario che un thread attenda il completamento di un altro thread, allora
//si utilizza il metodo join, se t è un oggetto il cui thread è in esecuzione allora
//mette il thread t corrente in pausa fino a quando thread t non termina

//Il metodo join interagisce con due thread (sia oggetti, sia thread di esecuzione):
//thread 1: il thread che lo chiama, cioè il flusso di esecuzione che invoca join
//thread 2: il thread sul quale è chiamato, cioè il thread corrispondente all'oggetto puntato da this
public class JoinThreads {
    static void threadMessage(String msg){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s:%s%n", threadName, msg);
    }

    private static class MessageLoop implements Runnable{

        @Override
        public void run() {
            String stringMess[] = {"Tony Boy",
                    "Pino Mauro",
                    "Enzo Dong",
                    "Nicola Siciliano"};

            try {
                for(int i = 0; i < stringMess.length; i++){
                    Thread.sleep(4000);

                    threadMessage(stringMess[i]);
                }
            }catch (InterruptedException e){
                threadMessage("I wasn't done");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException{   //lancia eccezione
        long patience = 1000 * 60 * 60;  //ritardo in millisecondi

        if(args.length > 0){
            try{
                patience = Long.parseLong(args[0]) * 1000;  //se c'è un argomento è in secondi
            }catch(NumberFormatException e){  //controllo formato
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }

        threadMessage("Starting Message loop");

        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());   //crea un oggetto Thread da MessageLoop
        t.start();

        threadMessage("Waiting  for MessageLoop to finish");

        while(t.isAlive()){   //Mentre MessageLoop è in vita
            threadMessage("Still waiting...");

            t.join(1000);  //aspetta un secondo al più
            if(((System.currentTimeMillis() - startTime) > patience) && t.isAlive()){  //se la pazienza è scaduta e il thread è ancora vivo
                threadMessage("Tired of waiting");

                t.interrupt();  //lo chiudiamo

                t.join();  //e attendiamo la fine
            }
        }
        threadMessage("Finally"); //e si esce
    }
}


