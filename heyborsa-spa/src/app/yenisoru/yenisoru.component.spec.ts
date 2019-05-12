import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YenisoruComponent } from './yenisoru.component';

describe('YenisoruComponent', () => {
  let component: YenisoruComponent;
  let fixture: ComponentFixture<YenisoruComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YenisoruComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YenisoruComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
