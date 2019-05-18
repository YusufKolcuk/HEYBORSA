import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FuPanelContentComponent } from './fu-panel-content.component';

describe('FuPanelContentComponent', () => {
  let component: FuPanelContentComponent;
  let fixture: ComponentFixture<FuPanelContentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FuPanelContentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FuPanelContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
