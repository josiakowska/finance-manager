import org.hibernate.Session;
import org.manager.DbConnection;
import org.manager.entity.Outgoing;
import org.manager.service.CategoryService;
import java.util.Scanner;


public class Main {

    private static final CategoryService categoryService = new CategoryService();

    public static void main(String[] args) {
        Session session = DbConnection.getSession();
        session.get(Outgoing.class, 1L);
        session.close();

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation");
            System.out.println("1 - Add category");
            System.out.println("2 - Remove category");

            int decision = in.nextInt();

            switch (decision) {
                case 0 -> {
                    DbConnection.closeSessionFactory();
                    System.exit(0);
                }

                case 1 -> {
                    try {
                        System.out.println("Type category name");
                        in.nextLine().toLowerCase();
                        String categoryName = in.nextLine().toLowerCase();
                        categoryService.addCategory(categoryName);
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }

                }
            }
        }
    }
}


