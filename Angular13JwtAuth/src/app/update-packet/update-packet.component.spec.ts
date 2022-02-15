import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePacketComponent } from './update-packet.component';

describe('UpdatePacketComponent', () => {
  let component: UpdatePacketComponent;
  let fixture: ComponentFixture<UpdatePacketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePacketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePacketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
