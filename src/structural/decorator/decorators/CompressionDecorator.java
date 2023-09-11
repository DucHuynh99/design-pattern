package structural.decorator.decorators;

import structural.decorator.DataSource;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void write(String data) {
        super.write(compress(data));
    }

    @Override
    public String read() {
        return decompress(super.read());
    }

    private String compress(String data) {
        System.out.println("...Compress data");
        return "Compress(" + data + ")";
    }

    private String decompress(String data) {
        System.out.println("...Decompress data");
        if (data == null || data.isBlank())
            return null;
        return data.substring(9, data.length() - 1);
    }
}
