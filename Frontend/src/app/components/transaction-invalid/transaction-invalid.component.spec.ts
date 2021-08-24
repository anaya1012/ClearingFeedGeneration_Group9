import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionInvalidComponent } from './transaction-invalid.component';

describe('TransactionInvalidComponent', () => {
  let component: TransactionInvalidComponent;
  let fixture: ComponentFixture<TransactionInvalidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionInvalidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionInvalidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
