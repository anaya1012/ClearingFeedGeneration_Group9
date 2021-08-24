import { Component, OnInit } from '@angular/core';
import { TransactionInvalid } from 'src/app/models/transaction-invalid.model';
import { TransactionInvalidService } from './transaction-invalid.service';


@Component({
  selector: 'app-transaction-invalid',
  templateUrl: './transaction-invalid.component.html',
  styleUrls: ['./transaction-invalid.component.css']
})
export class TransactionInvalidComponent implements OnInit {

  transactions? : TransactionInvalid[];
  constructor(private service:TransactionInvalidService) { }

  ngOnInit(): void {
    this.service.showTransactions().subscribe(response=>{this.transactions=response});
  }

}
