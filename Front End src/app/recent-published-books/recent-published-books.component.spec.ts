import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentPublishedBooksComponent } from './recent-published-books.component';

describe('RecentPublishedBooksComponent', () => {
  let component: RecentPublishedBooksComponent;
  let fixture: ComponentFixture<RecentPublishedBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecentPublishedBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecentPublishedBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
