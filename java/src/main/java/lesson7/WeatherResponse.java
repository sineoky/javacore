package lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
//public class WeatherResponse {
    public class WeatherResponse implements Serializable {
    @JsonProperty(value = "Headline")
    //private Headline headline;
    public Headline headline;
    @JsonProperty(value = "DailyForecasts")
    //private DailyForecast dailyforecast;
    public List<DailyForecasts> dailyForecasts;
    @Override
    public String toString() {return dailyForecasts.toString()+"\r\n";}
}