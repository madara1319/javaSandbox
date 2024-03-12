import java.util.ArrayList;
public class MenuTestDrive{
    public static void main(String args[]){
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        CafeMenu cafeMenu = new CafeMenu();
        ArrayList<Menu> menus = new ArrayList<Menu>();
        menus.add(dinerMenu);
        menus.add(pancakeHouseMenu);
        menus.add(cafeMenu);
        Waitress waitress = new Waitress(menus);

        waitress.printMenu();
    }
}
