import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCustomerdetailsComponent } from './view-customerdetails.component';

describe('ViewCustomerdetailsComponent', () => {
  let component: ViewCustomerdetailsComponent;
  let fixture: ComponentFixture<ViewCustomerdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewCustomerdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCustomerdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
