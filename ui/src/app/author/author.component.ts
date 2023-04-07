import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  
  title = "Author Management"
  authors:any = [];
  // authors = []
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllAuthors()
  }

  fetchAllAuthors(){
    this.http.get('http://localhost:8080/authors/getAuthor')
    .subscribe(resp =>{
      this.authors = resp;
      console.log('Authors retrieved successfully: ',this.authors)
    },error => {
      console.error('Error retrieving authors: ',error);
    }
    );
  }

  deleteAuthor(aId : Number){
    const url = 'http://localhost:8080/authors/deleteAuthor/'+aId
    console.log(aId)
    this.http.delete(url)
    .subscribe(resp => {
      console.log("Author deleted successfully")
      this.fetchAllAuthors();
    },error =>{
      console.error('Error deleting author: ',error);
    }
    );
    
  }

  addAuthors(){
    console.log("addAuthors button clicked!!")
    this.router.navigateByUrl('/add-authors')
  }
}
