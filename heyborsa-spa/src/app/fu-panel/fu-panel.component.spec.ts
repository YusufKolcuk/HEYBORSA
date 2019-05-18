import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuPanelComponent } from './fu-panel.component';

describe('FuPanelComponent', () => {
  let component: FuPanelComponent;
  let fixture: ComponentFixture<FuPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
