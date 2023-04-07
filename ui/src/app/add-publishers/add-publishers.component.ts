import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-publishers',
  templateUrl: './add-publishers.component.html',
  styleUrls: ['./add-publishers.component.css']
})
export class AddPublishersComponent implements OnInit {

  publishersForm : FormGroup;
  constructor(private formbuilder: FormBuilder,private http: HttpClient,private router: Router ) { 
    this.publishersForm = this.formbuilder.group({
      id:['', Validators.required],
      name:['',],
      address:['',],
      phone:['',],
      email:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  savePublisher(){
    let pubData = this.publishersForm.value;
    this.http.post('http://localhost:8080/publishers/savePublisher',pubData)
    .subscribe(response => {
      console.log("Publisher saved to DB",response)
      this.router.navigateByUrl('/publisher')
    },error =>{
      console.error("Error in publisher save",error)
    }
    );
  }

}
