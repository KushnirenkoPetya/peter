package ElectronicLibraryJava;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private int categoryId;
    private String status;

    public Book() {
    }

    public Book(int id, String title, String author,
                int year, int categoryId, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.categoryId = categoryId;
        this.status = status;
    }

    public void updateInformation(String title, String author,
                                  int year, int categoryId) {
    }

    public void changeStatus(String status) {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", categoryId=" + categoryId +
                ", status='" + status + '\'' +
                '}';
    }
}
