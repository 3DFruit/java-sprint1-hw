public class StepTracker {

    int targetSteps;    // целоыое количество шагов
    int[][] stepsData;  // данные о шагах за день

    StepTracker(){
        targetSteps = 10000;
        stepsData = new int[12][30];
    }

    boolean changeTargetSteps (int targetSteps) {
        if (targetSteps >= 0) {
            this.targetSteps = targetSteps;
            return  true;
        } else return false;
    }

    void setStepsAmount(int month, int day, int steps) {
        stepsData[month][day] = steps;
    }

    String getDataForMonth (int month) {
        String output ="1 день: " + stepsData[month][0];
        for (int i = 1; i < 30; i++) {
            output += ", " + (i + 1) + " день: " + stepsData[month][i];
        }
        return output;
    }

    int calculateSummaryStepsForMonth(int month){
        int summary = 0;
        for (int i = 0; i < 30; i++){
            summary += stepsData[month][i];
        }
        return summary;
    }

    int findMaximumStepsForMonth(int month){
        int maxSteps = 0;
        for (int i = 0; i < 30; i++){
            if (maxSteps < stepsData[month][i]){
                maxSteps = stepsData[month][i];
            }
        }
        return  maxSteps;
    }

    int findBestSeries (int month){
        int bestSeries = 0;
        int series = 0;
        for (int i = 0; i < 30; i++){
            if (stepsData[month][i] >= targetSteps) {
                series++;
            }
            else {
                if (series > bestSeries) {
                    bestSeries = series;
                }
                series = 0;
            }
        }
        if (series > bestSeries) {
            bestSeries = series;
        }
        return bestSeries;
    }

    String getStatisticsString(int month){
        Converter converter = new Converter();
        int stepsAmount = calculateSummaryStepsForMonth(month);
        return getDataForMonth(month) + "\n" +
                "Общее количество шагов за месяц - " + stepsAmount + "\n" +
                "Максимальное пройденное количество шагов за месяц - " + findMaximumStepsForMonth(month) + "\n" +
                "Среднее количество шагов в день - " + stepsAmount / 30.0 + "\n" +
                "За месяц пройдена дистанция в " + converter.convertStepsToKilometers(stepsAmount) + " км" + "\n" +
                "За месяц cожжено " + converter.convertStepsToKilocalories(stepsAmount) + " ккал" + "\n" +
                "Лучшая серия в выбранном месяце составила " + findBestSeries(month) + " дней";
    }
}
