package com.aluracursos.literalura.main;

import com.aluracursos.literalura.model.*;
import com.aluracursos.literalura.repository.BookRepository;
import com.aluracursos.literalura.service.APIConsume;
import com.aluracursos.literalura.service.ConvertData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private APIConsume apiConsume = new APIConsume();
    private final String URL = "https://gutendex.com/";
    private ConvertData converter = new ConvertData();
    private List<BookData> bookData = new ArrayList<>();
    private BookRepository repository;
    private List<Author> authors;
    private Optional<Book> book;
    private Optional<Author> author;

    public Main(BookRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            System.out.println("""
                1 - Search book by title 
                2 - Show registered books
                3 - Show registered authors
                4 - Show registered authors by century
                5 - Show registered books by language
                
                0 - Exit
                """);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    findAllBooks();
                    break;
                case 3:
                    findAllAuthors();
                    break;
                case 4:
                    findAuthorsByYear();
                    break;
                case 5:
                    findBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Thanks for using Literalura");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    private BookData getDatosSerie() {
        System.out.println("Type the book title: ");
        var title = sc.nextLine();
        var json = apiConsume.getData(URL + title.replace(" ", "+"));
        System.out.println(json);
        return converter.getData(json, BookData.class);
    }

    private void searchBook() {
        BookData data = getBookData();
        Author author = new Author(data);
        repository.save(author);
        System.out.println(data);
    }

    private void findAllBooks() {
        authors = repository.findAll();

        authors.forEach(System.out::println);
    }

    private void findAllAuthors() {

    }

    private void findAuthorsByYear() {

    }

    private void findBooksByLanguage() {

    }

}

