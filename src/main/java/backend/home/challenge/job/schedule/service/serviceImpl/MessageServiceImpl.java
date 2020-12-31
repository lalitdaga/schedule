package backend.home.challenge.job.schedule.service.serviceImpl;

import backend.home.challenge.job.schedule.constants.ApplicationConstants;
import backend.home.challenge.job.schedule.dto.MessageDto;
import backend.home.challenge.job.schedule.dto.SimpleResponseDto;
import backend.home.challenge.job.schedule.entity.Message;
import backend.home.challenge.job.schedule.repository.MessageRepository;
import backend.home.challenge.job.schedule.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public SimpleResponseDto create(MessageDto messageDto) {
        SimpleResponseDto simpleResponseDto = new SimpleResponseDto();
        Message savedMessage = messageRepository.save(Message.builder().value(messageDto.getValue()).timing(messageDto.getTiming()).build());
        if (Objects.nonNull(savedMessage)) {
            simpleResponseDto.put(ApplicationConstants.STATUS.getValue(), ApplicationConstants.SUCCESS);
            simpleResponseDto.put(ApplicationConstants.MESSAGE.getValue(), savedMessage);
        } else simpleResponseDto.put(ApplicationConstants.MESSAGE.getValue(), ApplicationConstants.FAILED.getValue());
        return simpleResponseDto;
    }
}
