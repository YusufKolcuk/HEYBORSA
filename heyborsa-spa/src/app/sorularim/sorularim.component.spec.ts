import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SorularimComponent } from './sorularim.component';

describe('SorularimComponent', () => {
  let component: SorularimComponent;
  let fixture: ComponentFixture<SorularimComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SorularimComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SorularimComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
