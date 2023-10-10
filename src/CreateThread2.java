public class CreateThread2 implements Runnable{
    //metodo piu generale nel caso in cui la classe deve estendere un'altra classe
    //si implementa un interfaccia
    @Override
    public void run() { //metodo che viene eseguito quando viene lanciato il thread
        System.out.println("Kid cazzo di Yugi, nuovo volto del diavolo");
    }

    public static void main(String args[]){
        (new Thread(new CreateThread2())).start(); //l'oggetto istanziato è pasasato al costruttore di Thread e lanciato
    }
}
