public class Interrupt {
    //un interrupt è un indicazione che un thread dovrebbe fermare quello che sta facendo e fare qualcos'altro
    public static void main(String args[]) { //eccezione lanciata dal thread corrente se interrotto mentre in sleep
        String importantInfo[] = {"Tony Boy",
                "Pino Mauro",
                "Enzo Dong",
                "Nicola Siciliano"};

        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {  //nella sleep si intercetta l'eccezione
                return;  //in caso si esce
            }
            System.out.println(importantInfo[i]); //altrimenti a fine sleep stampa

            //sta quindi al programmatore decidere cosa fare in caso di interruzione
        }
    }
}
