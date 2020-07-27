import { TestBed } from '@angular/core/testing';

import { UpdateuserprofileserviceService } from './updateuserprofileservice.service';

describe('UpdateuserprofileserviceService', () => {
  let service: UpdateuserprofileserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdateuserprofileserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
