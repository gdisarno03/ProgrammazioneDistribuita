public class CreateThread1 extends Thread{
    //passi principali per scrivere un thread :
    //1. estendere la classe java.lang.Thread
    //2. riscrivere (ridefinire, override) il metodo run () nella sottoclasse di Thread
    //3. creare un ' istanza di questa classe derivata
    //4.richiamare il metodo start() su questa istanza

    public void run(){ // metodo che viene eseguito quando si lancia il thread
        System.out.println("Ciccio il trafano");
    }

    public static void main(String[] args) {
        (new CreateThread1()).start();  //si istanzia e si lancia con start
        //(new Thread(new CreateThread())).start(); --> alternativa per lanciare il thread
    }
}