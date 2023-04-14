import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DownloadedRecipesComponent } from './downloaded-recipes.component';

describe('DownloadedRecipesComponent', () => {
  let component: DownloadedRecipesComponent;
  let fixture: ComponentFixture<DownloadedRecipesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DownloadedRecipesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DownloadedRecipesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
