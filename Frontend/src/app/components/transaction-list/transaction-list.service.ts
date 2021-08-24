import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransactionArchive } from 'src/app/models/transaction-list.model';

//import { Transaction } from './transaction-list/transaction-list.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionListService {

  baseApiUrl = "http://localhost:8080/archive"

  constructor(private http:HttpClient) { }

  public showTransactions():Observable<TransactionArchive[]>{
      return this.http.get<TransactionArchive[]>(this.baseApiUrl)   
  }
}
