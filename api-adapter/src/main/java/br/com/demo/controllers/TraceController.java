package br.com.demo.controllers;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import brave.Span;
import brave.Tracer;

@Controller
@RequestMapping("${api.version.v1}/trace")
public class TraceController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TraceController.class);

    private Tracer tracer;

    @GetMapping
    ResponseEntity<Long> trace(@RequestHeader("correlation-id") String correlationId){
        LOGGER.debug("m=trace()");
        Span newSpan = tracer.nextSpan().name(Optional.ofNullable(correlationId).orElse(UUID.randomUUID().toString())).start();

        //TODO - Do some logic

        newSpan.finish();

        return ResponseEntity.ok(newSpan.context().traceId());
    }
}
