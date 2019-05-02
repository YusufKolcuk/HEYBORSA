import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BorsaComponent } from './borsa.component';

describe('BorsaComponent', () => {
  let component: BorsaComponent;
  let fixture: ComponentFixture<BorsaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BorsaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BorsaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
