package ElectronicLibraryJava;

public class Main {
    public static void main(String[] args) {

        Reader reader = new Reader(
                1,
                "Кушніренко Петро",
                "+380501234567",
                "petro@example.com"
        );

        Book book = new Book(
                1,
                "Основи Java",
                "Герберт Шилдт",
                2022,
                1,
                "available"
        );

        Librarian librarian = new Librarian(
                1,
                "Олена Іваненко",
                "librarian@example.com",
                "Адміністратор"
        );

        Category category = new Category(
                1,
                "Програмування",
                "Книги з програмування та інформаційних технологій"
        );

        BookIssue issue = new BookIssue(
                1,
                1,
                1,
                "2026-10-19",
                "2026-11-02",
                "active"
        );

        System.out.println("=== ЕЛЕКТРОННА БІБЛІОТЕКА ===");

        System.out.println("\nІнформація про читача:");
        System.out.println(reader.toString());

        System.out.println("\nІнформація про книгу:");
        System.out.println(book.toString());

        System.out.println("\nІнформація про бібліотекаря:");
        System.out.println(librarian.toString());

        System.out.println("\nІнформація про категорію:");
        System.out.println(category.toString());

        System.out.println("\nІнформація про видачу книги:");
        System.out.println(issue.toString());
    }
}
