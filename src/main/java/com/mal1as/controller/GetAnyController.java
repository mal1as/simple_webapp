package com.mal1as.controller;

import com.mal1as.dto.ExtendedResponseDTO;
import com.mal1as.exception.RequestValidationException;
import com.mal1as.service.Db2AnyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Map;
import java.util.Objects;

@RestController
@EnableWebMvc
@RequestMapping("/db2any")
public class GetAnyController {

    private final Db2AnyService db2AnyService;

    @Autowired
    public GetAnyController(Db2AnyService db2AnyService) {
        this.db2AnyService = db2AnyService;
    }

    @RequestMapping(path = "/bykey/getjson", method = RequestMethod.GET)
    public ResponseEntity<ExtendedResponseDTO> getJsonEntityByKey(@RequestParam(required = false) String key) {
        if(Objects.isNull(key)) {
            throw new RequestValidationException("Request parameter 'key' is required");
        }

        Map<String, Object> anyEntityByKey = db2AnyService.getAnyEntityByKey(key);
        return ResponseEntity.ok(ExtendedResponseDTO.builder()
                .data(anyEntityByKey)
                .request(key)
                .response(HttpStatus.OK.getReasonPhrase())
                .build());
    }
}
