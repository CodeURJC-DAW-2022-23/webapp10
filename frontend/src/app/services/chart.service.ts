import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = '/api/users';

@Injectable({
  providedIn: 'root'
})
export class ChartService {

  constructor(private httpClient: HttpClient) {}

  getUsersInServer():Observable<any>{
    return this.httpClient.get(BASE_URL+'/admin/stats/users');
  }

  getAllDiets():Observable<any>{
    return this.httpClient.get(BASE_URL+'/admin/stats/diets/all');
  }

  getDietsByType():Observable<any>{
    return this.httpClient.get(BASE_URL+'/admin/stats/diets');
  }

}
