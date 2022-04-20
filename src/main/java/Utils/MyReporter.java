package Utils;

public class MyReporter {
    public void reportPassEvent(String stepName){
        System.out.println("Passed : "+stepName);
    }
    public void reportFailEvent(String stepName){
        System.out.println("Failed : "+stepName);
    }
    public void reportWarningEvent(String stepName){
        System.out.println("Warning : "+stepName);
    }
    public void reportInfo(String info){
        System.out.println(info);
    }
}
