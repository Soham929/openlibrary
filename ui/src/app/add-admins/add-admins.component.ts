import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {FormBuilder , FormControl, FormGroup, Validators} from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-admins',
  templateUrl: './add-admins.component.html',
  styleUrls: ['./add-admins.component.css']
})
export class AddAdminsComponent implements OnInit {

  adminsForm : FormGroup;
  get username(): FormControl{
    return this.adminsForm.get("username") as FormControl;
  }
  get password(): FormControl{
    return this.adminsForm.get("password") as FormControl;
  }
  constructor(private formbuilder: FormBuilder,private http: HttpClient,private router: Router ){ 
    this.adminsForm = this.formbuilder.group({
      id:['', Validators.required],
      name:['',],
      username:['', Validators.required],
      password:['', Validators.required]
    })
  }

  ngOnInit(): void {
  }

  saveAdmin(){
    let adminData = this.adminsForm.value;
    this.http.post('http://localhost:8080/admin/saveAdmin',adminData)
    .subscribe(response => {
      console.log("Admin saved to DB",response)
      this.router.navigateByUrl('/admin')
    },error =>{
      console.error("Error in admin save",error)
    }
    );
  }


}
