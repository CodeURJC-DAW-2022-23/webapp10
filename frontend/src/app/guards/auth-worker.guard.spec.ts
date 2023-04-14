import { TestBed } from '@angular/core/testing';

import { AuthWorkerGuard } from './auth-worker.guard';

describe('AuthWorkerGuard', () => {
  let guard: AuthWorkerGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(AuthWorkerGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
