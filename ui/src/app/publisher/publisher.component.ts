import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  title = "Publishers Management"
  publishers:any = [];
 
  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchAllPublishers()
  }

  fetchAllPublishers(){
    this.http.get('http://localhost:8080/publishers/getPublisher')
    .subscribe(resp =>{
      this.publishers = resp;
      console.log('Publishers retrieved successfully: ',this.publishers)
    },error => {
      console.error('Error retrieving publishers: ',error);
    }
    );
  }

  deletePublisher(pubId : Number){
    const url = 'http://localhost:8080/publishers/delete/'+pubId
    console.log(pubId)
    this.http.delete(url)
    .subscribe(resp => {
      console.log("Publisher deleted successfully")
      this.fetchAllPublishers();
    },error =>{
      console.error('Error deleting publisher: ',error);
    }
    );
    
  }

  addPublishers(){
    console.log("addPublishers button clicked!!")
    this.router.navigateByUrl('/add-publishers')
  }
}
