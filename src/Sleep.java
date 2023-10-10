//stampa 4 stringhe con un ritardo
public class Sleep {
    public static void main(String args[]) throws InterruptedException { //eccezione lanciata dal thread corrente se interrotto mentre in sleep
        String importantInfo[] = {"Tony Boy",
        "Pino Mauro",
        "Enzo Dong",
        "Nicola Siciliano"};

        for(int i = 0; i < importantInfo.length; i++){
            Thread.sleep(4000);  //sospendo il thread per 4 secondi
            System.out.println(importantInfo[i]);
        }
    }
}
