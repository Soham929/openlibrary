import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAdminsComponent } from './add-admins/add-admins.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';
import { FindBooksComponent } from './find-books/find-books.component';
import { FindAdminComponent } from './find-admin/find-admin.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  
  {
    path: "books",
    component: BookComponent
  },

  {
    path: "student",
    component: StudentComponent
  },
  {
    path: "loan",
    component: LoanComponent
  },
  {
    path: "publisher",
    component: PublisherComponent
  },
  {
    path: "admin",
    component: AdminComponent
  },
  {
    path: "author",
    component: AuthorComponent
  },
  {
    path: 'add-books',
    component: AddBooksComponent,
  },
  {
    path: 'add-admins',
    component: AddAdminsComponent,
  },
  {
    path: 'add-students',
    component: AddStudentsComponent,
  },
  {
    path: 'add-authors',
    component: AddAuthorsComponent,
  },
  {
    path: 'add-publishers',
    component: AddPublishersComponent,
  },
  {
    path: 'find-books',
    component: FindBooksComponent,
  },
  {
    path: 'find-admin',
    component: FindAdminComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
