import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BestSellingBooksComponent } from './best-selling-books.component';

describe('BestSellingBooksComponent', () => {
  let component: BestSellingBooksComponent;
  let fixture: ComponentFixture<BestSellingBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BestSellingBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BestSellingBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
