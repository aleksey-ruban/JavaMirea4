package unit6.builder;

public class Auto {

    private int power;
    private int maxSpeed;
    private int qtyPassengers;

    public int getPower() {
        return power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getQtyPassengers() {
        return qtyPassengers;
    }

    private Auto(AutoBuilder builder) {
        this.power = builder.power;
        this.maxSpeed = builder.maxSpeed;
        this.qtyPassengers = builder.qtyPassengers;
    }

    public static class AutoBuilder {
        private int power;
        private int maxSpeed;
        private int qtyPassengers;

        public AutoBuilder() {
            this.power = 100;
            this.maxSpeed = 220;
            this.qtyPassengers = 4;
        }

        public AutoBuilder setPower(int power) {
            this.power = power;
            return this;
        }

        public AutoBuilder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public AutoBuilder setQtyPassengers(int qtyPassengers) {
            this.qtyPassengers = qtyPassengers;
            return this;
        }

        public Auto build() {
            return new Auto(this);
        }


    }
}
