import java.util.Iterator;
import java.util.ArrayList;
public class Waitress{
    ArrayList<Menu> menus;
    
    public Waitress(ArrayList<Menu> menus){
        this.menus = menus;
    }

    public void printMenu(){
        Iterator<Menu> menuIterator = menus.iterator();
        while(menuIterator.hasNext()){
            Menu menu = menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    void printMenu(Iterator<MenuItem> iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem.getName() + ", ");
            System.out.println(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
            
        }
    }
}
