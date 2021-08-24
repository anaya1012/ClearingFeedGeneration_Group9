import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransactionValid } from 'src/app/models/transaction-valid.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionValidService {

  baseApiUrl = "http://localhost:8080/current_valid"

  constructor(private http:HttpClient) { }

  public showTransactions():Observable<TransactionValid[]>{
      return this.http.get<TransactionValid[]>(this.baseApiUrl)
      
  }
}
