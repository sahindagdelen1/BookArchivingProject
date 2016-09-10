package com.saho.controller;

import com.saho.model.*;
import com.saho.services.BookService;
import com.saho.services.ReservedBookService;
import com.saho.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by sahin.dagdelen on 2/19/2016.
 */


@Controller
@RequestMapping("/**book**")
public class BookController {

    @Autowired
    ReservedBookService reservedBookService;


    @Autowired
    BookService bookService;


    @Autowired
    UserService userService;

    @Autowired
    ReservedBook reservedBook;


     private static final Logger logger=Logger.getLogger(BookController.class);


      @RequestMapping(value = "/reservebook",method = RequestMethod.GET )
      public  String reserveBook(@ModelAttribute("bookDetailsForm")  BookDetailsForm bookDetailsForm,Map<String,Object> model){
         model.put("bookList", bookService.findAllBooks()) ;
          return  "reservebook";
      }


    @ModelAttribute("userList")
    public List<User> populateUserList(){
        return userService.listAllUsers();
    }


    @RequestMapping(value = "/reservebook",method = RequestMethod.POST )
    public  String reserveBookPost(@ModelAttribute("bookDetailsForm")  BookDetailsForm bookDetailsForm,Map<String,Object> model){
        reservedBook.setBookId(bookDetailsForm.getBook().getId());
        reservedBook.setBorrowerUserID(bookDetailsForm.getUser().getUserId());
        reservedBook.setInsertDate(new Date());
        reservedBookService.saveBook(reservedBook);
        model.put("success",bookDetailsForm.getBook()+" Book Reserved successfully! " );
        return  "success";
    }


    @RequestMapping(value = "/reservedbookdetails",method = RequestMethod.GET )
    public  String reserveBookDetailsGet(@ModelAttribute("bookDetailsForm")  BookDetailsForm bookDetailsForm,Map<String,Object> model){
        model.put("bookName","");
        model.put("category","");
        model.put("userId","");
        model.put("userName","");
        model.put("infook",false);
        return  "reservedbookdetails";
    }

    @RequestMapping(value = "/reservedbookdetails",method = RequestMethod.POST )
    public  String reserveBookDetails(@ModelAttribute("bookDetailsForm")  BookDetailsForm bookDetailsForm,Map<String,Object> model){
       List<ReservedBook> reservedBookList= reservedBookService.findById(bookDetailsForm.getUser().getUserId());
        List<BookDetailsForm> bookDetailsFormsList=new ArrayList<BookDetailsForm>();
        BookDetailsForm bookDetailsForm1=null;
        for(ReservedBook reservedBook:reservedBookList){
            bookDetailsForm1=new BookDetailsForm();
            Book book=bookService.findByid(reservedBook.getBookId());
            bookDetailsForm1.setBook(book);
            bookDetailsForm1.setUser(bookDetailsForm.getUser());
            bookDetailsFormsList.add(bookDetailsForm1);

      }


        model.put("bookDetailsFormsList",bookDetailsFormsList);
        if(bookDetailsFormsList.size()==0){
            model.put("message",bookDetailsForm.getUser().getFullName()+ " kullanicisina ait rezerve kitap yok");
        }else{
            model.put("infook",true);
        }

          return  "reservedbookdetails";
    }


    @ModelAttribute("optionList")
     public   List<String> initListBookSearch(){
        List<String> optionList=new ArrayList<String>();
        optionList.add("name");
        optionList.add("category");
         return optionList;
    }

    @RequestMapping(value = "/searchbook",method = RequestMethod.GET)
    public  String searchBookGet(@ModelAttribute("bookSearchForm") BookSearchForm bookSearchForm,Map<String,Object> model){
          return "searchbook";
    }

    @RequestMapping(value = "/searchbook",method = RequestMethod.POST)
    public  String searchBook(@ModelAttribute("bookSearchForm") BookSearchForm bookSearchForm,Map<String,Object> model){
            if(bookSearchForm.getSearchType().equals("name")){
               model.put("books", bookService.findAllBooksByName(bookSearchForm.getSearchText()));
            }else{
                model.put("books", bookService.findAllBooksByCategory(bookSearchForm.getSearchText()));
            }
               return "allbooks";
    }

}
