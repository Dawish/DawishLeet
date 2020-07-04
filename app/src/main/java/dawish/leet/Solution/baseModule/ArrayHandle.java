package dawish.leet.Solution.baseModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayHandle {

    /**
     * 字符串数组去重
     * @param strings
     * @return
     */
    public static Object[] unique(Object[] strings){
        List<Object> uniqueList = new ArrayList<Object>();

        for(Object s: strings){
            if(!uniqueList.contains(s)){
                uniqueList.add(s);
            }
        }
        return uniqueList.toArray();
    }

    /**
     * list 加 set去重
     * @param strings
     * @return
     */
    public static Object[] unique2(Object[] strings){
        List<Object> stringList = Arrays.asList(strings);
        Set<Object> stringSet = new HashSet<Object>();
        // set会自动去重
        stringSet.addAll(stringList);
        return stringSet.toArray();
    }

    /**
     * 两个数组去重合并成一个新的
     * @param strings1
     * @param strings2
     * @return
     */
    public static Object[] unique3(Object[] strings1, Object[] strings2){
        Set<Object> set = new HashSet<>();
        set.addAll(Arrays.asList(strings1));
        set.addAll(Arrays.asList(strings2));
        return set.toArray();
    }

}
