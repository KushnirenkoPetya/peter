package ElectronicLibraryJava;

public class Librarian {
    private int id;
    private String fullName;
    private String email;
    private String role;

    public Librarian() {
    }

    public Librarian(int id, String fullName,
                     String email, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public void addBook(Book book) {
    }

    public void manageReader(Reader reader) {
    }

    public void processBookIssue(BookIssue issue) {
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
