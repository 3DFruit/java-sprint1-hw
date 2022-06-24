public class Converter {
    double convertStepsToKilometers (int steps){
        return steps * 0.75 / 1000;
    }

    double convertStepsToKilocalories (int steps){
        return steps * 50.0 / 1000;
    }
}
