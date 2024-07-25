public class square {
    boolean hasProperty; 
    boolean isChance;
    boolean hasGo; 
    boolean hasJail; 
    boolean hasGoToJail; 
    boolean empty;
    boolean isLast;  
    int value;
    player owner;
    String name;  
    String color; 
    square(){
        name = " "; 
        isLast = false; 
        empty = false; 
        hasProperty = false; 
        isChance = false; 
        hasGo = false; 
        hasGoToJail = false; 
        hasJail = false; 
        owner = null; 
        value = 0; 
    }
}
