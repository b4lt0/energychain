import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Packet } from '../_models/packet.model';


import { Observable } from 'rxjs';
import { User } from '../_models/user.model';
import { Type } from '@angular/compiler/src/core';


const API_URL = 'http://localhost:8080/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class PacketService {

  constructor(private http: HttpClient) { }

  public getAllPackets(): Observable<any> {
    return this.http.get(API_URL+`packet/all`);
  }

  public findPacketbyID(packetID: string|null): Observable<Packet> {
    return this.http.get<Packet>(`${API_URL}packet/findbyID/${packetID}`);
  }

  addPacket(title: string, description: string, quantity: number, price: number, type: Type, owner: string): Observable<any> {
    return this.http.post(API_URL + 'packet/add', {
      title,
      description,
      quantity,
      price,
      type,
      owner
    }, httpOptions);
  }

  updatePacket(id:string, owner:string, title:string,description: string, quantity: number, price: number, type: Type): Observable<any> {
    return this.http.put(API_URL + 'packet/update', {
      id,
      owner,
      title,
      description,
      quantity,
      price,
      type
    }, httpOptions);
  }

  public deletePacket(packetId: string): Observable<void> {
    return this.http.delete<void>(`${API_URL}packet/delete/${packetId}`);
  }

}

  

/*
const API_URL = 'http://localhost:8080/api/test/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }
}
*/
