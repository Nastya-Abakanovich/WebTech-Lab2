package by.bsuir.lab2.entity.criteria;


import java.util.HashMap;
import java.util.Map;

public class Criteria {
    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap();

    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public String getGroupSearchName() {
        return this.groupSearchName;
    }

    public void add(String searchCriteria, Object value) {
        this.criteria.put(searchCriteria, value);
    }
}
