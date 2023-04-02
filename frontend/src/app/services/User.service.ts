import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { catchError, Observable, throwError } from "rxjs";
//import { Page } from "../models/rest/page.model";
import { User } from "../models/User.model";

const BASE_URL = '/api/users';

@Injectable({ providedIn: 'root' })
export class UserService {

    constructor(private httpClient: HttpClient) { }

    getMe() {
        return this.httpClient.get(BASE_URL + '/me', { withCredentials: true })
    }

    register(formData: FormData) {
        return this.httpClient.post(BASE_URL + "/", formData);
    }

    downloadImage(user: User) {
        return user.image ? BASE_URL + '/me/image' : user.image;
    }


    editProfile(id: number, formData: FormData) {
        return this.httpClient.patch(BASE_URL + '/' + id, formData, { withCredentials: true })
            .pipe(
                catchError(error => this.handleError(error))
            );
    }

    editImage(id: number, formData: FormData) {
        return this.httpClient.put(BASE_URL + '/' + id + '/image', formData, { withCredentials: true })
            .pipe(
                catchError(error => this.handleError(error))
            );
    }

    editPassword(id: number, formData: FormData) {
        return this.httpClient.patch(BASE_URL + '/' + id + '/password', formData, { withCredentials: true })
            .pipe(
                catchError(error => this.handleError(error))
            );
    }

    private handleError(error: any) {
        console.log("ERROR:");
        console.error(error);
        return throwError("Server error (" + error.status + "): " + error.text())
    }

    //adminUser
    getUserById(id: number){
      return this.httpClient.get(BASE_URL + '/me' + id).pipe();
    }

    getUserByType(type:string){
      return this.httpClient.get(BASE_URL);
    }

    addWorker(worker: User) {
        return this.httpClient.post(BASE_URL + 'users/workers/', worker)
          .pipe(
            catchError(error => this.handleError(error))
          );
    }

}
