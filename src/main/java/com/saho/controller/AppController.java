package com.saho.controller;

import com.saho.model.Book;
import com.saho.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sahin.dagdelen on 1/24/2016.
 *
 * based on http://websystique.com/springmvc/spring-4-mvc-and-hibernate4-integration-example-using-annotations/
 */

@Controller
@RequestMapping("/")
public class AppController {


    @Autowired
    BookService bookService;



    @RequestMapping(value = {"/","list"},method = RequestMethod.GET)
    public String listBooks(ModelMap modelMap){
        List<Book> books=bookService.findAllBooks();
        modelMap.addAttribute("books",books);
        return "allbooks";

    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newBook(ModelMap model){
        Book book=new Book();
        model.addAttribute("book",book);
        model.addAttribute("edit",false);
        return "adminandlibrarian/bookregistration";
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveBook(@Valid Book book,BindingResult result,ModelMap model){

        if(result.hasErrors()){
            return "adminandlibrarian/bookregistration";
      }


        if(!bookService.isBookIdUnique(book.getId())){
            FieldError idRepError=new FieldError("book","id","non unique id");
            result.addError(idRepError);
            System.out.println("non uniq id");
            return "adminandlibrarian/bookregistration";
        }

        bookService.saveBook(book);
        model.addAttribute("book",book);
        model.addAttribute("success","Book "+book.getName()+" registered successfully!!");
        return "success";

    }


    @RequestMapping(value = { "/edit-{id}-book" }, method = RequestMethod.GET)
    public String editBook(@PathVariable long id, ModelMap model) {
        Book book = bookService.findByid(id);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "adminandlibrarian/bookregistration";
    }



    @RequestMapping(value = { "/edit-{id}-book" }, method = RequestMethod.POST)
    public String updateBook(@Valid Book book, BindingResult result,
                                 ModelMap model, @PathVariable long id) {
        if (result.hasErrors()) {
            return "adminandlibrarian/bookregistration";
        }



        bookService.updateBook(book);
        model.addAttribute("success","book "+book.getName()+" updated successfully!");

        return "success";
    }

    @RequestMapping(value = {"/delete-{id}-book"},method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable long id){
          bookService.deleteBookById(id);
          return "redirect:/list";
    }


    @RequestMapping(value = {"/issuebook"},method = RequestMethod.GET)
    public String issueBookRequest(){
        return "issuebook";
    }


}
