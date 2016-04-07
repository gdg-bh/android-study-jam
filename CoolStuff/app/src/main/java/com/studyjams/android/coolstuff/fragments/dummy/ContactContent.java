package com.studyjams.android.coolstuff.fragments.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ContactContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<ContactItem> ITEMS = new ArrayList<ContactItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, ContactItem> ITEM_MAP = new HashMap<String, ContactItem>();

    private static final int COUNT = 26;

    private static final String[] NAMES = { "Jordan Silva", "Ana Paula", "Felipe Arimateia",
            "Alessandra", "Amanda", "Ariana", "Bruno", "Carlos", "Emanuelle", "Gláucia",
            "Gleiciane", "Igor", "Jaqueline", "Lucas", "Luciano", "Max", "Rafael", "Raquel",
            "Rodrigo", "Ronan", "Rosalves", "Tarlles", "Teobaldo", "Thiago", "Vinicius", "Vivian" };

    private static final String[] EMAILS = { "silva.jordan@gmail.com", "ana@ana.com",
            "felipe@felipe.com", "alessandra@email.com", "amanda@email.com", "ariana@email.com",
            "bruno@email.com", "carlos@email.com", "emanuelle@email.com", "glaucia@email.com",
            "gleiciane@email.com", "igor@email.com", "jaqueline@email.com", "lucas@email.com",
            "luciano@email.com", "max@email.com", "rafael@email.com", "raquel@email.com",
            "rodrigo@email.com", "ronan@email.com", "rosalves@email.com", "tarlles@email.com",
            "teobaldo@email.com", "thiago@email.com", "vinicius@email.com", "vivian@email.com" };

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(ContactItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static ContactItem createDummyItem(int position) {
        return new ContactItem(String.valueOf(position), NAMES[position-1], EMAILS[position-1]);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ContactItem {
        public final String id;
        public final String name;
        public final String email;

        public ContactItem(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
