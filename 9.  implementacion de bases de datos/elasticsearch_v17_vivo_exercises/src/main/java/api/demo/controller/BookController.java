package api.demo.controller;

import api.demo.service.IBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private IBookService iBookService;

    public BookController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @GetMapping("")
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<>(iBookService.getBooks(), HttpStatus.OK);
    }
}
