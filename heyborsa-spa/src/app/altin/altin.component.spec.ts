import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AltinComponent } from './altin.component';

describe('AltinComponent', () => {
  let component: AltinComponent;
  let fixture: ComponentFixture<AltinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AltinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AltinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
