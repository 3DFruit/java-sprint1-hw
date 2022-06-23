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

    void writeStepsCount(int month, int day, int steps) {
        stepsData[--month][-- day] = steps;
    }

    String getDataForMonth (int month) {
        month--;
        String output ="1 день: " + stepsData[month][0];
        for (int i = 1; i < stepsData[month].length; i++) {
            output += ", " + (i + 1) + " день: " + stepsData[month][i];
        }
        return output;
    }

    int calculateSummaryStepsForMonth(int month){
        month--;
        int summary = 0;
        for (int i = 0; i < stepsData[month].length; i++){
            summary += stepsData[month][i];
        }
        return summary;
    }

    int findMaximumStepsForMonth(int month){
        month--;
        int maxSteps = 0;
        for (int i = 0; i < stepsData[month].length; i++){
            if (maxSteps < stepsData[month][i]){
                maxSteps = stepsData[month][i];
            }
        }
        return  maxSteps;
    }

    double calculateAverageStepsForMonth(int month){
        return  calculateSummaryStepsForMonth(month) / stepsData[--month].length;
    }

    double calculateMonthDistance(int month){
        Converter converter = new Converter();
        return converter.convertStepsToKilometers(calculateSummaryStepsForMonth(month));
    }

    double calculateMonthCalories(int month){
        Converter converter = new Converter();
        return converter.convertStepsToKilocalories(calculateSummaryStepsForMonth(month));
    }

    int findBestSeries (int month){
        month--;
        int bestSeries = 0;
        int series = 0;
        for (int i = 0; i < stepsData[month].length; i++){
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
        return getDataForMonth(month) + "\n" +
                "Общее количество шагов за месяц - " + calculateSummaryStepsForMonth(month) + "\n" +
                "Максимальное пройденное количество шагов за месяц - " + findMaximumStepsForMonth(month) + "\n" +
                "Среднее количество шагов в день - " + calculateAverageStepsForMonth(month) + "\n" +
                "За месяц пройдена дистанция в " + calculateMonthDistance(month) + " км" + "\n" +
                "За месяц cожжено " + calculateMonthCalories(month) + " ккал" + "\n" +
                "Лучшая  серия в выбранном месяце составила " + findBestSeries(month) + " дней";
    }
}
