package behavioral.iterator.profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Profile {
    private String name;
    private String email;
    private Map<String, List<String>> contacts;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getContacts(String contactType) {
        if (!contacts.containsKey(contactType)) {
            contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}
