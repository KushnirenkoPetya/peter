package ElectronicLibraryJava;

public class Reader {
    private int id;
    private String fullName;
    private String phone;
    private String email;

    public Reader() {
    }

    public Reader(int id, String fullName, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public void searchBooks(String query) {
    }

    public void viewBookInformation(int bookId) {

    }

    public void requestBookIssue(int bookId) {
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
