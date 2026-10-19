package ElectronicLibraryJava;

public class BookIssue {
    private int id;
    private int readerId;
    private int bookId;
    private String issueDate;
    private String returnDate;
    private String status;

    public BookIssue() {
    }

    public BookIssue(int id, int readerId, int bookId,
                     String issueDate, String returnDate,
                     String status) {
        this.id = id;
        this.readerId = readerId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public void returnBook(String returnDate) {
    }

    public void extendReturnDate(String newReturnDate) {
    }

    @Override
    public String toString() {
        return "BookIssue{" +
                "id=" + id +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", issueDate='" + issueDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
