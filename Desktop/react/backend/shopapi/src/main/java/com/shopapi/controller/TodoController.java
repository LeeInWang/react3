package com.shopapi.controller;


import com.shopapi.dto.PageRequestDTO;
import com.shopapi.dto.PageResponseDTO;
import com.shopapi.dto.TodoDTO;
import com.shopapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController // JSON 형태로 출력하겠다.
@RequiredArgsConstructor // 생성자 주입 final로 처리
@Log4j2 
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService service;
    //향상성 유지
    @GetMapping("/{tno}") //PathVariable 방식 @PathVariable(name ="tno") 의 name 값과 같아야함
    public TodoDTO get(@PathVariable(name ="tno") Long tno) {

        return service.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO ) {

        log.info(pageRequestDTO);

        return service.list(pageRequestDTO);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDTO todoDTO){

        log.info("******  TodoDTO:  ******   " + todoDTO);

        Long tno = service.register(todoDTO);

        return Map.of("TNO", tno);
    }

    @PutMapping("/{tno}") //put방식 = 바꾸겠다.
    public Map<String, String> modify(
            @PathVariable(name="tno") Long tno,
            @RequestBody TodoDTO todoDTO) {

        todoDTO.setTno(tno);

        log.info("Modify: " + todoDTO);

        service.modify(todoDTO);

        return Map.of("RESULT", "SUCCESS");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> remove( @PathVariable(name="tno") Long tno ){

        log.info("Remove:  " + tno);

        service.remove(tno);

        return Map.of("RESULT", "SUCCESS");
    }



}
