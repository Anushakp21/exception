package tryandcatch;

import java.io.IOException;

class FileReader {
    public void readFile() throws Exception {
        try {
            throw new IOException("Error occurred while reading the file");
        } 
        catch (IOException e) {
            throw new Exception("Failed to complete file operation", e);
        }
    }
}

public class ExceptionChaining {
	public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            System.out.println("Cause of the exception: " + e.getCause());
        }
    }
}
