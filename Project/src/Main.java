import java.util.HashSet;
import java.util.Set;

/*

Help: https://www.baeldung.com/hibernate-one-to-many

Compile and run from command line:

   ./run.sh on linux and mac
   .\run.bat on windows

For VisualStudio add: 
"vmArgs": "--add-opens=java.base/java.nio=ALL-UNNAMED --add-opens=java.base/java.lang=ALL-UNNAMED" 
at .vscode/launch.json

*/

public class Main {

   public static void main(String[] args) {
      
      Manager.createSessionFactory();

      Cart refCart1 = Manager.addCart("Cart 1");
      Cart refCart2 = Manager.addCart("Cart 2");
      Cart refCart3 = Manager.addCart("Cart 3");

      Item refItem1 = Manager.addItem("Item 1");
      Item refItem2 = Manager.addItem("Item 2");
      Item refItem3 = Manager.addItem("Item 3");
      Item refItem4 = Manager.addItem("Item 4");
      Item refItem5 = Manager.addItem("Item 5");
      Item refItem6 = Manager.addItem("Item 6");

      Set<Item> itemsCard1 = new HashSet<Item>();
      itemsCard1.add(refItem1);
      itemsCard1.add(refItem2);
      itemsCard1.add(refItem3);

      Manager.updateCart(refCart1.getCartId(), refCart1.getType(), itemsCard1);

      Set<Item> itemsCard2 = new HashSet<Item>();
      itemsCard2.add(refItem4);
      itemsCard2.add(refItem5);

      Manager.updateCart(refCart2.getCartId(), refCart2.getType(), itemsCard2);

      Manager.delete(Cart.class, refCart3.getCartId());
      Manager.delete(Item.class, refItem6.getItemId());

      System.out.println(Manager.collectionToString(Cart.class, Manager.listCollection(Cart.class)));
      System.out.println(Manager.collectionToString(Item.class, Manager.listCollection(Item.class)));

      Manager.close();
   }
}