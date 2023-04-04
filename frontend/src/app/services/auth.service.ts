import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private user: any;

  constructor() { }

  setUser(user: any) {
    this.user = user;
  }

  getUser() {
    return this.user;
  }

  isUserWorker() {
    return this.user && this.user.role === 'worker';
  }

  isUserClient() {
    return this.user && this.user.role === 'client';
  }

  isUserAdmin() {
    return this.user && this.user.role === 'admin';
  }

  isUserDeletePermitted() {
    return this.user && (this.user.role === 'admin' || this.user.role === 'worker');
  }

  logout() {
    this.user = null;
  }

}
