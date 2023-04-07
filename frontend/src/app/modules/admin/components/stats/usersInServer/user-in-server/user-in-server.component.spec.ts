import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserInServerComponent } from './user-in-server.component';

describe('UserInServerComponent', () => {
  let component: UserInServerComponent;
  let fixture: ComponentFixture<UserInServerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserInServerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserInServerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
