package Lesson10;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneDirectory implements IGuide {

    private HashMap<String, HashSet> subscriberHashMap = new HashMap<>();

    private HashSet<String> theHashSet;
    //private String setPhones[];

    @Override
    public boolean addRecord(String name, String numberPhone) {

        //Проверка на уникальность номера по всему справочнику
        for (HashSet theHS : subscriberHashMap.values()) {
            if (theHS.contains(numberPhone)) {
                return false;
            }
        }

        if (subscriberHashMap.containsKey(name)) {
            theHashSet = subscriberHashMap.get(name);
        } else {
            theHashSet = new HashSet<>();
        }

        theHashSet.add(numberPhone);

        subscriberHashMap.put(name, theHashSet);

        return true;
    }

    @Override
    public String[] getNumbers(String name) {

        String setPhones[] = new String[0];

        if (subscriberHashMap.containsKey(name)) {
            theHashSet = subscriberHashMap.get(name);

            return theHashSet.toArray(setPhones);
            //return setPhones;
        } else {
            return new String[0];
        }
    }
}
