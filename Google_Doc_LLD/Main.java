import java.util.ArrayList;
import java.util.List;

// ==================== Document Element Interface ====================

interface DocumentElement {
    String render();
}

// ==================== Document Elements ====================

class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return text;
    }
}

class ImageElement implements DocumentElement {
    private final String imagePath;

    public ImageElement(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String render() {
        return "[Image: " + imagePath + "]";
    }
}

class NewLineElement implements DocumentElement {

    @Override
    public String render() {
        return "\n";
    }
}

class TabSpaceElement implements DocumentElement {

    @Override
    public String render() {
        return "\t";
    }
}

// ==================== Document Class ====================

class Document {
    private final List<DocumentElement> documentElements =
            new ArrayList<>();

    public void add(DocumentElement element) {
        documentElements.add(element);
    }

    public String render() {
        StringBuilder result = new StringBuilder();

        for (DocumentElement element : documentElements) {
            result.append(element.render());
        }

        return result.toString();
    }
}

// ==================== Persistence Interface ====================

interface Persistence {
    void save(String content);
}

// ==================== Persistence Implementations ====================

class SaveToFile implements Persistence {

    @Override
    public void save(String content) {
        System.out.println(
                content + "\nSuccessfully saved to file system."
        );
    }
}

class SaveToDB implements Persistence {

    @Override
    public void save(String content) {
        System.out.println(
                content + "\nSuccessfully saved to database."
        );
    }
}

// ==================== Document Editor ====================

class DocumentEditor {
    private final Document document;
    private final Persistence persistence;

    public DocumentEditor(
            Document document,
            Persistence persistence
    ) {
        this.document = document;
        this.persistence = persistence;
    }

    public void addText(String text) {
        document.add(new TextElement(text));
    }

    public void addImage(String path) {
        document.add(new ImageElement(path));
    }

    public void addNewLine() {
        document.add(new NewLineElement());
    }

    public void addTabSpace() {
        document.add(new TabSpaceElement());
    }

    public String renderDocument() {
        return document.render();
    }

    public void saveDocument() {
        persistence.save(renderDocument());
    }
}

// ==================== Main Class ====================

public class Main {

    public static void main(String[] args) {

        Document document = new Document();

        Persistence persistence = new SaveToFile();

        DocumentEditor editor =
                new DocumentEditor(document, persistence);

        editor.addText("Hello, Google Docs!");
        editor.addNewLine();

        editor.addText("This is my LLD project.");
        editor.addNewLine();

        editor.addTabSpace();
        editor.addText("Learning Java Design Patterns.");

        editor.addNewLine();
        editor.addImage("photo.png");

        System.out.println("Rendered Document:");
        System.out.println(editor.renderDocument());

        System.out.println("\nSaving Document:");
        editor.saveDocument();
    }
}
