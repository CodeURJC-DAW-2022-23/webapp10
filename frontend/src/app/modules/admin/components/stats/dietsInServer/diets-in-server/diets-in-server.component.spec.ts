import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietsInServerComponent } from './diets-in-server.component';

describe('DietsInServerComponent', () => {
  let component: DietsInServerComponent;
  let fixture: ComponentFixture<DietsInServerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DietsInServerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DietsInServerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
