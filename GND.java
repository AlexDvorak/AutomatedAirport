import java.util.HashMap;
import java.util.Map;

public class GND {
    private Map queue = new HashMap();
    private Map routes = new HashMap();
    public Map responses = new HashMap();
    private Map currentRoutes = new HashMap();
    private void respondTo(String tailNumber) {
        System.out.println(tailNumber);
        System.out.println(queue.get(tailNumber));
    }
    private int[] collides(TaxiwayNode[] routeone, TaxiwayNode[] routetwo){
        for(int i = 0;i<routeone.length;i++){
            for(int j = 0;j<routetwo.length;j++){
                if(routeone[i] == routetwo[j]){
                    int[] collision = new int[2];
                    collision[0] = i;
                    collision[1] = j;
                    return collision;
                }
            }
        }
        int[] collision = new int[1];
        return collision;
    }

    private int timecollides(int[] routeone,int[] routetwo, int routeoneposition, int routetwoposition){
        boolean collided = false;
        while(routeone.length > routeoneposition && routetwo.length > routetwoposition){
            if(routeone[routeoneposition] === routetwo[routetwoposition]){
                collided = true;
            } else {
                routeoneposition++;
                routetwoposition++;
            }
        }
    }

    public void receiveRequest(String jsonRequest) {
        String tailnumber = jsonRequest.substring(8, 14);
        queue.put(tailnumber, jsonRequest);
    }
    private void addRoute(String planeId, TaxiwayNode[] route){
        routes.put(planeId,route);
    }
    public static void main(String[] args) {
        // Testing functionality: comment out once fully functional
        GND SFOGND = new GND();
        SFOGND.receiveRequest("{plane:\"N09478\",type:\"pushback\"}");
        System.out.println(SFOGND.queue.toString());
        SFOGND.respondTo("N09478");
        int[] a = {91,9818,9415,96};
        int[] b = {15,9821,9415};
        SFOGND.timecollides();
        System.out.println("GND Test complete");
    }
}
