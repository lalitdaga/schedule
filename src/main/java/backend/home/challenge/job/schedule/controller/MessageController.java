package backend.home.challenge.job.schedule.controller;

import backend.home.challenge.job.schedule.dto.MessageDto;
import backend.home.challenge.job.schedule.dto.SimpleResponseDto;
import backend.home.challenge.job.schedule.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@Api(tags = {"Message Controller"})
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping
    @ApiOperation(value = "Create a message job", response = SimpleResponseDto.class)
    public ResponseEntity create(@RequestBody MessageDto messageDto) {
        return new ResponseEntity(messageService.create(messageDto), HttpStatus.ACCEPTED);
    }
}
