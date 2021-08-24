import { Component, OnInit } from '@angular/core';
import { FileDownloadService } from './file-download.service';

@Component({
  selector: 'app-file-download',
  templateUrl: './file-download.component.html',
  styleUrls: ['./file-download.component.css']
})
export class FileDownloadComponent implements OnInit {

  constructor(private service:FileDownloadService) { }

  url = "http://localhost:8080/download";
  file?: File;
  download?: File;

  ngOnInit(): void {
    this.service.downloadFile();
    //console.log(this.service.downloadFile());
  }

}
