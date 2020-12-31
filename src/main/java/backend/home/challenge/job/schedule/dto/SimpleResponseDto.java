package backend.home.challenge.job.schedule.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class SimpleResponseDto {
    @JsonProperty("data")
    private Map<String, Object> data;

    public SimpleResponseDto() {
        data = new HashMap<>();
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public Boolean containsKey(String key) {
        return data.containsKey(key);
    }
}
