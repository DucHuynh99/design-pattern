package structural.decorator.decorators;

import structural.decorator.DataSource;

public class DataSourceDecorator implements DataSource {
    private final DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void write(String data) {
        wrappee.write(data);
    }

    @Override
    public String read() {
        return wrappee.read();
    }
}
