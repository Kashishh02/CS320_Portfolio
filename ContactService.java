import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // simple in-memory store keyed by contactId
    private final Map<String, Contact> contacts = new HashMap<>();

    // add a new contact; ID must be unique
    public boolean addContact(Contact contact) {
        if (contact == null) {
            return false;
        }
        String id = contact.getContactId();
        if (id == null || contacts.containsKey(id)) {
            return false; // duplicate or invalid
        }
        contacts.put(id, contact);
        return true;
    }

    // delete by contactId
    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }
        contacts.remove(contactId);
        return true;
    }

    // update fields for an existing contact (only allowed fields)
    public boolean updateContact(String contactId, String firstName, String lastName,
                                 String phone, String address) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            return false;
        }

        // only update when a value is provided; validation happens in setters
        if (firstName != null) {
            c.setFirstName(firstName);
        }
        if (lastName != null) {
            c.setLastName(lastName);
        }
        if (phone != null) {
            c.setPhone(phone);
        }
        if (address != null) {
            c.setAddress(address);
        }
        return true;
    }

    // helper for tests
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
