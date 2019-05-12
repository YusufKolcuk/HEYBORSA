import { TestBed } from '@angular/core/testing';

import { SoruServiceService } from './soru-service.service';

describe('SoruServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SoruServiceService = TestBed.get(SoruServiceService);
    expect(service).toBeTruthy();
  });
});
