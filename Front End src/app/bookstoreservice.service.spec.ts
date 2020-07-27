import { TestBed } from '@angular/core/testing';

import { BookstoreserviceService } from './bookstoreservice.service';

describe('BookstoreserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookstoreserviceService = TestBed.get(BookstoreserviceService);
    expect(service).toBeTruthy();
  });
});
