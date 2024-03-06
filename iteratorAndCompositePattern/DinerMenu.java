public class DinerMenu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu(){
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.29);
        addItem("Hotdog",
                "A hot dog with sauerkraut, relish, onions, topped with cheese",
                false,
                3.05);
        //a couple of other Diner Menu items added here
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry, menu is full! Cant add item to the menu");
        }
        else{
            menuItems[numberOfItems]=menuItem;
            numberOfItems=numberOfItems+1;
        }
    }
    public MenuItem[] getMenuItems(){
        return menuItems;
    }
    //other menu methods here
}
