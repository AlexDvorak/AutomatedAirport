import java.util.Map;
import java.util.HashMap;

public class TaxiwayNode {
    public String id;
    public Map neighbors = new HashMap();
    TaxiwayNode(String selfid, String neigborid, int neighborcost){
        neighbors.put(neigborid,neighborcost);
        id = selfid;
    }
    public void addNeighbor(String id, int cost){
        neighbors.put(id,cost);
    }
}