package spring.course.services;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;
import spring.course.config.TimeApiConfig;
import spring.course.model.TimeApiResponse;

@Service
public class TimeServiceImpl implements TimeService {

    private TimeApiConfig timeApiConfig;

    public TimeServiceImpl(TimeApiConfig timeApiConfig) {
        this.timeApiConfig = timeApiConfig;
    }

    @Override
    public String getCurrentTime(String timeZone) {
         HttpResponse<TimeApiResponse> response = Unirest.get(
                 timeApiConfig.getEndpoint() + timeApiConfig.getContinent() + "/" + timeZone)
                 .asObject(TimeApiResponse.class);
        return response.getBody().getUtc_datetime();
    }
}
