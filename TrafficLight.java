package oel;

class TrafficLight {
    boolean isGreen; // True if green, false if red

    public TrafficLight() {
        this.isGreen = false;
    }

    public void toggleLight() {
        this.isGreen = !this.isGreen;
    }
}
