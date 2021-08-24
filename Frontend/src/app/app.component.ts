import { Component } from '@angular/core';
import { EventEmitter } from 'protractor';
import { MyService } from './my-services.service';




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Clearing Feed Generation';
  url = "http://localhost:8080/download";
  file?: File;
  download?: File;
  loading: boolean = false;

  constructor(private service: MyService) { }

  ngOnInit(): void {
  }
  
  onChange(event:any) {
    this.file = event.target.files[0];
    this.url = "http://localhost:8080/download";
  }

  onUpload() {
    this.loading = !this.loading;
    console.log(this.file);
    this.service.uploadFile(this.file).subscribe(
        (event) => {
            if (typeof (event) === 'object') {
                this.loading = false; // Flag variable 
            }
        }
    );
   // this.url = this.url + this.file?.name;
}

onDownload(){
  console.log(this.service.downloadFile());
  //.subscribe(response=>{ this.download=response; console.log(this.download)} );
}



}
