import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DovizComponent } from './doviz.component';

describe('DovizComponent', () => {
  let component: DovizComponent;
  let fixture: ComponentFixture<DovizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DovizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DovizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
