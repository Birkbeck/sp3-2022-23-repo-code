package prototype.client;

import prototype.client.Book;
import prototype.client.CD;
import prototype.client.Item;

import java.util.Hashtable;
import java.util.Map;

public class ItemRegistry {
    private final Map<String, Item> map = new Hashtable<>();

    public ItemRegistry() {
        loadCache();
    }

    public Item createBasicItem(String type) {
        return map.get(type).clone();
    }

    private void loadCache() {
        Book book = new Book();
        book.setTitle("Design Patterns");
        book.setPrice(20.00);
        map.put("Book", book);
        CD cd = new CD();
        cd.setTitle("Various");
        cd.setPrice(10.00);
        map.put("CD", cd);
    }
}
