package structural.bridge.devices;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.min(Math.max(volume, 0), 100);
    }

    @Override
    public void printStatus() {
        System.out.println("RADIO");
        System.out.println("Status: " + (on ? "ON" : "OFF"));
        System.out.println("Channel: " + channel);
        System.out.println("Volume: " + volume);
        System.out.println();
    }
}
