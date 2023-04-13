import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { StudentComponent } from './student/student.component';
import { AuthorComponent } from './author/author.component';
import { PublisherComponent } from './publisher/publisher.component';
import { LoanComponent } from './loan/loan.component';
import { AdminComponent } from './admin/admin.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { HomeComponent } from './home/home.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddAdminsComponent } from './add-admins/add-admins.component';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { HttpClientModule } from '@angular/common/http';
import { FindBooksComponent } from './find-books/find-books.component';
import { FindAdminComponent } from './find-admin/find-admin.component'

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    StudentComponent,
    AuthorComponent,
    PublisherComponent,
    LoanComponent,
    AdminComponent,
    SidenavComponent,
    HomeComponent,
    AddBooksComponent,
    AddAdminsComponent,
    AddStudentsComponent,
    AddAuthorsComponent,
    AddPublishersComponent,
    FindBooksComponent,
    FindAdminComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
