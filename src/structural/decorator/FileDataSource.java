package structural.decorator;

import java.io.*;

public class FileDataSource implements DataSource {
    private final String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void write(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String read() {
        char[] buffer;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(buffer);
    }
}