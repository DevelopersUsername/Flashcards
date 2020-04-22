class Car {

    int yearModel;
    String make;
    int speed;

    public void accelerate() {
        this.speed += 5;
    }

    public int brake() {
        this.speed = this.speed < 5 ? 0 : this.speed - 5;
        return this.speed;
    }
}