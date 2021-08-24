import { TestBed } from '@angular/core/testing';

import { TransactionInvalidService } from './transaction-invalid.service';

describe('TransactionInvalidService', () => {
  let service: TransactionInvalidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransactionInvalidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
