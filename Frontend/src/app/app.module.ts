import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { FileUploadService } from './components/file-upload/file-upload.service';
import { TransactionListService } from './components/transaction-list/transaction-list.service';
import { TransactionValidService } from './components/transaction-valid/transaction-valid.service';
import { TransactionInvalidService } from './components/transaction-invalid/transaction-invalid.service';
import { ClearTransactionsService } from './components/clear-transactions/clear-transactions.service';

@NgModule({
  declarations: [
    AppComponent,
    routingComponents
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    RouterModule,         
    HttpClientModule
  ],
  providers: [
    TransactionListService,
    TransactionValidService,
    TransactionInvalidService,
    FileUploadService,
    ClearTransactionsService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
