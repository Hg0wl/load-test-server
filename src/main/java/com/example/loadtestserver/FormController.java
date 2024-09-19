package com.example.loadtestserver;

import static org.springframework.http.MediaType.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @PostMapping(path = "/user", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<?> submitForm(@RequestParam String form) {
    //Form newForm = new Form(form.split(","));
    Form newForm = new Form();

    if (formService.submitForm(newForm)) {
      return new ResponseEntity<>(HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }
}
