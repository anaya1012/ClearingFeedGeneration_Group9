import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransactionInvalid } from 'src/app/models/transaction-invalid.model';

@Injectable({
  providedIn: 'root'
})
export class TransactionInvalidService {

  baseApiUrl = "http://localhost:8080/current_invalid"

  constructor(private http:HttpClient) { }

  public showTransactions():Observable<TransactionInvalid[]>{
    return this.http.get<TransactionInvalid[]>(this.baseApiUrl)
  }
}
