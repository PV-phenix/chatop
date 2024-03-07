import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaysListPiechartComponent } from './pays-list-piechart.component';

describe('PaysListPiechartComponent', () => {
  let component: PaysListPiechartComponent;
  let fixture: ComponentFixture<PaysListPiechartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaysListPiechartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaysListPiechartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
