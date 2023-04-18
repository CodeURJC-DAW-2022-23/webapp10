import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadRecipeComponent } from './upload-recipe.component';

describe('UploadRecipeComponent', () => {
  let component: UploadRecipeComponent;
  let fixture: ComponentFixture<UploadRecipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UploadRecipeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UploadRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
