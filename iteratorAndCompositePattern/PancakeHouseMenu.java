import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu{
    List<MenuItem> menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList<MenuItem>();
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes made with fresh blueberries",
                true,
                3.49);
        addItem("Waffles",
                "Waffles with your choice of blueberries or strawberries",
                true,
                3.59);
    }
    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarian,price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator(){
        return new PancakeHouseIterator(menuItems);
    }
  //  public ArrayList<MenuItem> getMenuItems(){
  //      return menuItems;
  //  }

    //other menu methods here
}
