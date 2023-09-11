package structural.decorator;

public interface DataSource {
    void write(String data);

    String read();
}
