import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransactionOKComponent } from './transaction-ok.component';

describe('TransactionOKComponent', () => {
  let component: TransactionOKComponent;
  let fixture: ComponentFixture<TransactionOKComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransactionOKComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TransactionOKComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
