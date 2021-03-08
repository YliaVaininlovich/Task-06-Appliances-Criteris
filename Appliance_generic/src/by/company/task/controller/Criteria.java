package by.company.task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Criteria<T> {
    private String groupSearchName;
    private Map<T, Object> criteriaMap = new HashMap<T, Object>();

    public Criteria() {
    }

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return groupSearchName;
    }

    public void add(T searchCriteria, Object value) {
        criteriaMap.put(searchCriteria, value);
    }

    public List<String> get (){
        List<String> filteredData = new ArrayList<String>();

        for(Map.Entry<T, Object> oneCriteris : criteriaMap.entrySet()){
            filteredData.add(oneCriteris.getKey().toString()+"="+oneCriteris.getValue().toString());
        }
        return filteredData;
    }

}
