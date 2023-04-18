import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewWorkerComponent } from './new-worker.component';

describe('NewWorkerComponent', () => {
  let component: NewWorkerComponent;
  let fixture: ComponentFixture<NewWorkerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewWorkerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewWorkerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
