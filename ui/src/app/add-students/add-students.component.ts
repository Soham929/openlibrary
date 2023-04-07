import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-students',
  templateUrl: './add-students.component.html',
  styleUrls: ['./add-students.component.css']
})
export class AddStudentsComponent implements OnInit {

  studentsForm : FormGroup;
  constructor(private formbuilder: FormBuilder,private http: HttpClient,private router: Router ) { 
    this.studentsForm = this.formbuilder.group({
      id:['', Validators.required],
      name:['',Validators.required],
      rollnumber:['',],
      birthdate:['',],
      mobilenumber:['',],
      department:['',]
    })
  }

  ngOnInit(): void {
  }

  saveStudent(){
    let stuData = this.studentsForm.value;
    this.http.post('http://localhost:8080/students/saveStudent',stuData)
    .subscribe(response => {
      console.log("Student saved to DB",response)
      this.router.navigateByUrl('/student')
    },error =>{
      console.error("Error in student save",error)
    }
    );
  }
}
