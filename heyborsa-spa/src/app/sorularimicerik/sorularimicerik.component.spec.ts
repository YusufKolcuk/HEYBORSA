import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SorularimicerikComponent } from './sorularimicerik.component';

describe('SorularimicerikComponent', () => {
  let component: SorularimicerikComponent;
  let fixture: ComponentFixture<SorularimicerikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SorularimicerikComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SorularimicerikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
