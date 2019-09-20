package com.zwb.test;

public interface Ienum {
    enum enumclass{
        RED("rgb1", .5),
        BLUE("rgb2", 9.9);

        private String rgb;
        private double v;

        enumclass(String rgb, double v) {
            this.rgb = rgb;
        }

        public String getRgb() {
            return rgb;
        }

        public void setRgb(String rgb) {
            this.rgb = rgb;
        }

        public double getV() {
            return v;
        }

        public void setV(double v) {
            this.v = v;
        }
    }
}
