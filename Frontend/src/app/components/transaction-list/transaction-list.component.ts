import { Component, OnInit } from '@angular/core';
import { TransactionArchive } from 'src/app/models/transaction-list.model';
import { TransactionListService } from './transaction-list.service';


@Component({
  selector: 'app-transaction-list',
  templateUrl: './transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

  transactions? : TransactionArchive[];
  constructor(private service:TransactionListService) { }

  ngOnInit(): void {
     this.service.showTransactions().subscribe(response=>{this.transactions=response});
  }

}
