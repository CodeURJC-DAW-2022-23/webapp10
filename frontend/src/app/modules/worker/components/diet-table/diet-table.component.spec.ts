import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietTableComponent } from './diet-table.component';

describe('DietTableComponent', () => {
  let component: DietTableComponent;
  let fixture: ComponentFixture<DietTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DietTableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DietTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
