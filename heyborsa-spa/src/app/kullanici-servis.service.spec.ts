import { TestBed } from '@angular/core/testing';

import { KullaniciServisService } from './kullanici-servis.service';

describe('KullaniciServisService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KullaniciServisService = TestBed.get(KullaniciServisService);
    expect(service).toBeTruthy();
  });
});
