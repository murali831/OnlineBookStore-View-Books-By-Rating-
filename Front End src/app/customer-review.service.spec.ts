import { TestBed } from '@angular/core/testing';

import { CustomerReviewService } from './customer-review.service';

describe('CustomerReviewService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CustomerReviewService = TestBed.get(CustomerReviewService);
    expect(service).toBeTruthy();
  });
});
