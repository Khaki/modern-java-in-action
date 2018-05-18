public class Dish {
    private final String name;

    private final boolean vegetarian;

    private final int calories;

    private final Type type;

    /**
     * Constructor of Dish.
     *
     * @param name       a dish name
     * @param vegetarian is this vegetarian
     * @param calories   how much calories this contains
     * @param type       what's the dish type
     */
    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    @SuppressWarnings("javadoc")
    public String getName() {
        return name;
    }

    @SuppressWarnings("javadoc")
    public boolean isVegetarian() {
        return vegetarian;
    }

    @SuppressWarnings("javadoc")
    public int getCalories() {
        return calories;
    }

    @SuppressWarnings("javadoc")
    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum Type {
        /**
         * <code>MEAT</code>
         */
        MEAT,
        /**
         * <code>FISH</code>
         */
        FISH,
        /**
         * <code>OTHER</code>
         */
        OTHER
    }
}

