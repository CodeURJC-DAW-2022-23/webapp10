import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { User } from '../models/User.model';
import { Form } from '../models/Formulary.model';
import { Diet } from '../models/Diet.model';
import { recipe } from '../models/Recepie.model';

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(private httpClient: HttpClient) {}

  getMe() {
    return this.httpClient.get(BASE_URL + '/me', { withCredentials: true });
  }

  register(formData: FormData) {
    return this.httpClient.post(BASE_URL + '/', formData);
  }

  downloadImage(user: User) {
    return user.image ? BASE_URL + '/me/image' : user.image;
  }

  editProfile(id: number, formData: FormData) {
    return this.httpClient
      .patch(BASE_URL + '/' + id, formData, { withCredentials: true })
      .pipe(catchError((error) => this.handleError(error)));
  }

  editImage(id: number, formData: FormData) {
    return this.httpClient
      .put(BASE_URL + '/' + id + '/image', formData, { withCredentials: true })
      .pipe(catchError((error) => this.handleError(error)));
  }



  private handleError(error: any) {
    console.log('ERROR:');
    console.error(error);
    return throwError('Server error (' + error.status + '): ' + error.text());
  }

  //adminUser
  getUserById(id: number) {
    return this.httpClient.get(BASE_URL + '/me' + id).pipe();
  }

  getUserByTypeWorker(n: number) {
    return this.httpClient.get(BASE_URL + '?type=worker'  + '&page=' + n);
  }

  getUserByTypeClient(n: number) {
    return this.httpClient.get(BASE_URL + '?type=client'  + '&page=' + n);
  }

  addWorker(worker: User) {
    return this.httpClient
      .post(BASE_URL + '/workers/', worker)
      .pipe(catchError((error) => this.handleError(error)));
  }

  getUserInServerInMonth() {
    return this.httpClient.get(BASE_URL + '/admin/stats/users').pipe();
  }

  deleteUser(id: number[]) {
    return this.httpClient
      .delete(BASE_URL + '?ids=' + id)
  }


  getDietsByType() {
    return this.httpClient.get(BASE_URL + '/admin/stats/diets').pipe();
  }

  //Client

  getPersonalForm() {
    return this.httpClient.get('api/forms/me').pipe();
  }

  getClientStats() {
    return this.httpClient.get(BASE_URL + '/me/stats').pipe();
  }

  getUserDiet() {
    return this.httpClient.get(BASE_URL + '/me/diets').pipe();
  }

  getUserRecipes() {
    return this.httpClient.get(BASE_URL + '/me/recepies').pipe();
  }

  postForm(Form: Form) {
    return this.httpClient
      .post('/api/forms/', Form)
      .pipe(catchError((error) => this.handleError(error)));
  }

  //Worker

  getDiets() {
    return this.httpClient.get('/api/diets').pipe();
  }

  getAllRecipes(n: number) {
    return this.httpClient.get("/api/recepies" + '?page=' + n);
  }

  postRecipes(recepies: recipe) {
    return this.httpClient
      .post('/api/forms/', recepies)
      .pipe(catchError((error) => this.handleError(error)));
  }

  deleteDiet(id: number) {
    return this.httpClient
      .delete('/api/diets?ids=' + id)
      .pipe(catchError((error) => this.handleError(error)));
  }

  postDiet(diet: Diet) {
    return this.httpClient
      .post('/api/forms/', diet)
      .pipe(catchError((error) => this.handleError(error)));
  }

  postImageRecipes(n: number, formData: FormData) {
    return this.httpClient
      .post('/api/recepies/image?id=' + n, formData)
      .pipe(catchError((error) => this.handleError(error)));
  }
}
