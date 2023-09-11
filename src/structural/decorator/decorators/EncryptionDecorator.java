package structural.decorator.decorators;

import structural.decorator.DataSource;

public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void write(String data) {
        super.write(encode(data));
    }

    @Override
    public String read() {
        return decode(super.read());
    }

    private String encode(String data) {
        System.out.println("...Encode data");
        return "Encode(" + data + ")";
    }

    private String decode(String data) {
        System.out.println("...Decode data");
        if (data == null || data.isEmpty())
            return null;
        return data.substring(7, data.length() - 1);
    }
}
