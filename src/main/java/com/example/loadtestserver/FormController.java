package com.example.loadtestserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/userAgent")
public class FormController {
  @Autowired
  private FormService formService;

  @GetMapping("/")
  String home() {
    return "Landing Page";
  }

  @PostMapping("/user")
  public ResponseEntity submitForm(@RequestBody Form form) {
    if (formService.submitForm(form)) {
      return new ResponseEntity(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
  }
}
