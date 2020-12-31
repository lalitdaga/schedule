package backend.home.challenge.job.schedule.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationConstants {

  STATUS("status"),
  SUCCESS("success"),
  FAILED("failed"),
  MESSAGE("message");

  private String value;
}
