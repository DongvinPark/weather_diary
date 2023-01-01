package zerobase.weather.service;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    @Value("${openweathermap.key}")
    private String apiKey;

    public void createDiary(LocalDate date, String text){
        getWeatherString();
    }



    public String getWeatherString(){
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;
        System.out.println(apiUrl);
        return "";
    }



    //------------- PRIVATE HELPER METHOD AREA --------------

}
