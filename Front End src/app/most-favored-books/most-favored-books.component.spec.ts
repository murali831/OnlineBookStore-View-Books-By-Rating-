import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostFavoredBooksComponent } from './most-favored-books.component';

describe('MostFavoredBooksComponent', () => {
  let component: MostFavoredBooksComponent;
  let fixture: ComponentFixture<MostFavoredBooksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostFavoredBooksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostFavoredBooksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
