import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {
  booksForm : FormGroup;
  constructor(private formbuilder: FormBuilder,private http: HttpClient,private router: Router ) { 
    this.booksForm = this.formbuilder.group({
      id:['', Validators.required],
      name:['', Validators.required],
      author:['',Validators.required],
      publicationDate:['',],
      genre:['',],
      subgenre:['',],
      category:['',],
      publisher:['',],
      isbn: ['',Validators.required],
      copies: [5]
    })
  }

  ngOnInit(): void {
  }

  saveBook(){
    let bookData = this.booksForm.value;
    this.http.post('http://localhost:8080/book/saveBook',bookData)
    .subscribe(response => {
      console.log("Book saved to DB",response)
      this.router.navigateByUrl('/books')
    },error =>{
      console.error("Error in book save",error)
    }
    );
  }
}