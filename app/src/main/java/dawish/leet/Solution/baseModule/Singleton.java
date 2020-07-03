package dawish.leet.Solution.baseModule;

public class Singleton {

    // volatile防止cpu指令重排序
    private volatile Singleton mInstance;

    private Singleton(){

    }

    public Singleton getInstance(){
        // 为了效率判空
        if(null == mInstance){
            synchronized(Singleton.class){
                // 为了安全判空
                if(null == mInstance){
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }


}
