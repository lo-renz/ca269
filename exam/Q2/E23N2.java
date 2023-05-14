import java.util.List;
import java.util.ArrayList;

interface Weather {
    int getMinTemp();
    int getMaxTemp();
}

interface SunnyWeather extends Weather {
    int getMinutesOfSunshine(); // how many minutes of sun we got in the day
}

interface RainyWeather extends Weather {
    double getAmount(); // amount of rainfall in the day, measured in mm
    boolean hasPersistence(); // whether rainfall will persist all day
}

interface SunshowerWeather extends SunnyWeather, RainyWeather {}

class DailyWeather implements Weather {
    int minTemp;
    int maxTemp;

    public int getMinTemp() {
        return this.minTemp;
    }

    public int getMaxTemp() {
        return this.maxTemp;
    }

    DailyWeather(int minTemp, int maxTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    static List<SunshowerWeather> getStayIndoorDays(List<SunshowerWeather> list) {
        List<SunshowerWeather> stayIndoors = new ArrayList<>();

        for(SunshowerWeather day: list) {
            if(day instanceof RainyWeather && day.hasPersistence() == true) {
                stayIndoors.add(day);
            }
        }

        return stayIndoors;
    }

    static List<SunshowerWeather> getSingleWeatherDays(List<SunshowerWeather> list) {
        List<SunshowerWeather> days = new ArrayList<>();

        for(SunshowerWeather day: list) {
        }
    }
}

class SunshowerDay extends DailyWeather implements SunshowerWeather {
    int minutesOfSunshine;
    double amount;
    boolean persistence;

    public int getMinutesOfSunshine() {
        return this.minutesOfSunshine;
    }

    public double getAmount() {
        return this.amount;
    }

    public boolean hasPersistence() {
        return this.persistence;
    }

    SunshowerDay(int minTemp, int maxTemp, int minutesOfSunshine, int amount, boolean persistence) {
        super(minTemp, maxTemp);
        this.minutesOfSunshine = minutesOfSunshine;
        this.amount = amount;
        this.persistence = persistence;
    }
}