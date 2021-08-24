import { Component, OnInit } from '@angular/core';
import { TransactionValid } from 'src/app/models/transaction-valid.model';
import { TransactionValidService } from './transaction-valid.service';


@Component({
  selector: 'app-transaction-valid',
  templateUrl: './transaction-valid.component.html',
  styleUrls: ['./transaction-valid.component.css']
})
export class TransactionValidComponent implements OnInit {

  title = 'Fetch valid data only from server'
  
  transactions? : TransactionValid []

  constructor(private service:TransactionValidService) { }

  ngOnInit(): void {
    this.service.showTransactions().subscribe(response=>{this.transactions=response});
  }

}
