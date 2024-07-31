import java.util.Arrays;
class Item {
    private String id;
    private String name;
    private String category;
    public Item(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}

class ECommerceSearchUtil {
    // Linear Search
    public static Item linearSearch(Item[] items, String searchTerm) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(searchTerm)) {
                return item;
            }
        }
        return null; // Item not found
    }

    // Binary Search
    public static Item binarySearch(Item[] items, String searchTerm) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = items[mid].getName().compareToIgnoreCase(searchTerm);

            if (cmp == 0) {
                return items[mid]; // Item found
            } else if (cmp < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return null; // Item not found
    }

    // Utility method to sort the array before binary search
    public static void sortItemsByName(Item[] items) {
        Arrays.sort(items, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
    }
}
