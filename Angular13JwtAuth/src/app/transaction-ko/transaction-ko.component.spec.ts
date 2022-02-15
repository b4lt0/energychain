import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionKOComponent } from './transaction-ko.component';

describe('TransactionKOComponent', () => {
  let component: TransactionKOComponent;
  let fixture: ComponentFixture<TransactionKOComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionKOComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionKOComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
