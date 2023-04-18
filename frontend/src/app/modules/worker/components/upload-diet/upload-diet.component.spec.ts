import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadDietComponent } from './upload-diet.component';

describe('UploadDietComponent', () => {
  let component: UploadDietComponent;
  let fixture: ComponentFixture<UploadDietComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadDietComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UploadDietComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
