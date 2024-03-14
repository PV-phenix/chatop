import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaysDetailLinechartComponent } from './pays-detail-linechart.component';

describe('PaysDetailLinechartComponent', () => {
  let component: PaysDetailLinechartComponent;
  let fixture: ComponentFixture<PaysDetailLinechartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaysDetailLinechartComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PaysDetailLinechartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
