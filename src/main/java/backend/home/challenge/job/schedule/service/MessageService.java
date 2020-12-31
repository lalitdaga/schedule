package backend.home.challenge.job.schedule.service;

import backend.home.challenge.job.schedule.dto.MessageDto;
import backend.home.challenge.job.schedule.dto.SimpleResponseDto;

public interface MessageService {
    SimpleResponseDto create(MessageDto messageDto);
}
