import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoPackComponent } from './info-pack.component';

describe('InfoPackComponent', () => {
  let component: InfoPackComponent;
  let fixture: ComponentFixture<InfoPackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InfoPackComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoPackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
