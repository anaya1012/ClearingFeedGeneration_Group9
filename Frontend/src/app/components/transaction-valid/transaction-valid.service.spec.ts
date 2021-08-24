import { TestBed } from '@angular/core/testing';

import { TransactionValidService } from './transaction-valid.service';

describe('TransactionValidService', () => {
  let service: TransactionValidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionValidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
