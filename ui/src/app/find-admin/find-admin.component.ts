import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-find-admin',
  templateUrl: './find-admin.component.html',
  styleUrls: ['./find-admin.component.css']
})
export class FindAdminComponent implements OnInit {

  constructor(private router: Router, private http: HttpClient) { }

  name: string = '';
  admin: any = {};
  errorMessage: string = '';
  // message: string = 'Error in fetching book!!';
  
  ngOnInit(): void {
  }

  findAdminByName() {
  // const url = `http://localhost:8080/book/findbyid/${this.bookId}`;
  const url = 'http://localhost:8080/admin/findbyname/' +this.name;
  // this.errorMessage = ''; 
  this.http.get(url).subscribe(
    (response: any) => {
      this.admin = response;
      console.log('Admin found succesfully!!')
    },
    (error) => {
      this.errorMessage = error.message;
      console.error('Error in fetching admin:', error);
      this.admin = {};
    }
  );
}
 
}

