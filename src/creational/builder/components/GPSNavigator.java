package creational.builder.components;

public class GPSNavigator {
    private final String route;

    public GPSNavigator() {
        route = "Tan Phu district, Ho Chi Minh city";
    }

    public GPSNavigator(String route) {
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
