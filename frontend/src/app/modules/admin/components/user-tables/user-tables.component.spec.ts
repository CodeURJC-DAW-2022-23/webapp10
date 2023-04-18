import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserTablesComponent } from './user-tables.component';

describe('UserTablesComponent', () => {
  let component: UserTablesComponent;
  let fixture: ComponentFixture<UserTablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserTablesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
