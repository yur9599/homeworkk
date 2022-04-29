package designPatterns.singleton;

public class SingletonDP {
    private volatile SingletonDP instance;
    private SingletonDP(){}
    public SingletonDP getInstance(){
        if (instance==null){
            synchronized (SingletonDP.class){
                if (instance==null){
                    instance=new SingletonDP();
                }
            }
        }
        return instance;
    }

}
