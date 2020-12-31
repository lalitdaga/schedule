package backend.home.challenge.job.schedule.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String value;
    @ApiModelProperty(required = true, example = "2020-12-29 22:48")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="Asia/Kolkata")
    Date timing;
}
