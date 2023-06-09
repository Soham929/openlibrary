import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-find-books',
  templateUrl: './find-books.component.html',
  styleUrls: ['./find-books.component.css']
})
export class FindBooksComponent implements OnInit {

  constructor(private router: Router, private http: HttpClient) { }

  bookId: string = '';
  books: any = {};
  errorMessage: string = '';
  // message: string = 'Error in fetching book!!';
  
  ngOnInit(): void {
  }

findBookByID() {
  // const url = `http://localhost:8080/book/findbyid/${this.bookId}`;
  const url = 'http://localhost:8080/book/findbyid/' +this.bookId;
  // this.errorMessage = ''; 
  this.http.get(url).subscribe(
    (response: any) => {
      this.books = response;
      console.log('book found succesfully!!');
    },
    (error) => {
      this.errorMessage = error.message;
      console.error('Error in fetching book:', error);
      this.books = {};
    }
  );
}

}
