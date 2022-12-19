package api.controller;

import api.dto.response.ResponseDTO;
import api.dto.request.BookRequestDTO;
import api.service.IBookService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @GetMapping("/{filter}")
    public ResponseEntity<?> getByFilter(@PathVariable(required = false) String filter , @RequestParam(required = false) String keyword) {
        return new ResponseEntity<>(iBookService.getBooksByFilter(filter,keyword), HttpStatus.OK);
    }


    @GetMapping("/year")
    public ResponseEntity<?> getByYear(@RequestParam(required = true) String dateStart,@RequestParam(required = true) String dateEnd) {
        return new ResponseEntity<>(iBookService.getBooksByYear(dateStart,dateEnd), HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createBook(@RequestBody BookRequestDTO request) {
        return new ResponseEntity<>(iBookService.create(request), HttpStatus.OK);
    }
}
