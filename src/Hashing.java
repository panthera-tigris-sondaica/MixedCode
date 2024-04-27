import java.util.HashMap;

public class Hashing {
    public static void main(String[] args){
        HashMapCustom<String,Integer> m=new  HashMapCustom<>(5);
        assertTrue(m.size()==0);
        assertTrue(m.put("a",1)==null);
        assertTrue(m.put("a",2)==1);
        assertTrue(m.size()==1);
        assertTrue(m.get("a")==2);
        assertTrue(m.get("b")==null);
        assertTrue(m.put("b",3)==null);
        assertTrue(m.size()==2);
        assertTrue(m.remove("a")==2);
        assertTrue(m.size()==1);
        System.out.println("Test Successful");
    }

    private static void assertTrue(boolean b) {
        if(!b){
            throw new AssertionError("Assertion Failed");
        }
    }
}
