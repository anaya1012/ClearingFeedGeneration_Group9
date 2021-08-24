import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FileDownloadService {

  baseApiUrl = "http://localhost:8080"
  constructor(private http:HttpClient) { }

  downloadFile() : string{  
  //return this.http.get<any>(this.baseApiUrl);
  return window.URL.createObjectURL(this.http.get<any>(this.baseApiUrl))
  }
}
