import java.util.Base64;

public class Main {

    public static void mineBlock(String data){
        String hash;
        int nonce = 0;
        long startTimestamp = System.currentTimeMillis();

        while(true){
            nonce++;

            String dataToHash = data + nonce;
            hash = Base64.getEncoder().encodeToString(dataToHash.getBytes());


            if(hash.endsWith("jExMTE5")){
                long timestamp = System.currentTimeMillis();
                System.out.println();
                System.out.println("<>");
                System.out.println("⛏ Block has been mined ⛏");
                System.out.println("Nonce: "+nonce);
                System.out.println("Timestamp: "+timestamp);
                System.out.println("Secs: "+(timestamp-startTimestamp)/1000);
                System.out.println("Hash: "+hash);
                return;
            }
            System.out.println(hash + "  | WRONG");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        mineBlock("pizza");
    }
}