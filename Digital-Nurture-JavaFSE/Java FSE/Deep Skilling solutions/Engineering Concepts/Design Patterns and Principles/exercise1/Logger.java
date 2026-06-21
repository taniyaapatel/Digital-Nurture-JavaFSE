package exercise1;
public class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if(instance==null) instance = new Logger();
        return instance;
    }
    public void log(String m) { System.out.println(m); }
    public static void main(String[] args) {
        Logger.getInstance().log("singleton works");
    }
}
