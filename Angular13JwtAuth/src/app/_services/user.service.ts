import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../_models/user.model';

const API_URL = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

enum eOperation { Add, Withdraw }

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'api/test/all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'api/test/user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'api/test/mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'api/test/admin', { responseType: 'text' });
  }

  findUser(userId: string) {
    return this.http.get(`${API_URL}user/findUserbyID/${userId}`);
  }

  updateUser(id: string, username: string, password: string): Observable<any> {
    return this.http.put(API_URL + 'user/update', {
      id,
      username,
      password
    }, httpOptions);
  }
 

  public deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>(`${API_URL}user/delete/${userId}`);
  }

  depositMoney(id: string, money: number, operation: eOperation) {
    return this.http.put(API_URL + 'user/deposit', {
      id,
      money,
      operation
    }, httpOptions);
  }

}
