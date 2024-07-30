public class FactoryMethodPatternExample {

    interface Document {
        void open();
        void save();
    }

    // word
    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word Document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Word Document...");
        }
    }

    // pdf
    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF Document...");
        }

        @Override
        public void save() {
            System.out.println("Saving PDF Document...");
        }
    }

    // excel
    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel Document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Excel Document...");
        }
    }

    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
    }
}



/*
output :-
-------
Opening Word Document...
Saving Word Document...
Opening PDF Document...
Saving PDF Document...
Opening Excel Document...
Saving Excel Document...

*/
