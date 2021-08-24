import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FileDownloadComponent } from './components/file-download/file-download.component';
import { FileUploadComponent } from './components/file-upload/file-upload.component';
import { TransactionInvalidComponent } from './components/transaction-invalid/transaction-invalid.component';
import { TransactionListComponent } from './components/transaction-list/transaction-list.component';
import { TransactionValidComponent } from './components/transaction-valid/transaction-valid.component';

const routes: Routes = [
  { path: "valid", component: TransactionValidComponent },
  { path: "archive", component: TransactionListComponent },
  { path: "invalid", component: TransactionInvalidComponent },
  { path: "upload", component: FileUploadComponent },
  { path: "download", component: FileDownloadComponent } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [
  TransactionListComponent,
  TransactionValidComponent,
  TransactionInvalidComponent,
  FileUploadComponent,
  FileDownloadComponent
]
